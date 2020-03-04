package cn.ac.zhanghe.blog.service;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Category;

public interface ICategoryService {
	//添加分类
	public boolean addCategory(Category category);
	
	//删除分类
	public boolean deleteCategory(Category category);
	
	//得到全部分类
	public List<Category> getCategoryList();
	//得到该用户的分类
	public List<Category> getCategoryListByUserId(Integer id);
	//根据id列出分类信息
	public Category getCategoryById(Integer id);
	
	//更改分类
	public boolean updateCategory(Category category);
}
