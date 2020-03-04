package cn.ac.zhanghe.blog.service;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Comment;

public interface ICommentService {
	//添加评论
	public boolean addComment(Comment comment);
	
	//删除评论
	public boolean deleteComment(Comment comment);
	
	//查看某一个评论
	public Comment getCommentById(Integer id);
	//列出该用户的所有评论
	public List<Comment> getCommentListByCommentUser(String userName);
	//列出该博文下的所有评论
	public List<Comment> getCommentListByArticleId(Integer id);

	//修改评论
	public boolean updateComment(Comment comment);
}
