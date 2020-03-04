package cn.ac.zhanghe.blog.service;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Message;

public interface IMessageService {
	//添加留言
	public boolean addMessage(Message message);
	
	//删除留言
	public boolean deleteMessage(Message message);
	
	//列出所有留言
	public List<Message> getMessageList();
	//根据留言id找到留言
	public Message getMessageById(Integer id);
}
