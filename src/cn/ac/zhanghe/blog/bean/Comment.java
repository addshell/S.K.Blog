package cn.ac.zhanghe.blog.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "sk_blog")
public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Article article;
	private String commentUser;
	private String commentContent;
	private Date commentTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Article article, String commentUser, String commentContent,
			Date commentTime) {
		this.article = article;
		this.commentUser = commentUser;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "commentId", unique = true, nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "articleId")
	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Column(name = "commentUser")
	public String getCommentUser() {
		return this.commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	@Column(name = "commentContent", length = 65535)
	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Column(name = "commentTime", length = 19)
	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

}