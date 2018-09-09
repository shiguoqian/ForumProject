package service.imp;



import java.util.ArrayList;
import java.util.List;

import bean.Post;
import bean.User;
import dao.IPostDao;
import dao.IUserDao;
import dao.imp.PostDao;
import dao.imp.UserDaoImp;
import service.IUserService;

public class UserServiceImp implements IUserService{
	IUserDao iud  = new UserDaoImp();
	IPostDao PostDao = new PostDao();
	@Override
	public User getUserByNameAndPass(String uName, String pass) {
		return iud.getUserByNameAndPass(uName, pass);
	}

	@Override
	public int updateUserPass(String name, String pass, String newPass) {
		return iud.updateUserPass(name, pass, newPass);
	}

	@Override
	public int insertUser(User user) {
		return iud.insertUser(user);
	}

	@Override
	public User getUserByName(String uName) {
		return iud.getUserByName(uName);
	}
	
	@Override
	public boolean isMatch(String name) {
		User user = iud.getUserByName(name);
		boolean result =false;
		if (user!=null&&!"".equals(user)) {	//如果查到了匹配的
			result=true;	//不能注册
		}
		return result;
	}

	@Override
	public boolean SignById(int u_id) {
		return (iud.SignById(u_id)>0);
	}
	/**
	 * 获取用户的身份     1普通用户     2超级管理员
	 */
		@Override
		public int userLoginByRole(String name) {
			return iud.userLoginByRole(name);
		}
		@Override
		public int sendPost(Post post) {
			PostDao.insertPostByName(post);
			return 0;
		}

	/**
	 * 获取全部用户信息
	 *
	 * 史国茜
	 * @return
	 */
	@Override
		public List<User> getAllUser(){
			return iud.getAllUser();
		}

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@Override
	public boolean delUserById(int id) {
		if (iud.delUserById(id)>0){
			return true;
		}
		return false;
	}

	/**
		 * 共3个，jyz,更新用户信息方法，用于更新邮箱，昵称，性别，签名，所在城市
		 */
		public boolean updateUser(User user) {
		   int result=-1;
		   result=iud.updateUser(user);
		   if (result>0) {
			   System.out.println("更新成功");
			return true;
		}else{
			   System.out.println("更新失败");
			return false;
		}
		}   
	

		/**
		 * jyz
		 * @param id
		 * @return
		 */
		public User getUserModifyById(int id) {
			return iud.getUserModifyById(id);
			
		}

		/**
		 * jyz
		 * @param id
		 * @param pass
		 * @return
		 */
		public boolean setPassById(int id, String pass) {
			System.out.println("进入setPass Service层");
			 int result=-1;
			   result=iud.setPassById(id,pass);
			   if (result>0) {
				   System.out.println("密码重设成功");
				return true;
			}else{
				   System.out.println("密码重设失败");
				return false;
			}
		}

	/**
	 * 修改头像
	 * @param uname
	 * @param url
	 * @return
	 */
	@Override
	public boolean updateImgById(String uname, String url) {
		if (iud.updateImgById(uname,url)>0){
			System.out.println("service:有该人id,不能关注");
			return true;
		}
		return false;
	}

	@Override
	public boolean queryAtteById(int selfId, int friendId) {
		if (iud.queryAtteById(selfId,friendId)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addFriendById(int selfId, int friendId) {
		if (iud.addFriendById(selfId,friendId)>0){
			return true;
		}
		return false;
	}
}
