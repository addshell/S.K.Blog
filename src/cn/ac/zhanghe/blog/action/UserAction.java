package cn.ac.zhanghe.blog.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ac.zhanghe.blog.bean.PageBean;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.serviceImpl.UserService;
import cn.ac.zhanghe.blog.util.CreateImageAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>,RequestAware{
	
	private List<User> userlist;
	private UserService userService;
	private User user;
	private String sname;
	private Integer iid;
	private String login_username;
	private String login_userpass;
	private int currPage = 1;
	private int totalPage;
	private PageBean<User> userPage;

	public List<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String s_username) {
		this.sname = s_username;
	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public PageBean<User> getUserPage() {
		return userPage;
	}
	public void setUserPage(PageBean<User> userPage) {
		this.userPage = userPage;
	}
	public String getLogin_username() {
		return login_username;
	}
	public void setLogin_username(String login_username) {
		this.login_username = login_username;
	}
	public String getLogin_userpass() {
		return login_userpass;
	}
	public void setLogin_userpass(String login_userpass) {
		this.login_userpass = login_userpass;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//用户注册
	public String registUser(){
		user.setRoot(false);
		user.setCommentPower(true);
		boolean res = userService.addUser(user);
		if(res){
			ActionContext.getContext().getSession().put("registerResult", "注册成功");
			return "regSuccess";
		}else{
			ActionContext.getContext().getSession().put("registerResult", "注册失败");
			return "regError";
		}
	}
	
	//删除用户
	public String deleteUser(){
		user = userService.getUserByUserId(iid);
		boolean res = userService.deleteUser(user);
		if(res){
			ActionContext.getContext().getSession().put("deleteUserResult", "用户删除成功");
			return "deleteUserSuccess";
		}else{
			ActionContext.getContext().getSession().put("deleteUserResult", "用户删除失败");
			return "deleteUserError";
		}
	}
	
	//得到用户信息
	public String getUserName(){
		user = userService.getUserByUserId(iid);
		if(user!=null){
			return "getUserSuccess";
		}else{
			return "getUserError";
		}
	}
	
	//分页显示用户
	public String getUserByPage(){
		try {
			userPage = userService.getUserByPage(currPage);
			ActionContext.getContext().getValueStack().push(userPage);
			System.out.println(userPage.getList());
			return "getUserByPageSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "getUserByPageError";
		}
	}
	
	//验证用户登录
	public String getUserLogin(){
		user = userService.getUserLogin(login_username, login_userpass);
		if(user!=null){
			ActionContext.getContext().getSession().put("session_user", user);
			ActionContext.getContext().getSession().put("loginResult", "恭喜你登录成功");
			return "getULoginSuccess";
		}else{
			ActionContext.getContext().getSession().put("loginResult", "用户名或密码错误");
			return "getULoginError";
		}
	}
	

	//得到所有用户
	public String getUserList(){
		userlist = userService.getUser();
		for(User user:userlist){
			System.out.println(user.getUserName());
		}
		if(userlist!=null){
			return "getUserListSuccess";
		}else{
			return "getUserListError";
		}
	}
	
	//得到更改信息
	public String getUserUpdate(){
			user = userService.getUserByUserId(iid);
			if(user!=null){
				return "getUserUpdateSuccess";
			}else{
				ActionContext.getContext().getSession().put("updateUserResult", "获取用户信息失败");
				return "getUserUpdateError";
			}
	}
	//更新用户信息
	public String updateUser(){
		boolean res = userService.updateUser(user);
		if(res){
			ActionContext.getContext().getSession().put("session_user", user);
			ActionContext.getContext().getSession().put("updateUserResult", "用户信息修改成功");
			return "updateUserSuccess";
		}else{
			ActionContext.getContext().getSession().put("updateUserResult", "用户信息修改失败");
			return "updateUserError";
		}
	}
	
	//更改管理员权限
	public String updateUserRoot(){
		boolean res = userService.updateUserRoot(iid);
		if(res){
			ActionContext.getContext().getSession().put("pageResult", "用户更改管理员授权成功");
			return "updateUserRootSuccess";
		}else{
			ActionContext.getContext().getSession().put("pageResult", "用户更改管理员授权失败");
			return "updateUserRootError";
		}
	}
	
	//更改发言权限
	public String updateUComPower(){
		boolean res = userService.updateUserCommentPower(iid);
		if(res){
			ActionContext.getContext().getSession().put("pageResult", "用户更改发言权限成功");
			return "updateUComPowerSuccess";
		}else{
			ActionContext.getContext().getSession().put("pageResult", "用户更改发言权限失败");
			return "updateUComPowerError";
		}
	}
	
	//退出登录
	public String exitUser(){
		try {
			ActionContext.getContext().getSession().clear();
			return "exitSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "exitError";
		}
	}
}
