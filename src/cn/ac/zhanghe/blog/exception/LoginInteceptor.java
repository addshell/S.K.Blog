package cn.ac.zhanghe.blog.exception;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.ac.zhanghe.blog.bean.User;


public class LoginInteceptor extends AbstractInterceptor{     //配置登录检查拦截器
	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		// TODO Auto-generated method stub
		//取得请求的URL  
        String url = ServletActionContext.getRequest().getRequestURL().toString();
        HttpServletResponse response = ServletActionContext.getResponse();  
        response.setHeader("Pragma","No-cache");            
        response.setHeader("Cache-Control","no-cache");     
        response.setHeader("Cache-Control", "no-store");     
        response.setDateHeader("Expires",0); 
        if (url.indexOf("Login")!=-1 || url.indexOf("reg")!=-1){  
            return inv.invoke();  
        }
        else{  
            //验证Session是否过期  
            if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){  
                //session过期,转向session过期提示页,最终跳转至登录页面  
                return "login";  
            }  
            else{  
            	User user = (User) ServletActionContext.getRequest().getSession().getAttribute("session_user"); 
            	if (user==null){  
                //尚未登录,跳转至登录页面  
                return "login";  
            	}else{                      
            		return inv.invoke();  
            	}           
            }         
        }
	}
}
