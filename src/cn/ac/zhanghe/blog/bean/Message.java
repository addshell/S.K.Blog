package cn.ac.zhanghe.blog.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "sk_blog")
public class Message implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private String messageUserName;
	private String messageEmail;
	private String messageName;
	private Date messageTime;
	private String messageContent;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String messageUserName, String messageEmail,
			String messageName, Date messageTime, String messageContent) {
		this.messageUserName = messageUserName;
		this.messageEmail = messageEmail;
		this.messageName = messageName;
		this.messageTime = messageTime;
		this.messageContent = messageContent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "messageId", unique = true, nullable = false)
	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@Column(name = "messageUserName")
	public String getMessageUserName() {
		return this.messageUserName;
	}

	public void setMessageUserName(String messageUserName) {
		this.messageUserName = messageUserName;
	}

	@Column(name = "messageEmail")
	public String getMessageEmail() {
		return this.messageEmail;
	}

	public void setMessageEmail(String messageEmail) {
		this.messageEmail = messageEmail;
	}

	@Column(name = "messageName")
	public String getMessageName() {
		return this.messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	@Column(name = "messageTime", length = 19)
	public Date getMessageTime() {
		return this.messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	@Column(name = "messageContent", length = 65535)
	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

}