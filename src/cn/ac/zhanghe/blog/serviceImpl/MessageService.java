package cn.ac.zhanghe.blog.serviceImpl;

import java.util.List;

import cn.ac.zhanghe.blog.bean.Message;
import cn.ac.zhanghe.blog.bean.PageBean;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.daoImpl.MessageDao;
import cn.ac.zhanghe.blog.service.IMessageService;

public class MessageService {

	private MessageDao messageDao;
	private Message message;
	public MessageDao getMessageDao() {
		return messageDao;
	}
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}


	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		boolean res = messageDao.addMessage(message);
		return res;
	}

	
	public boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		boolean res = messageDao.deleteMessage(message);
		return res;
	}

	
	public List<Message> getMessageList() {
		// TODO Auto-generated method stub
		List<Message> list = messageDao.getMessageList();
		return list;
	}
	
	
	public Message getMessageById(Integer id){
		message = messageDao.getMessageById(id);
		return message;
	}
	
	public PageBean<Message> getMesByPage(int currPage){
		PageBean<Message> messPage = new PageBean<Message>();
		System.out.println(currPage);
		//封装当前页数
		messPage.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 5;
		messPage.setPageSize(pageSize);
		//封装总页数
		int totalCount = messageDao.getCount();
		messPage.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		messPage.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Message> messagelist = messageDao.getMesListByPage(begin, pageSize);
		messPage.setList(messagelist);
		return messPage;
	}

}
