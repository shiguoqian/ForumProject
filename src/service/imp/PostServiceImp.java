package service.imp;

import java.util.ArrayList;
import java.util.List;

import bean.Message;
import bean.Post;
import bean.User;
import dao.IPostDao;
import dao.imp.PostDao;

import service.IPostService;

public class PostServiceImp implements IPostService{
	IPostDao ipd = new PostDao();
	

	/**
	 * 删除帖子
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	@Override
	public boolean DelPostById(int pId) {
		// TODO Auto-generated method stub
		if (ipd.DelPostById(pId)<0){//删除失败
			return false;
		}
		return true;//删除成功
	}

	@Override
	public int insertCollectById(int pId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 删除收藏贴
	 *
	 * 史国茜
	 * @param pId
	 * @return
	 */
	@Override
	public boolean delCollectById(int pId) {
		if (ipd.delCollectById(pId)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Post> getAllCollectById(int uId) {
		return ipd.getAllCollectById(uId);
	}

	@Override
	public int praisePostById(int uId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Message> showAll() {
		return ipd.showAll();
	}
	/**
	 * wanp
	 */
	@Override
	public List<Post> getPostsByType(String type) {
		return ipd.getPostsByType(type);
	}

	@Override
	public ArrayList <Message> getAllTopPost() {
		ArrayList <Message> list = ipd.getAllTopPost();
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
	public boolean passPost(int pId) {
		if (ipd.passPost(pId)<0){
			return false;
		}
		return true;
	}

	/**
	 * 改变帖子置顶状态
	 *
	 * 史国茜
	 * @param pId
	 * @param topFlag
	 * @return
	 */
	@Override
	public boolean topPost(int pId, int topFlag) {
		if (ipd.topPost(pId,topFlag)<0){
			return false;
		}
		return true;
	}

	/**
	 * 改变帖子精华状态
	 *
	 * 史国茜
	 * @param pId
	 * @param fineFlag
	 * @return
	 */
	@Override
	public boolean finePost(int pId, int fineFlag) {
		if (ipd.finePost(pId,fineFlag)<0){
			return false;
		}
		return true;
	}

	@Override
	public Message getMessageById(int pID) {
		// TODO Auto-generated method stub
		
		return ipd.getMessageById(pID);
	}

}
