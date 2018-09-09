package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Advise;
import bean.Message;
import bean.Post;


public interface IPostDao {
	/**
	 * 发帖
	 * @param post
	 * @return
	 */
	int insertPostByName(Post post);//发帖(1:0)
	/**
	 * 删帖
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	int DelPostById(int pId);
	/**
	 * 用户收藏贴
	 * @param pId
	 * @return
	 */
	int insertCollectById(int pId) ;//用户收藏帖
	/**
	 * 用户取消收藏贴
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	int delCollectById(int pId) ;//用户取消收藏帖
	/**
	 * 用户查看所有收藏帖
	 * @param uId
	 * @return
	 */
	List<Post> getAllCollectById(int uId);//用户查看所有收藏帖
	/**
	 * 用户点赞
	 * @param uId
	 * @return
	 */
	int praisePostById(int uId);//用户点赞
	/**
	 * 获取某用户所有贴子
	 * @param id
	 * @return
	 */
	ArrayList<Post>getPostsByUId(int id);
	/**
	 * sss
	 * @return
	 */
	List<Message>showAll();//sss
	/**
	 * 根据帖子类型获取帖子wanp
	 * @param type
	 * @return
	 */
	ArrayList<Post> getPostsByType(String type);//根据帖子类型获取帖子wanp
	/**
	 * 获取所有置顶帖子
	 * @return
	 */
	ArrayList<Message> getAllTopPost();			//获取所有置顶帖子
	
	/**
	 * 审核通过帖子
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	int passPost(int pId);
	/**
	 * 改变帖子置顶状态
	 *
	 * 史国茜
	 * @param pId
	 * @param topFlag
	 * @return
	 */
	int topPost(int pId,int topFlag);

	/**
	 * 改变精贴状态
	 *
	 * 史国茜
	 * @param pId
	 * @param fineFlag
	 * @return
	 */
	int finePost(int pId,int fineFlag);
	/**
	 * wanp根据帖子Id获取Post
	 * @param pId
	 * @return
	 */
	Post getPostById(int pId);
	
	/**
	 * wanp根据帖子id查出message,用于点击展现帖子内容,
	 * @param pId
	 * @return
	 */
	Message getMessageById(int pId);

}
