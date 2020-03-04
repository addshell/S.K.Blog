package cn.ac.zhanghe.blog.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ac.zhanghe.blog.bean.Comment;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.dao.ICommentDao;

public class CommentDao implements ICommentDao {

	private SessionFactory sessionFactory;
	private Comment comment;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		try {
			this.getSession().delete(comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Comment> getCommentListByUserName(String userName) {
		// TODO Auto-generated method stub
		String hql = "from Comment c where c.commentUser = ?";
		List<Comment> list = this.getSession().createQuery(hql).setString(0, userName).list();
		return list;
	}

	@Override
	public List<Comment> getCommentListByArticleId(Integer id) {
		// TODO Auto-generated method stub
		String hql = "from Comment c where c.article.articleId = ?";
		List<Comment> list = this.getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}

	@Override
	public Comment getCommentById(Integer id) {
		// TODO Auto-generated method stub
		try {
			comment = (Comment) this.getSession().get(Comment.class, id);
			return comment;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Comment";
		List<Long> list = this.getSession().createQuery(hql).list();
		System.out.println(list.get(0).intValue());
		return list.get(0).intValue();
	}
	@Override
	public List<Comment> getCommListByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Message";
		List<Comment> list = this.getSession().createQuery(hql).setFirstResult(begin).setMaxResults(pageSize).list();
		return list;
	}
	
	

	@Override
	public boolean updateComment(Comment comment) {
		// TODO Auto-generated method stub
		try {
			this.getSession().update(comment);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
