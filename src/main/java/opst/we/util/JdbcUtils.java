package opst.we.util;

import java.sql.*;

public final class JdbcUtils {

    public static String MYSQL ="mysql";
    public static String ORACLE ="mysql";

    private static Connection connection = null;
    private static String url = "jdbc:mysql://stzb:3306/stzb?useUnicode=true&characterEncoding=utf8";
    private static String user = "stzb";
    private static String psw = "stzb";

    static {
        if(connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                if(connection==null){
                    connection = DriverManager.getConnection(url, user, psw);
                }
            }  catch (ClassNotFoundException e) {
                e.printStackTrace();
            }  catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }


    public static Connection getConnection() {
        return connection;
    }

    /**
     * 获取数据库的连接 
     * @return conn 
     * @throws SQLException
     */  
    public static Connection getConnection(String url, String user, String psw, String dbType) {
            try {  
            	if(MYSQL.equals(dbType.toLowerCase())){
            		Class.forName("com.mysql.jdbc.Driver");
            	}else if(ORACLE.equals(dbType.toLowerCase())){
            		Class.forName("oracle.jdbc.driver.OracleDriver");
            	}
            	if(connection==null){
                    connection = DriverManager.getConnection(url, user, psw);
            	}
               return connection;
                
            }  catch (ClassNotFoundException e) {
				e.printStackTrace();
			}  catch (SQLException e) {
                e.printStackTrace();  
                throw new RuntimeException(e);
            }
            return null;
        
    }  
      
    /** 
     * 释放资源 
     * @param conn 
     * @param pstmt 
     * @param rs 
     */  
    public static void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if(null != rs) {  
            try {  
                rs.close();  
            } catch (SQLException e) {
                e.printStackTrace();  
                throw new RuntimeException(e);
            } finally {  
                if(null != pstmt) {  
                    try {  
                        pstmt.close();  
                    } catch (SQLException e) {
                        e.printStackTrace();  
                        throw new RuntimeException(e);
                    } finally {  
                        if(null != conn) {  
                            try {  
                                conn.close();  
                            } catch (SQLException e) {
                                e.printStackTrace();  
                                throw new RuntimeException(e);
                            }  
                        }  
                    }  
                }  
            }  
        }  
    }  
    
    
   
}  
