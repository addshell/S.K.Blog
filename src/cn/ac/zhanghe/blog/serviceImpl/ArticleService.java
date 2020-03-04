package cn.ac.zhanghe.blog.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ac.zhanghe.blog.bean.Article;
import cn.ac.zhanghe.blog.bean.PageBean;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.daoImpl.ArticleDao;
import cn.ac.zhanghe.blog.service.IArticleService;

@Service
public class ArticleService{

	private ArticleDao articleDao;
	private Article article;

	public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}


	public boolean addArticle(Article article) {
		// TODO Auto-generated method stub
		boolean res = articleDao.addArticle(article);
		if(res){
			return true;
		}else{
		return false;
		}
	}


	public boolean deleteArticle(Article article) {
		// TODO Auto-generated method stub
		boolean res = articleDao.deleteArticle(article);
		if(res){
			return true;
		}else{
		return false;
		}
	}


	public List<Article> getArticleList() {
		// TODO Auto-generated method stub
		List<Article> list = articleDao.getArticleList();
		return list;
	}

	public List<Article> getArticleListByUserId(Integer id) {
		// TODO Auto-generated method stub
		List<Article> list = articleDao.getArticleListByUserId(id);
		return list;
	}


	public List<Article> getArticleListByCategoryId(Integer id) {
		// TODO Auto-generated method stub
		List<Article> list = articleDao.getArticleListByCategoryId(id);
		return list;
	}


	public Article getArticleByArticleId(Integer id) {
		// TODO Auto-generated method stub
		try {
			article = articleDao.getArticleByArticleId(id);
			return article;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public Article getArticleByArticleName(String articleName) {
		// TODO Auto-generated method stub
		article = articleDao.getArticleByArticleName(articleName);
		return article;
	}


	public List<Article> getArticleListByName(String articleName) {
		// TODO Auto-generated method stub
		List<Article> list = articleDao.getArticleListByName(articleName);
		return list;
	}


	public boolean updateArticle(Article article) {
		// TODO Auto-generated method stub
		boolean res = articleDao.updateArticle(article);
		if(res){
			return true;
		}else{
		return false;
		}
	}
	
	//分页显示博文
	public PageBean<Article> getArticleByPage(int currPage){
		PageBean<Article> articlePage = new PageBean<Article>();
		//封装当前页数
		articlePage.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 5;
		articlePage.setPageSize(pageSize);
		//封装总页数
		int totalCount = articleDao.getCount();
		articlePage.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		articlePage.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Article> articlelist = articleDao.getArticleListByPage(begin, pageSize);
		articlePage.setList(articlelist);
		return articlePage;
	}

}
