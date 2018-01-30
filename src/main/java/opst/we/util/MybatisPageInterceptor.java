package opst.we.util;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author: chgj
 * @description:
 * @date: 2018/1/30 14:48
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class MybatisPageInterceptor implements Interceptor {

	
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

	private static String dialect = ""; // 数据库方言
	private static String pageSqlId = ""; // mapper.xml中需要拦截的ID(正则匹配)

	@SuppressWarnings("rawtypes")
	@Override
	public Object intercept(Invocation ivk) throws Throwable {
		if (ivk.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectUtil.getClassField(statementHandler, "delegate");
			// MappedStatement mappedStatement = (MappedStatement)
			// ReflectUtil.getClassField(delegate, "mappedStatement");

			MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
			MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");

//			String methodName = mappedStatement.getId();
//			String[] clss = methodName.split("\\.");
//			String className = methodName.replace("." + clss[clss.length - 1], "");
//			Class<?> clazz = Class.forName(className);

			if (mappedStatement.getId().toLowerCase().endsWith(pageSqlId.toLowerCase())) { // 拦截需要分页的SQL
				BoundSql boundSql = delegate.getBoundSql();
				Object paramObj = boundSql.getParameterObject();// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空

				Page page = null;
				if (paramObj != null) {
					if (paramObj instanceof Page) {
						page = (Page) paramObj;
					} else if (paramObj instanceof Map) {
						Map paramMap = (Map) paramObj;
						for (Object obj : paramMap.values()) {
							if (obj instanceof Page) {
								page = (Page) obj;
								break;
							}
						}
					}
				}

				if (page != null) {
					Connection connection = (Connection) ivk.getArgs()[0];
					String sql = boundSql.getSql();

					// System.out.println(sql);

					String countSql = "select count(0) from (" + sql + ") tmp_count"; // 记录统计
					PreparedStatement countStmt = connection.prepareStatement(countSql);
					BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), paramObj);
					setParameters(countStmt, mappedStatement, countBS, paramObj);
					ResultSet rs = countStmt.executeQuery();
					int count = 0;
					if (rs.next()) {
						count = rs.getInt(1);
					}
					rs.close();
					countStmt.close();
					page.setTotal(count);
					String pageSql = generatePageSql(sql, page);
					BeanUtils.setValue(boundSql, "sql", pageSql); // 将分页sql语句反射回BoundSql.
				}
			}
//			logger.info(BeanUtils.getValue(delegate.getBoundSql(), "sql").toString().trim().replace("\r", "").replace("\n", "").replace("\t", " "));
		}
		// else if (ivk.getTarget() instanceof ResultSetHandler) {
		// Object result = ivk.proceed();
		// if (page != null) {
		// page.setRows((List) result);
		// return page;
		// }
		// return result;
		// }
		return ivk.proceed();
	}

	/**
	 * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.
	 * DefaultParameterHandler
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX) && boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject.getValue(propertyName);
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName + " of statement " + mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
				}
			}
		}
	}

	/**
	 * 根据数据库方言，生成特定的分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	private String generatePageSql(String sql, Page page) {
		if (page != null && !StringUtils.isEmpty(dialect)) {
			if ("mysql".equals(dialect)) {
				return SqlUtils.buildPageSqlForMysql(sql, page);
			} else if ("oracle".equals(dialect)) {
				return SqlUtils.buildPageSqlForOracle(sql, page);
			}
			return sql;
		} else {
			return sql;
		}
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}
	@Override
	public void setProperties(Properties p) {
		dialect = p.getProperty("dialect");
//		if (StringUtils.isEmpty(dialect)) {
//			throw new SYSException("dialect property is not found!");
//		}
		pageSqlId = p.getProperty("pageSqlId");
//		if (StringUtils.isEmpty(pageSqlId)) {
//			throw new SYSException("pageSqlId property is not found!");
//		}
	}

//	private Object executeGet(Connection connection, String sql) throws SQLException {
//		ResultSet rs = connection.prepareStatement(sql).executeQuery();
//		if (rs.next()) {
//			return rs.getObject(1);
//		}
//		return null;
//	}
//
//	private int executeUpdate(Connection connection, String sql) throws SQLException {
//		return connection.prepareStatement(sql).executeUpdate();
//	}
}