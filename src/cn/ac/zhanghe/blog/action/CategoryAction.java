package cn.ac.zhanghe.blog.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.ac.zhanghe.blog.bean.Article;
import cn.ac.zhanghe.blog.bean.Category;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.serviceImpl.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategoryAction extends ActionSupport implements ModelDriven<Category>,RequestAware{

	private Category category;
	private User user;
	private List<Category> categorylist;
	private CategoryService categoryService;
	private Integer iid;
	
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Category> getCategorylist() {
		return categorylist;
	}
	public void setCategorylist(List<Category> categorylist) {
		this.categorylist = categorylist;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//添加分类
	public String addCategory(){
		boolean res = categoryService.addCategory(category);
		if(res){
			return "addCategorySuccess";
		}else{
			return "addCategoryError";
		}
	}
	
	//删除分类
	public String deleteCategory(){
		boolean res = categoryService.deleteCategory(category);
		if(res){
			return "deleteCategorySuccess";
		}else{
			return "deleteCategoryError";
		}
	}

	//列出该用户的所有分类
	public String getCategoryListByUserId(){
		categorylist = categoryService.getCategoryListByUserId(iid);
		if(categorylist!=null){
			return "getCatListByUserIdSuccess";
		}else{
			return "getCatListByUserIdError";
		}
	}
	
	//修改分类
	public String updateCategory(){
		boolean res = categoryService.updateCategory(category);
		if(res){
			return "updateCategorySuccess";
		}else{
			return "updateCategoryError";
		}
	}
}
