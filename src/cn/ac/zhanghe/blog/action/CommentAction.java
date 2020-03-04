package cn.ac.zhanghe.blog.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.ac.zhanghe.blog.bean.Article;
import cn.ac.zhanghe.blog.bean.Comment;
import cn.ac.zhanghe.blog.bean.PageBean;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.serviceImpl.ArticleService;
import cn.ac.zhanghe.blog.serviceImpl.CommentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment>,RequestAware{

	private Comment comment;
	private CommentService commentService;
	private ArticleService articleService;
	private List<Comment> commentlist;
	private Article article;
	private int iid;
	private int currPage = 1;
	private int totalPage;
	private PageBean<Comment> commPage;
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public List<Comment> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
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
	public PageBean<Comment> getCommPage() {
		return commPage;
	}
	public void setCommPage(PageBean<Comment> commPage) {
		this.commPage = commPage;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Comment getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	

	//发表评论
	public String addComment(){
		user = (User) ActionContext.getContext().getSession().get("session_user");
		comment.setCommentTime(new Date());
		comment.setCommentUser(user.getUserName());
		article = articleService.getArticleByArticleId(iid);
		comment.setArticle(article);
		boolean res = commentService.addComment(comment);
		if(res){
			ActionContext.getContext().getSession().put("session_art", article);
			System.out.println(article.getArticleId());
			ActionContext.getContext().getSession().put("addComResult", "发表评论成功");
			return "addCommentSuccess";
		}else{
			ActionContext.getContext().getSession().put("addComResult", "发表评论失败");
			return "addCommentError";
		}
	}
	
	//删除评论
	public String deleteComment(){
		boolean res = commentService.deleteComment(comment);
		if(res){
			return "deleteCommentSuccess";
		}else{
			return "deleteCommentError";
		}
	}
	
	//得到评论
	public String getCommentById(){
		comment = commentService.getCommentById(iid);
		System.out.println(comment);
		if(comment!=null){
			return "getCommentSuccess";
		}else{
			return "getCommentError";
		}
	}
	//得到该博文下的所有评论
	public String getCommentListByArticleId(){
		commentlist = commentService.getCommentListByArticleId(iid);
		for (Comment comment : commentlist) {
			System.out.println("得到数据");
		}
		if(commentlist!=null){
			return "getComListByArtIdSuccess";
		}else{
			return "getComListByArtIdError";
		}
	}
	//得到用户的所有评论
	public String getCommentListByCommentUser(){
		commentlist = commentService.getCommentListByCommentUser(comment.getCommentUser());
		if(commentlist!=null){
			return "getComListByComUserSuccess";
		}else{
			return "getComListByComUserError";
		}
	}
	//分页显示评论
	public String getCommByPage(){
		commPage = commentService.getCommByPage(currPage);
		ActionContext.getContext().getValueStack().push(commPage);
		System.out.println(commPage.getList());
		return "getCommByPageSuccess";
		}
	
	
	//更改评论
	public String updateComment(){
		boolean res = commentService.updateComment(comment);
		if(res){
			return "updateCommentSuccess";
		}else{
			return "updateCommentError";
		}
	}
}
