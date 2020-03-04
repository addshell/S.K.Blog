package cn.ac.zhanghe.blog.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ac.zhanghe.blog.bean.Article;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.dao.IArticleDao;

public class ArticleDao implements IArticleDao {

	private SessionFactory sessionFactory;
	private Article	article;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	private Session getSession() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public boolean addArticle(Article article) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(article);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteArticle(Article article) {
		// TODO Auto-generated method stub
		try {
			this.getSession().delete(article);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Article getArticleByArticleId(Integer id) {
		// TODO Auto-generated method stub
		try {
			article = (Article) this.getSession().get(Article.class, id);
			return article;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Article getArticleByArticleName(String articleName) {
		// TODO Auto-generated method stub
		String hql = "from Article a where a.articleTitle = ?";
		List<Article> list = (List<Article>) this.getSession().createQuery(hql).setString(0, articleName);
		article = list.get(0);
		return article;
	}

	@Override
	public List<Article> getArticleListByName(String articleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> getArticleListByUserId(Integer id) {
		// TODO Auto-generated method stub
		String hql = "from Article a where userId = ?";
		List<Article> list = (List<Article>) this.getSession().createQuery(hql).setLong(0, id);
		return list;
	}

	@Override
	public List<Article> getArticleListByCategoryId(Integer id) {
		// TODO Auto-generated method stub
		String hql = "from Article a where categoryId = ?";
		List<Article> list = (List<Article>) this.getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}

	@Override
	public List<Article> getArticleList() {
		// TODO Auto-generated method stub
		String hql = "from Article a order by a.articleId";
		List<Article> list = (List<Article>) this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public boolean updateArticle(Article article) {
		// TODO Auto-generated method stub
		try {
			this.getSession().update(article);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Article> getArticleListByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Article";
		List<Article> list = this.getSession().createQuery(hql).setFirstResult(begin).setMaxResults(pageSize).list();
		return list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Article";
		List<Long> list = this.getSession().createQuery(hql).list();
		return list.get(0).intValue();
	}

}
