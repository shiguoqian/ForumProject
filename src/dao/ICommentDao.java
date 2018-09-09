package dao;

import java.util.List;

import bean.Comment;

public interface ICommentDao {
	int insertComment(Comment comment);//添加评论
	int delCommentById(int comId);//删除评论
	List<Comment> getAllComment();//获取所有评论

}
