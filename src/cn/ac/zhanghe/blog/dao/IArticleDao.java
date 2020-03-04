package cn.ac.zhanghe.blog.dao;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Article;
import cn.ac.zhanghe.blog.bean.User;

public interface IArticleDao {
	//添加博文
	public boolean addArticle(Article article);
	
	//删除博文
	public boolean deleteArticle(Article article);
	
	//通过id号查找博文
	public Article getArticleByArticleId(Integer id);
	//通过博文名称查找博文
	public Article getArticleByArticleName(String articleName);	
	//通过博文名称模糊查询
	public List<Article> getArticleListByName(String articleName);
	//得到用户所有博文
	public List<Article> getArticleListByUserId(Integer id);
	//分页列出博文
	public int getCount();
	public List<Article> getArticleListByPage(int begin, int pageSize);
	//得到分类下所有博文
	public List<Article> getArticleListByCategoryId(Integer id);
	//列出所有博文
	public List<Article> getArticleList();
	
	//修改博文
	public boolean updateArticle(Article article);
	
}
