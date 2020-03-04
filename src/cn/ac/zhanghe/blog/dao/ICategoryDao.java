package cn.ac.zhanghe.blog.dao;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Article;
import cn.ac.zhanghe.blog.bean.Category;

public interface ICategoryDao {
	//添加一个分类
	public boolean addCategory(Category category);
	
	//删除一个分类
	public boolean deleteCategory(Category category);
	
	//列出所有分类
	public List<Category> getCategoryList();
	//列出该用户的分类
	public List<Category> getCategoryListByUserId(Integer id);
	//通过id列出分类信息
	public Category getCategoryById(Integer id);
	
	//重命名分类
	public boolean updateCategory(Category category);
}
