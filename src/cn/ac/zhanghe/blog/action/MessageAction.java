package cn.ac.zhanghe.blog.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.ac.zhanghe.blog.bean.Message;
import cn.ac.zhanghe.blog.bean.PageBean;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.serviceImpl.MessageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction extends ActionSupport implements ModelDriven<Message>,RequestAware{
	
	private List<Message> messagelist;
	private Message message;
	private MessageService messageService;
	private Integer iid;
	private int currPage = 1;
	private int totalPage;
	private PageBean<Message> messPage;
	
	public List<Message> getMessagelist() {
		return messagelist;
	}
	public void setMessagelist(List<Message> messagelist) {
		this.messagelist = messagelist;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
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
	public PageBean<Message> getMessPage() {
		return messPage;
	}
	public void setMessPage(PageBean<Message> messPage) {
		this.messPage = messPage;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//添加留言
	public String addMessage(){
		message.setMessageTime(new Date());
		boolean res = messageService.addMessage(message);
		if(res){
			ActionContext.getContext().put("addMesResult", "留言成功");
			return "addMesSuccess";
		}else{
			ActionContext.getContext().put("addMesResult", "留言失败");
			return "addMesError";
		}
	}
	
	//删除留言
	public String deleteMessage(){
		message = messageService.getMessageById(iid);
		boolean res = messageService.deleteMessage(message);
		if(res){
			ActionContext.getContext().getSession().put("deleteMesResult", "删除留言成功");
			return "deleteMesSuccess";
		}else{
			ActionContext.getContext().getSession().put("deleteMesResult", "删除留言失败");
			return "deleteMesError";
		}
	}
	
	//得到所有留言
	public String getMessageList(){
		messagelist = messageService.getMessageList();
		for(Message message : messagelist){
			System.out.println(message.getMessageName());
		}
		if(messagelist!=null){
			return "getMesListSuccess";
		}else{
			return "getMesListError";
		}
	}
	//得到单条留言
	public String getMessageByMessageId(){
		message = messageService.getMessageById(iid);
		System.out.println(message.getMessageName());
		if(message!=null){
			return "getMessageByIdSuccess";
		}else{
			return "getMessageByIdError";
		}
	}
	//分页显示用户留言
	public String getMessByPage(){
		try {
			messPage = messageService.getMesByPage(currPage);
			ActionContext.getContext().getValueStack().push(messPage);
			return "getMesByPageSuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ActionContext.getContext().getSession().put("messageResult", "用户留言获取失败");
			return "getMesByPageError";
		}
	}
}
