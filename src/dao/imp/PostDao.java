package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Message;
import bean.Post;
import dao.IPostDao;
import util.DBUtil;

public class PostDao implements IPostDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public int insertPostByName(Post post) {
		util.DBUtil.getConn();
		String name = post.getuName();
		String title = post.getpTitle();
		String content = post.getpContent();
		String browser = post.getBrowser();

		String version = post.getVersion();
		String type = post.getType();
		String project = post.getProject();
		String experience = post.getExperience();
		String sql = "select u_id from users where u_name = ?";
		Object[] objs = { name };
		rs = util.DBUtil.executeQuery(sql, objs);
		int id = -1;
		try {
			while (rs.next()) {
				id = rs.getInt(1);
			}
			String sql1 = "insert into post VALUES(post_seq.nextVal,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?)";
			Object[] objs1 = { id, title, content, 0, 0, 0, browser, version, type, project, experience, 0 };
			util.DBUtil.executeUpdate(sql1, objs1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 删帖
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	@Override
	public int DelPostById(int pId) {
		// TODO Auto-generated method stub
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "delete post where p_id = ?";
		Object[] objects = {pId};
		result = DBUtil.executeUpdate(sql,objects);
		return result;
	}

	@Override
	public int insertCollectById(int pId) {

		return 0;
	}

	/**
	 * 用户取消收藏贴
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	@Override
	public int delCollectById(int pId) {
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "delete collect where p_id=?";
		Object[] objects = {pId};
		result = DBUtil.executeUpdate(sql,objects);
		return result;
	}

	@Override
	public List<Post> getAllCollectById(int uId) {
		List<Post> collectPost = new ArrayList<>();
		conn = DBUtil.getConn();
		String sql = "select * from post where p_id IN (select p_id from collect where u_id=?)";
		Object[] objs = { uId };
		rs = DBUtil.executeQuery(sql, objs);
		try {
			while (rs.next()) {
				Post post = new Post(rs.getInt("p_id"), rs.getInt("u_id"), rs.getString("p_title"),
						rs.getString("p_content"), rs.getDate("p_time"), rs.getInt("p_isfine"), rs.getInt("p_istop"),
						rs.getInt("like_num"), rs.getString("p_browser"), rs.getString("p_version"),
						rs.getString("p_type"), rs.getString("p_project"), rs.getString("p_experience"),
						rs.getInt("p_check"));
				collectPost.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return collectPost;
	}

	@Override
	public int praisePostById(int uId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Post> getPostsByUId(int id) {
		ArrayList<Post> list = new ArrayList<Post>();
		util.DBUtil.getConn();
		String sql = "select * from post where u_id = ? and p_check=1";
		Object[] objs = { id };
		rs = util.DBUtil.executeQuery(sql, objs);
		try {
			while (rs.next()) {
				Date time = rs.getDate("p_time");
				String title = rs.getString("p_title");
				list.add(new Post(title, time));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Message> showAll() {
		List<Message> allPost = new ArrayList<Message>();
		conn = DBUtil.getConn();
		String sql = "select p.p_id, u.u_id,u.u_name,p.p_title,p.p_time,p.p_type from post p,users u where p.u_id in (select u.u_id from users) and p.p_check=1 order by p_time desc";
		Object[] objs = {};
		rs = DBUtil.executeQuery(sql, objs);
		try {
			while (rs.next()) {
				String type = rs.getString("p_type");
				if ("0".equals(type)) {
					type = "提问";
				} else if ("99".equals(type)) {
					type = "分享";
				} else if ("100".equals(type)) {
					type = "讨论";
				} else if ("101".equals(type)) {
					type = "建议";
				} else if ("168".equals(type)) {
					type = "公告";
				} else if ("169".equals(type)) {
					type = "动态";
				}
				Message message = new Message(rs.getInt("p_id"), rs.getInt("u_id"), rs.getString("u_name"),
						rs.getString("p_title"), rs.getDate("p_time"), type);
				allPost.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allPost;
	}

	/**
	 * wanp
	 */
	@Override
	public ArrayList<Post> getPostsByType(String type) {
		ArrayList<Post> postList = new ArrayList<Post>();
		util.DBUtil.getConn();
		String sql = "select * from post where p_type=? and p_check=1";
		Object[] objs = { type };
		rs = DBUtil.executeQuery(sql, objs);
		try {
			while (rs.next()) {
				Post post = new Post(rs.getInt("p_id"), rs.getInt("u_id"), rs.getString("p_title"),
						rs.getString("p_content"), rs.getDate("p_time"), rs.getInt("p_isfine"), rs.getInt("p_istop"),
						rs.getInt("like_num"), rs.getString("p_browser"), rs.getString("p_version"),
						rs.getString("p_type"), rs.getString("p_project"), rs.getString("p_experience"),
						rs.getInt("p_check"));
				postList.add(post);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postList;
	}

	@Override
	public ArrayList<Message> getAllTopPost() {
		ArrayList<Message> list = new ArrayList<Message>();
		util.DBUtil.getConn();
		String sql = "select p.p_id, u.u_id,u.u_name,p.p_title,p.p_time,p.p_type from post p,users u where p.u_id in (select u.u_id from users) and p.p_check=1 and p.p_istop=1 order by p_time desc";
		Object[] objs = {};
		rs = util.DBUtil.executeQuery(sql, objs);
		try {
			while (rs.next()) {
				String type = rs.getString("p_type");
				if ("0".equals(type)) {
					type = "提问";
				} else if ("99".equals(type)) {
					type = "分享";
				} else if ("100".equals(type)) {
					type = "讨论";
				} else if ("101".equals(type)) {
					type = "建议";
				} else if ("168".equals(type)) {
					type = "公告";
				} else if ("169".equals(type)) {
					type = "动态";
				}
				Message message = new Message(rs.getInt("p_id"), rs.getInt("u_id"), rs.getString("u_name"),
						rs.getString("p_title"), rs.getDate("p_time"), type);
				list.add(message);
			}
			System.out.println("list集合" + list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 审核帖子
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	@Override
	public int passPost(int pId) {
		System.out.println("dao层passPost");
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "update post set p_check = 1 where p_id = ?";
		Object[] objects = {pId};
		result = DBUtil.executeUpdate(sql,objects);
		System.out.println("pId:"+pId+"result:"+result);
		return result;
	}


	/**
	 * 改变帖子置顶状态
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	@Override
	public int topPost(int pId,int topFlag) {
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "update post set p_istop = ? where p_id = ?";
		Object[] objects = {topFlag,pId};
		result = DBUtil.executeUpdate(sql,objects);
		return result;
	}
	/**
	 * 改变精贴状态
	 *
	 * 史国茜
	 * @param pId
	 * @param fineFlag
	 * @return
	 */
	@Override
	public int finePost(int pId, int fineFlag) {
		int result = -1;
		conn = DBUtil.getConn();
		String sql = "update post set p_isfine = ? where p_id = ?";
		Object[] objects = {fineFlag,pId};
		result = DBUtil.executeUpdate(sql,objects);
		return result;
	}

	@Override
	public Post getPostById(int pId) {
		Post post =null;
		conn = DBUtil.getConn();
		String sql = "select * from post where P_id=?";
		Object[] objs = {pId};
		rs = DBUtil.executeQuery(sql, objs);
		try {
			while(rs.next()) {
				 post = new Post(rs.getInt("p_id"), rs.getInt("u_id"), rs.getString("p_title"),
						rs.getString("p_content"), rs.getDate("p_time"), rs.getInt("p_isfine"), rs.getInt("p_istop"),
						rs.getInt("like_num"), rs.getString("p_browser"), rs.getString("p_version"),
						rs.getString("p_type"), rs.getString("p_project"), rs.getString("p_experience"),
						rs.getInt("p_check"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public Message getMessageById(int pId) {
		Message message=null;
		conn = DBUtil.getConn();
		String sql="select p.p_id, p.p_content,u.u_name,p.p_title,p.p_time,p.p_type from post p,users u where p.p_id=? and p.p_check=1 and p.p_istop=1 and u.u_id=(select u_id from post where p_id=?)";
		Object[] objs = {pId,pId};
		rs = DBUtil.executeQuery(sql, objs);
		try {
			while(rs.next()) {
				String type = rs.getString("p_type");
				if ("0".equals(type)) {
					type = "提问";
				} else if ("99".equals(type)) {
					type = "分享";
				} else if ("100".equals(type)) {
					type = "讨论";
				} else if ("101".equals(type)) {
					type = "建议";
				} else if ("168".equals(type)) {
					type = "公告";
				} else if ("169".equals(type)) {
					type = "动态";
				}
				message=new Message(rs.getInt("p_id"), rs.getString("u_name"), rs.getString("p_title"),
						rs.getDate("p_time"), type, rs.getString("p_content"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(conn, pstmt, rs);
		}
		return message;
	}
	

}

