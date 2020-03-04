package cn.ac.zhanghe.blog.serviceImpl;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Comment;
import cn.ac.zhanghe.blog.bean.PageBean;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.daoImpl.CommentDao;
import cn.ac.zhanghe.blog.service.ICommentService;

public class CommentService {

	private CommentDao commentDao;
	private Comment comment;

	public CommentDao getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}


	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		try {
			commentDao.addComment(comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		try {
			commentDao.deleteComment(comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Comment getCommentById(Integer id){
		Comment comment = commentDao.getCommentById(id);
		return comment;
	}
	
	public List<Comment> getCommentListByCommentUser(String userName) {
		// TODO Auto-generated method stub
		List<Comment> list = commentDao.getCommentListByUserName(userName);
		return list;
	}

	
	public List<Comment> getCommentListByArticleId(Integer id) {
		// TODO Auto-generated method stub
		try {
			List<Comment> list = commentDao.getCommentListByArticleId(id);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public PageBean<Comment> getCommByPage(int currPage){
		PageBean<Comment> commPage = new PageBean<Comment>();
		System.out.println(currPage);
		//封装当前页数
		commPage.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 8;
		commPage.setPageSize(pageSize);
		//封装总页数
		int totalCount = commentDao.getCount();
		commPage.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		commPage.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Comment> commlist = commentDao.getCommListByPage(begin, pageSize);
		commPage.setList(commlist);
		return commPage;
	}

	
	public boolean updateComment(Comment comment) {
		// TODO Auto-generated method stub
		try {
			commentDao.updateComment(comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
