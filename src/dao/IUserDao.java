package dao;
/**
 * 
 */

import java.util.List;

import bean.Advise;
import bean.Post;
import bean.User;

public interface IUserDao {
	
	User getUserById(int id);//根据用户id查询
	User getUserByNameAndPass(String uName,String pass);//根据用户名和密码查询
	User getUserByName(String uName);
	int insertUser(User user);//添加用户
	int updateUser(User user);//更改信息
	int updateUserPass(String name,String pass,String newPass);//根据原密码修改密码
	List<User> getAllUser();//查询所有用户资料
	List<Post> getAllPost();//查询所有帖子
	int SignById(int uId);//签到
	int setPassById(int id,String pass);//共2个,jyz,通过id重设密码
	User getUserModifyById(int id);//jyz,根据用户id查询
	/**
	 * 识别用户的身份，通过角色的判断，是普通用户还是系统管理员
	 * @param name    登录名
	 * @return        返回用户的身份
	 */
	int userLoginByRole(String name);

	/**
	 * 删除用户
	 *
	 * 史国茜
	 * @param id
	 * @return
	 */
	int delUserById(int id);

	/**
	 * 修改头像
	 * @param uname
	 * @return
	 */
	int updateImgById(String uname,String url);

	/**
	 * 查询该人是否在自己的关注表中
	 *
	 * 史国茜
	 * @param selfId
	 * @param friendId
	 * @return
	 */
	int queryAtteById(int selfId,int friendId);

	/**
	 * 添加好友
	 * @param selfId
	 * @param friendId
	 * @return
	 */
	int addFriendById(int selfId,int friendId);
}
