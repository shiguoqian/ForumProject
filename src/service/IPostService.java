package service;

import java.util.ArrayList;
import java.util.List;

import bean.Message;
import bean.Post;
import bean.User;

public interface IPostService {
	
	/**
	 * 删帖
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	boolean DelPostById(int pId);
	int insertCollectById(int pId) ;//用户收藏帖

	/**
	 * 删除收藏贴
	 *
	 *
	 * @param pId
	 * @return
	 */
	boolean delCollectById(int pId) ;//用户取消收藏帖
	List<Post> getAllCollectById(int uId);//用户查看所有收藏帖
	int praisePostById(int uId);//用户点赞
	List<Message>showAll();	//sss登陆/不登陆首页显示内容
	List<Post> getPostsByType(String type);//根据post类型查询wanp
	ArrayList<Message>getAllTopPost();				//获取所有置顶帖子
	/**
	 * 审核通过帖子
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	boolean passPost(int pId);
	/**
	 * 改变帖子置顶状态
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	boolean topPost(int pId,int topFlag);

	/**
	 * 改变帖子精华状态
	 * @param pId
	 * @param fineFlag
	 * @return
	 */
	boolean finePost(int pId,int fineFlag);
	/**
	 * wanp,用户点击帖子获取内容
	 * @param pID
	 * @return
	 */
	Message getMessageById(int pID);

}
