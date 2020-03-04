package cn.ac.zhanghe.blog.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.ac.zhanghe.blog.bean.Article;
import cn.ac.zhanghe.blog.bean.Category;
import cn.ac.zhanghe.blog.bean.Comment;
import cn.ac.zhanghe.blog.bean.PageBean;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.daoImpl.ArticleDao;
import cn.ac.zhanghe.blog.serviceImpl.ArticleService;
import cn.ac.zhanghe.blog.serviceImpl.CategoryService;
import cn.ac.zhanghe.blog.serviceImpl.CommentService;
import cn.ac.zhanghe.blog.serviceImpl.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ArticleAction extends ActionSupport implements ModelDriven<Article>,RequestAware{
	
	private Article article;
	private ArticleService articleService;
	private CommentService commentService;
	private CategoryService categoryService;
	private List<Article> articlelist;
	private List<Comment> commentlist;
	private List<Category> categorylist;
	private User user;
	private Category category;
	private Comment comment;
	private Integer iid;
	private String sartitleTitle;
	private int currPage = 1;
	private int totalPage;
	private PageBean<Article> articlePage;
	private UserService userService;
	private int categoryId;

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public List<Article> getArticlelist() {
		return articlelist;
	}
	public void setArticlelist(List<Article> articlelist) {
		this.articlelist = articlelist;
	}
	public PageBean<Article> getArticlePage() {
		return articlePage;
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
	public void setArticlePage(PageBean<Article> articlePage) {
		this.articlePage = articlePage;
	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getSartitleTitle() {
		return sartitleTitle;
	}
	public void setSartitleTitle(String sartitleTitle) {
		this.sartitleTitle = sartitleTitle;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public List<Comment> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public List<Category> getCategorylist() {
		return categorylist;
	}
	public void setCategorylist(List<Category> categorylist) {
		this.categorylist = categorylist;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//添加博文
	public String addArticle(){
		user = (User) ActionContext.getContext().getSession().get("session_user");
		category = categoryService.getCategoryById(categoryId);
		System.out.println(categoryId);
		article.setPublishTime(new Date());
		article.setUser(user);
		article.setCategory(category);
		boolean res = articleService.addArticle(article);
		if(res){
			ActionContext.getContext().getSession().put("addArtResult", "添加博文成功");
			return "addArtSuccess";
		}else{
			ActionContext.getContext().getSession().put("addArtResult", "添加博文失败");
			return "addArtError";
		}
	}
	
	//删除博文
	public String deleteArticle(){
		article = articleService.getArticleByArticleId(iid);
		boolean res = articleService.deleteArticle(article);
		if(res){
			ActionContext.getContext().getSession().put("updateArtResult", "删除博文成功");
			return "deleteArtSuccess";
		}else{
			ActionContext.getContext().getSession().put("updateArtResult", "删除博文失败");
			return "deleteArtError";
		}
	}
	
	//列出所有博文
	public String getArticleList(){
		articlelist = articleService.getArticleList();
		if(articlelist!=null){
			return "getArtListSuccess";
		}else{
			return "getArtListError";
		}
	}
	//列出该用户的所有博文
	public String getArticleListByUserId(){
		articlelist = articleService.getArticleListByUserId(iid);
		if(articlelist!=null){
			return "getArtListByIdSuccess";
		}else{
			return "getArtListByIdError";
		}
	}
	//分页显示博文
	public String getArticleByPage(){
		try {
			articlePage = articleService.getArticleByPage(currPage);
			user = (User) ActionContext.getContext().getSession().get("session_user");
			categorylist = categoryService.getCategoryList();
			ActionContext.getContext().getValueStack().push(articlePage);
			return "getArticleByPageSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "getArticleByPageError";
		}
	}
	//列出该分类下的所有博文
	public String getArticleListByCategoryId(){
		try {
			articlelist = articleService.getArticleListByCategoryId(iid);
			categorylist = categoryService.getCategoryList();
			return "getArtListByCategoryIdSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "getArtListByCategoryIdError";
		}
	}
	//查找博文
	public String getArticleByArticleName(){
		article = articleService.getArticleByArticleName(sartitleTitle);
		if(article!=null){
			return "getArticleByArtTitleSuccess";
		}else{
			return "getArticleByArtTitleError";
		}
	}
	//模糊查找博文
	public String getArticleListByName(){
		articlelist = articleService.getArticleListByName(sartitleTitle);
		for(Article article : articlelist){
			System.out.println(article.getArticleTitle());
		}
		if(articlelist!=null){
			return "getArtListByArtTitleSuccess";
		}else{
			return "getArtListByArtTitleError";
		}
	}
	//显示此博文详细信息
	public String getArticleByArticleId(){
		article = articleService.getArticleByArticleId(iid);
		commentlist = commentService.getCommentListByArticleId(iid);
		ActionContext.getContext().getSession().put("session_art", article);
		if(article!=null){
			System.out.println(iid);
			return "getArtByArtIdSuccess";
		}else{
			return "getArtByArtIdError";
		}
	}
	
	//获取修改信息
	public String getArticleUpdate(){
		article = articleService.getArticleByArticleId(iid);
		categorylist = categoryService.getCategoryList();
		System.out.println(iid);
		if(article!=null){
			return "getArtUpdateSuccess";
		}else{
			return "getArtUpdateError";
		}
	}
	//修改博文
	public String updateArticle(){
		article.setArticleId(iid);
		category = categoryService.getCategoryById(categoryId);
		article.setCategory(category);
		user = (User) ActionContext.getContext().getSession().get("session_user");
		article.setUser(user);
		boolean res = articleService.updateArticle(article);
		if(res){
			ActionContext.getContext().getSession().put("updateArtResult", "修改博文成功");
			return "updateArtSuccess";
		}else{
			ActionContext.getContext().getSession().put("updateArtResult", "修改博文失败");
			return "updateArtError";
		}
	}
}
