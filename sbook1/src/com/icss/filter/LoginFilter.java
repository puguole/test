package com.icss.filter;

import java.io.IOException;  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

import com.icss.Const;
  
/*
 * 这个过滤器主要实现如果用户没有登录不能访问其它页面，直接跳首页
 * by 码农
 * */
public class LoginFilter extends HttpServlet implements Filter {  
    public void destroy() {  
    }  
  
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse,        
            FilterChain filterChain) throws IOException, ServletException{  
          
        HttpServletRequest request = (HttpServletRequest) sRequest;        
        HttpServletResponse response = (HttpServletResponse) sResponse;        
        HttpSession session = request.getSession();    
        
        //得到请求路径 比如 /index.jsp
      String url=request.getServletPath(); 
      System.out.println("url:"+url);
      //得到请求路径  比如 我的这个web项目起名为  biyesheji ,contextPath = /biyesheji

      String contextPath=request.getContextPath();   

      if(!url.startsWith("/login.jsp")){ //如果访问的不是登录页面
    	  System.out.println("非正常登录");
	     String userStatus=(String)session.getAttribute(Const.LOGINUNAME);    
         if(userStatus==null){//session没有用户的身份信息(userStatus),则转入登录页面
        	System.out.println("没有登录");
            response.sendRedirect(contextPath + "/login.jsp");  
         }
      }else{
    	  System.out.println("登陆了");
          filterChain.doFilter(sRequest, sResponse); 
      }
      	     
    }    
  
    public void init(FilterConfig arg0) throws ServletException {  
  
    }  
}  