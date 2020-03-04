package cn.ac.zhanghe.blog.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.ac.zhanghe.blog.bean.User;

@Transactional(propagation=Propagation.REQUIRED, readOnly = true) 
public interface IUserService {
	//用户注册
	public boolean addUser(User user);
	
	//删除用户
	public boolean deleteUser(User user);
	
	//显示全部用户
	public List<User> getUser();
	//通过用户名查找用户
	public User getUserByUserName(String userName);
	//通过用户id查找用户
	public User getUserByUserId(Integer id);
	
	//更新用户信息
	public boolean updateUser(User user);
}
