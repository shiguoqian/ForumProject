package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import dao.ISignDao;
import util.DBUtil;

public class SignDaoImp implements ISignDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	public int addSignTime(int id) {
		//建立连接
		conn=DBUtil.getConn();
		//准备sql
		String sql="insert into sign values(?,sysdate)";
		//准备参数
		Object [] objs={id};
		//执行
		int result=DBUtil.executeUpdate(sql, objs);
		return result;
	}

	@Override
	public String getSignTime(int id){
		//建立连接
		conn=DBUtil.getConn();
		//准备sql
		String sql="select TO_CHAR(s_time,'YYYY/MM/DD') as s_date from sign where u_id=? ";
		//准备参数
		Object [] objs={id};
		String date=null;
		//执行
		rs=DBUtil.executeQuery(sql, objs);
		try {
			while(rs.next()){
					date=rs.getString("s_date");
					System.out.println(date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return date;
	}

	@Override
	public int showSignTimes(int id) {
		//连接数据库
		conn=DBUtil.getConn();
		//准备参数
		Object[]objs={id};
		//准备sql
		String sql="select count(u_id) as total from sign where u_id=? ";
		//执行sql
		rs=DBUtil.executeQuery(sql, objs);
		int total=-1;
		try {
			while(rs.next()){
					 total=rs.getInt("total");
					System.out.println(total);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

}
