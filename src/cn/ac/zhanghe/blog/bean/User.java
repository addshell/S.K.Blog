package cn.ac.zhanghe.blog.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "sk_blog")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPass;
	private String userPhone;
	private Boolean root;
	private Boolean commentPower;
	private Set<Article> articles = new HashSet<Article>(0);
	private Set<Category> categories = new HashSet<Category>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userName, String userPass, String userPhone,
			Boolean root, Boolean commentPower/*, Set<Article> articles,
			Set<Category> categories*/) {
		this.userName = userName;
		this.userPass = userPass;
		this.userPhone = userPhone;
		this.root = root;
		this.commentPower = commentPower;
		/*this.articles = articles;
		this.categories = categories;*/
	}

	// Property accessors
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "userName")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "userPass")
	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Column(name = "userPhone")
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "root")
	public Boolean getRoot() {
		return this.root;
	}

	public void setRoot(Boolean root) {
		this.root = root;
	}

	@Column(name = "commentPower")
	public Boolean getCommentPower() {
		return this.commentPower;
	}

	public void setCommentPower(Boolean commentPower) {
		this.commentPower = commentPower;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}