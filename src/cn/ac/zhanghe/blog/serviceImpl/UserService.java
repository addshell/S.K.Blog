package cn.ac.zhanghe.blog.serviceImpl;

import java.awt.print.PageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ac.zhanghe.blog.bean.PageBean;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.dao.IUserDao;
import cn.ac.zhanghe.blog.daoImpl.UserDao;
import cn.ac.zhanghe.blog.service.IUserService;

@Service
public class UserService{
	
	private UserDao userDao;
	private User user;
		
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean res = userDao.addUser(user);
		return res;
	}
	
	public List<User> getUser(){
		List<User> list = userDao.getUserList();
		return list;
	}


	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		boolean res = userDao.deleteUser(user);
		return res;
	}


	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		user = userDao.getUserByUserName(userName);
		return user;
	}


	public User getUserByUserId(Integer id) {
		// TODO Auto-generated method stub
		user = userDao.getUserByUserId(id);
		return user;
	}
	
	public PageBean<User> getUserByPage(int currPage){
		PageBean<User> userPage = new PageBean<User>();
		System.out.println(currPage);
		//封装当前页数
		userPage.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 5;
		userPage.setPageSize(pageSize);
		//封装总页数
		int totalCount = userDao.getCount();
		userPage.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		userPage.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<User> userlist = userDao.getUserListByPage(begin, pageSize);
		userPage.setList(userlist);
		return userPage;
	}
	
	public User getUserLogin(String username,String userpass){
		try {
			user = userDao.getUserLogin(username, userpass);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean res = userDao.updateUser(user);
		return res;
	}
	
	public boolean updateUserRoot(Integer id){
		boolean res = userDao.updateUserRoot(id);
		return res;
	}
	
	public boolean updateUserCommentPower(Integer id){
		boolean res = userDao.updateUserCommentPower(id);
		return res;
	}
	
	
	
}
