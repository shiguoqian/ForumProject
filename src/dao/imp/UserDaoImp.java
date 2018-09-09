package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Post;
import bean.User;
import dao.IUserDao;
import oracle.net.aso.r;
import util.DBUtil;
public class UserDaoImp implements IUserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//通过id查询用户信息
	@Override
	//获取user id
	public User getUserById(int id) {
		System.out.println("欢迎进入通过id获取学生对象的方法");
		//创建user
		User user = null;
		conn=DBUtil.getConn();
		String sql = "select * from users where u_id = ?";
		Object[] objs = {id};
		//给pstmt赋值
		try {
			rs = DBUtil.executeQuery(sql, objs);
			while(rs.next()) {
				id = rs.getInt("u_id");
				String name = rs.getString("u_name");
				String pass = rs.getString("u_pass");
				user = new User(name, pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			DBUtil.closeAll(conn, pstmt, rs);	
		}
		return user;
	}
	//登录时查询用户名和密码
		@Override
		public User getUserByNameAndPass(String uName,String pass) {
				conn = DBUtil.getConn();
				User user = null;
				String sql = "select * from users where u_name=? and u_pass=?";
				Object[] objs = {uName,pass};
				rs = DBUtil.executeQuery(sql, objs);
				try {
					 if(rs.next()) {
						int uId = rs.getInt("u_id");
						String uName1 = rs.getString("u_name");
						String uPass = rs.getString("u_pass");
						String uNickName = rs.getString("u_nickname");
						String uCity = rs.getString("u_city");
					    String uSignName = rs.getString("u_signname");
					    String uEmail = rs.getString("u_email");
					    String uSex = rs.getString("u_sex");
					    Date uRegTime = rs.getDate("reg_time");
						user = new User( uId, uName1, uPass, uSex,uEmail, uNickName, uSignName,uCity,uRegTime);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBUtil.closeAll(conn, pstmt, rs);
				}
				return user;
		}
	//注册时输入用户名和密码
	@Override
	public int insertUser(User user) {
		System.out.println("进入插入学生信息dao");
		//获取学生信息
		String name = user.getuName();
		String pass = user.getuPass();
		
		int result = -1;    //数据库中影响的行数
		
		//连接数据库
		DBUtil.getConn();
		//准备sql
		String sql = "insert into users(u_id,u_name,u_pass) values(users_seq.nextVal,?,?) ";
		Object[] objs = {name, pass};
		result = DBUtil.executeUpdate(sql, objs);
		//关闭资源
		DBUtil.closeAll(conn, pstmt, rs);	
		return result;
	}
//////////
	@Override
	public int updateUser(User user) {
		System.out.println("欢迎进入学生信息修改方法Dao层");
		//操作影响数据库的行数
		int result = -1;
		// 连接数据库
		DBUtil.getConn();
		// 3.准备sql语句
		String sql = "UPDATE USERS SET u_email=? , u_nickName=? , u_sex=?  ,u_city=? ,u_signname=?  WHERE u_id=? ";
		//准备参数
		Object[] objs = {user.getuEmail(),user.getuNickName(),user.getuSex(),user.getuCity(),user.getuSignName(),user.getuId()};
		result = DBUtil.executeUpdate(sql, objs);
		//关闭资源
		DBUtil.closeAll(conn, pstmt, rs);
		return result;
	}

	/**
	 * 获取全部用户信息
	 *
	 * 史国茜
	 * @return
	 */
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<>();
		conn = DBUtil.getConn();
		String sql = "select * from users";
		Object[] objects = {};
		rs = DBUtil.executeQuery(sql,objects);
		try {
			while (rs.next()){
				userList.add(new User(rs.getInt("u_id"),rs.getString("u_name"),rs.getString("u_pass"),
						rs.getString("u_sex"),rs.getDate("reg_time"),rs.getDate("login_time"),
						rs.getString("u_email"),rs.getString("u_phone"),rs.getInt("u_post"),rs.getInt("u_collect"),
						rs.getInt("u_atte"),rs.getInt("u_fans"),rs.getInt("u_rank"),rs.getString("u_nickname"),
						rs.getString("u_city")));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int SignById(int uId) {
		int result=-1;
		conn=DBUtil.getConn();
		String sql="insert into sign values(u_id=?,s_time=?)";
		Object []objects= {uId,"sysdate"};
		result=DBUtil.executeUpdate(sql, objects);
		return result;
	}
	
	//用户更改密码
	@Override
	public int updateUserPass(String name,String pass,String newPass) {
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "update users set u_pass = ? where u_name = ? and u_pass = ?";
		Object [] objects = {newPass,name,pass};
		for (int i = 0; i < objects.length; i++) {
			System.out.println(objects[i].toString());
		}
		result=DBUtil.executeUpdate(sql, objects);
		if (result>1) {
			System.out.println(result);
			return result;
		}else {
			System.out.println(result);
			return result;
		}
	}
	
	//查询用户姓名，为判断用户名是否重复做准备
	@Override
	public User getUserByName(String uName) {
		conn = DBUtil.getConn();
		User user = null;
		String sql = "select u_name from users where u_name=?";
		Object[] objs = {uName};
		rs = DBUtil.executeQuery(sql, objs);
		try {
			 if(rs.next()) {
				String name = rs.getString("u_name");
				user = new User(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return user;
	}
/**
 * 判断用户登录身份   1代表普通用户  2代表系统管理员
 */
	@Override
	public int userLoginByRole(String name) {
	int rId=0;
		try {
			//连接数据库
			conn=DBUtil.getConn();
			//准备sql语句
			String sql="SELECT r.r_id FROM ROLE r WHERE r.r_id=( " + 
					"SELECT ur.r_id FROM User_Role ur WHERE ur.u_id=( " + 
					"SELECT u.u_id FROM USERS u WHERE u.u_name=?))";
			//准备字段参数,代表占位符参数
			Object[]objs= {name};
			//执行sql语句
			rs=DBUtil.executeQuery(sql, objs);
			if(rs.next()){
				 rId=rs.getInt("r_id");
				System.out.println(rId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rId;
	}

	/**
	 * 删除用户
	 *
	 * 史国茜
	 * @param id
	 * @return
	 */
	@Override
	public int delUserById(int id) {
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "delete users where u_id = ?";
		Object[] objects = {id};
		result = DBUtil.executeUpdate(sql,objects);
		return result;
	}

	/**
	 * 修改头像
	 *
	 * @param uname
	 * @return
	 */
	@Override
	public int updateImgById(String uname,String url) {
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "update users set u_image = ? where u_name = ?";
		Object[] objects = {url,uname};
		result = DBUtil.executeUpdate(sql,objects);
		return result;
	}

	@Override
	public int queryAtteById(int selfId, int friendId) {
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "select att_id from attention where u_id = ?";
		Object[] objects = {selfId};
		rs = DBUtil.executeQuery(sql,objects);
		try {
			if (rs.next()){
				if (friendId==rs.getInt("att_id")){//如果关注表中有该人id
					System.out.println("关注表中有该人id,不能关注");
					result = 1;
				}
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int addFriendById(int selfId, int friendId) {
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "insert into attention values(?,?)";
		Object[] objects = {friendId,selfId};
		result = DBUtil.executeUpdate(sql,objects);
		return result;
	}

	/**
	 * jyz，
	 */
	public User getUserModifyById(int id) {
		System.out.println("欢迎进入通过id获取学生对象的方法");
		//创建user
		User user = null;
		DBUtil.getConn();
		String sql = "select * from users where u_id =?";
		Object[] objs = {id};
		//给pstmt赋值
		try {
			rs = DBUtil.executeQuery(sql, objs);
			while(rs.next()) {
				id = rs.getInt("u_id");
				String sex  = rs.getString("u_sex");
				String email= rs.getString("u_email");
				String nickName=rs.getString("u_nickName");
				String signName=rs.getString("u_signName");
				String city=rs.getString("u_city");
				user = new User(id, sex, email, nickName, signName, city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally {
			//关闭资源
			DBUtil.closeAll(conn, pstmt, rs);	
		}
			
		return user;
		}
	/**
	 * jyz，
	 */
	public int setPassById(int id ,String pass) {
		int result=-1;
		System.out.println("欢迎进入通过id重设密码方法Dao层");
		DBUtil.getConn();
		String sql = "update users set u_pass = ? where u_id = ?";
		Object[] objs = {pass,id};
		try {
			result = DBUtil.executeUpdate(sql, objs);
		}finally {
			//关闭资源
			DBUtil.closeAll(conn, pstmt, rs);	
		}
			
		return result;
	}
}
