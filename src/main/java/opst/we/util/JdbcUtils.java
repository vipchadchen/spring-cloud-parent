package opst.we.util;

import java.sql.*;

public final class JdbcUtils {  
    
    /** 
     * 获取数据库的连接 
     * @return conn 
     * @throws SQLException
     */  
    public static Connection getConnection(String url, String user, String psw, String dbType) {
            try {  
            	if("mysql".equals(dbType.toLowerCase())){
            		Class.forName("com.mysql.jdbc.Driver");
            	}else if("oracle".equals(dbType.toLowerCase())){
            		Class.forName("oracle.jdbc.driver.OracleDriver");
            	}
            	
               Connection conn = DriverManager.getConnection(url, user, psw);
               return conn; 
                
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
