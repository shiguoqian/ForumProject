package service;

import java.util.ArrayList;
import java.util.List;

import bean.Post;
import bean.User;

public interface IUserService {
    User getUserByNameAndPass(String uName, String pass);    //用户登录

    int updateUserPass(String name, String pass, String newPass);//修改密码

    int insertUser(User user);                //注册

    boolean isMatch(String name);

    User getUserByName(String uName);

    boolean SignById(int u_id);

    int userLoginByRole(String name);

    int sendPost(Post post);            //发帖子

    /**
     * 获取全部用户
     *
     * 史国茜
     * @return
     */
    List<User> getAllUser();

    /**
     * 删除用户
     *
     * 史国茜
     * @param id
     * @return
     */
    boolean delUserById(int id);

    boolean updateUser(User user);//jyz,共3个,前端更新昵称等用户信息

    User getUserModifyById(int id);//jyz,根据用户id查询修改后昵称等信息

    boolean setPassById(int id, String pass);//jyz,通过用户名修改密码

    /**
     * 修改头像
     * @param uname
     * @param url
     * @return
     */
    boolean updateImgById(String uname,String url);

    /**
     * 判断该人是否在自己的关注列表里
     * @param selfId
     * @param friendId
     * @return
     */
    boolean queryAtteById(int selfId,int friendId);

    /**
     * 添加好友
     * @param selfId
     * @param friendId
     * @return
     */
    boolean addFriendById(int selfId,int friendId);
}
