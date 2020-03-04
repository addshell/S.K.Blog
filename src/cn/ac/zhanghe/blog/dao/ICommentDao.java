package cn.ac.zhanghe.blog.dao;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Comment;
import cn.ac.zhanghe.blog.bean.User;

public interface ICommentDao {
	//添加评论
	public boolean addComment(Comment comment);
	
	//删除评论
	public boolean deleteComment(Comment comment);
	
	//查看用户所有评论
	public List<Comment> getCommentListByUserName(String userName);
	//查看博文对应的所有评论
	public List<Comment> getCommentListByArticleId(Integer id);
	//查看某一个评论
	public Comment getCommentById(Integer id);
	//查询评论总记录数
	public int getCount();
	//分页查询评论
	public List<Comment> getCommListByPage(int begin, int pageSize);
	
	//修改评论
	public boolean updateComment(Comment comment);
	
}
