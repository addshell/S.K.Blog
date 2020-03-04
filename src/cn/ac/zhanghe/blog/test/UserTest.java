package cn.ac.zhanghe.blog.test;


import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ac.zhanghe.blog.bean.Article;
import cn.ac.zhanghe.blog.bean.Category;
import cn.ac.zhanghe.blog.bean.User;
import cn.ac.zhanghe.blog.dao.IUserDao;
import cn.ac.zhanghe.blog.daoImpl.UserDao;
import cn.ac.zhanghe.blog.serviceImpl.UserService;
@RunWith(BlockJUnit4ClassRunner.class)
public class UserTest{
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Autowired
	private User user;
	@Autowired
	private UserDao userd;
	@Autowired
	private UserService userService;
	private ApplicationContext app;
	
	
	
	//@Before
/*	public void init(){
		//创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
	    .applySettings(config.getProperties())
	    .buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		SchemaExport export = new SchemaExport(config);
		export.create(true,true);
		//创建回话对象
		session = sessionFactory.openSession();
		//开启事务
		transaction = session.beginTransaction();
		System.out.println("创建成功");
		
	}
	
	
	//@After
	public void destory(){
		session.close();
		sessionFactory.close();
		System.out.println("销毁成功");
	}*/
	
	
/*	@Test
	public void testSchemaExport(){
		//创建hibernate配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//生成sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

		SchemaExport export = new SchemaExport(config);
		export.create(true ,true);
	}
	*/
	
	public UserDao getUserd() {
		return userd;
	}



	public void setUserd(UserDao userd) {
		this.userd = userd;
	}



	@Test
	public void testSaveUsers()
	{
		/*//创建hibernate配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//生成sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//创建会话
		Session session =  sessionFactory.getCurrentSession();
		//创建事务
		Transaction transaction = session.beginTransaction();*/
	
	
		/*user.setUserName("hhhh");
		user.setUserPass("123");
		user.setUserPhone(1356627998);
		user.setCommentPower(true);
		user.setRoot(false);*/
		
		
		user= new User("hjji", "1567156", "1356627998", true, false);
		userd.addUser(user);
		//userService.registUser(user);
		//sessionFactory.getCurrentSession().save(user);
		//session.save(user);
		//transaction.commit();
		
	}
	


}
