package cn.ac.zhanghe.blog.serviceImpl;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Category;
import cn.ac.zhanghe.blog.daoImpl.CategoryDao;
import cn.ac.zhanghe.blog.service.ICategoryService;

public class CategoryService {

	private CategoryDao categoryDao;
	private Category category;
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub\
		boolean res = categoryDao.addCategory(category);
		return res;
	}
	
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		boolean res = categoryDao.deleteCategory(category);
		return res;
	}
	
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		try {
			List<Category> list = categoryDao.getCategoryList();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Category> getCategoryListByUserId(Integer id) {
		// TODO Auto-generated method stub
		try {
			List<Category> list = categoryDao.getCategoryListByUserId(id);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Category getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		try {
			category = (Category) categoryDao.getCategoryById(id);
			return category;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		boolean res = categoryDao.updateCategory(category);
		return res;
	}

}
