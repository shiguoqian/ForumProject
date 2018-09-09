package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 和数据库有关的工具类
 * @author 
 *
 */
public class DBUtil {
	//声明数据库链接有关的属性
	public static final String URL = "jdbc:oracle:thin:@10.211.55.5:1521:xe";
	public static final String USER = "hr";
	public static final String PASSWORD = "123";
	public static final String DRIVER="oracle.jdbc.OracleDriver";
	
	//声明JDBC有关的对象
	static Connection conn=null;
	static PreparedStatement pstmt=null;
	static ResultSet rs=null;
	
	/**
	 * 获取数据库链接
	 * @return conn对象
	 */
	public static Connection getConn() {
		try {
			//加载数据库驱动
			Class.forName(DRIVER);
			//创建数据库链接
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("数据库驱动类没找到");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("创建数据库链接出现异常");
		}
		return conn;
	}
	
	/**
	 * 关闭所有资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通用查询方法
	 * @param sql   要执行的sql语句
	 * @param objs  要传递的参数
	 * @return
	 */
	public static ResultSet executeQuery(String sql,Object[] objs) {
		pstmt=getPstmt(sql, objs);
		try {
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 通用增删改方法 
	 * @param sql  要执行的sql语句
	 * @param objs 要传递的参数
	 * @return
	 */
	public static int executeUpdate(String sql,Object[] objs) {
		int result=-1;
		pstmt=getPstmt(sql, objs);
		try {
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获取pstmt对象
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static PreparedStatement getPstmt(String sql,Object[] objs) {
		try {
			//获取pstmt对象
			pstmt=conn.prepareStatement(sql);
			//设置参数
			if(objs!=null) {
				for(int i=0;i<objs.length;i++) {
					//依次设置参数
					pstmt.setObject(i+1, objs[i]);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return pstmt;
	}
}
