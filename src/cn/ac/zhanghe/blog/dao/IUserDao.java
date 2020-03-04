package cn.ac.zhanghe.blog.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ac.zhanghe.blog.bean.User;

public interface IUserDao {
	//注册用户
	public boolean addUser(User user);
	
	//通过id号删除用户
	public boolean deleteUser(User user);
	
	//通过用户名查找用户
	public User getUserByUserName(String userName);
	//通过用户id查找用户
	public User getUserByUserId(Integer id);
	//得到所有用户List
	public List<User> getUserList();
	//通过用户验证
	public User getUserLogin(String username,String userpass);
	//查询用户总记录数
	public int getCount();
	//分页查询用户
	public List<User> getUserListByPage(int begin, int pageSize);
	
	//更新用户信息
	public boolean updateUser(User user);
	//修改用户发言权限
	public boolean updateUserCommentPower(Integer id);
	//更改用户管理员权限
	public boolean updateUserRoot(Integer id);
}
