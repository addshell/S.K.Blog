package cn.ac.zhanghe.blog.dao;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Message;

public interface IMessageDao {
	//添加留言
	public boolean addMessage(Message message);
	
	//删除留言
	public boolean deleteMessage(Message message);
	
	//查看所有留言
	public List<Message> getMessageList();
	//根据留言id找到留言
	public Message getMessageById(Integer id);
	//查询总记录数
	public int getCount();
	//分页查询留言
	public List<Message> getMesListByPage(int begin, int pageSize);
}
