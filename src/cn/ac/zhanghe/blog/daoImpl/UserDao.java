package cn.ac.zhanghe.blog.daoImpl;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.dao.IUserDao;

public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;	
	private User user;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getSession() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(user);
			return true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			this.getSession().delete(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.userName = ?";
		List<User> list = this.getSession().createQuery(hql).setString(0, userName).list();
		user = list.get(0);
		return user;
	}

	@Override
	public User getUserByUserId(Integer id) {
		// TODO Auto-generated method stub
		user = (User) this.getSession().get(User.class, id);
		return user;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		String hql="from User u order by u.userName";
		List<User> list = (List<User>)this.getSession().createQuery(hql).list();
		return list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from User";
		List<Long> list = this.getSession().createQuery(hql).list();
		System.out.println(list.get(0).intValue());
		return list.get(0).intValue();
	}
	@Override
	public List<User> getUserListByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from User";
		List<User> list = this.getSession().createQuery(hql).setFirstResult(begin).setMaxResults(pageSize).list();
		return list;
	}


	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			this.getSession().update(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUserCommentPower(Integer id) {
		// TODO Auto-generated method stub
		user = this.getUserByUserId(id);
		user.setCommentPower(!user.getCommentPower());
		if(this.updateUser(user)){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean updateUserRoot(Integer id) {
		// TODO Auto-generated method stub
		user = this.getUserByUserId(id);
		System.out.println(user.getRoot());
		if(user.getRoot().equals(true)){
			user.setRoot(false);
		}else{
			user.setRoot(true);
		}
		System.out.println(user.getRoot());
		if(this.updateUser(user)){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public User getUserLogin(String username, String userpass) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.userName = ? and u.userPass = ?";
		List<User> list = this.getSession().createQuery(hql).setString(0, username).setString(1, userpass).list();
		user = list.get(0);
		return user;
	}
}
