package cn.ac.zhanghe.blog.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ac.zhanghe.blog.bean.Message;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.dao.IMessageDao;

public class MessageDao implements IMessageDao {
	private SessionFactory sessionFactory;
	private Message message;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(message);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			this.getSession().delete(message);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Message> getMessageList() {
		// TODO Auto-generated method stub
		String hql = "from Message m order by m.messageId";
		List<Message> list = this.getSession().createQuery(hql).list();
		return list;
	}
	@Override
	public Message getMessageById(Integer id) {
		// TODO Auto-generated method stub
		message = (Message) this.getSession().get(Message.class, id);
		return message;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Message";
		List<Long> list = this.getSession().createQuery(hql).list();
		System.out.println(list.get(0).intValue());
		return list.get(0).intValue();
	}
	@Override
	public List<Message> getMesListByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Message";
		List<Message> list = this.getSession().createQuery(hql).setFirstResult(begin).setMaxResults(pageSize).list();
		return list;
	}

}
