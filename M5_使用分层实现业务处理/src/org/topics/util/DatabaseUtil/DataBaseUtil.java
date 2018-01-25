package org.topics.util.DatabaseUtil;
import java.sql.*;

public class DataBaseUtil {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/TopicDB?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String username="root";
    private static String password="8686886wscq";
    
    static{
    	try {
			Class.forName(driver);
			System.out.println("���������ɹ���");
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();
		}
    }
    
    public static Connection getConnect(){
    	Connection conn = null;
    	try {
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("�������ݿ�ɹ���");
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�");
			e.printStackTrace();
		}
    	return conn;
    }
    
    public static void closeAll(Connection conn,Statement stmt,ResultSet RS){
    	if(RS!=null){
    		try{
    			RS.close();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    	if(stmt!=null){
    		try {
				stmt.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
    	}
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
}
