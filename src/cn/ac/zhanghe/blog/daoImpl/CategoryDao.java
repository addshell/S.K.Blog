package cn.ac.zhanghe.blog.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ac.zhanghe.blog.bean.Category;
import cn.ac.zhanghe.blog.dao.ICategoryDao;

public class CategoryDao implements ICategoryDao {
	
	private SessionFactory sessionFactory;
	private Category category;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			this.getSession().delete(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		String hql = "from Category c order by c.categoryId";
		List<Category> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<Category> getCategoryListByUserId(Integer id) {
		// TODO Auto-generated method stub
		String hql = "from Category c where c.user.userId = ?";
		List<Category> list = this.getSession().createQuery(hql).setInteger(0, id).list();
		return list;
	}

	@Override
	public Category getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		category = (Category) this.getSession().get(Category.class, id);
		return category;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			this.getSession().update(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
