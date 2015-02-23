package com.icss.filter;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * 判断是否登录了的监听器
 * @author Administrator
 *
 */
public class MyFilter extends HttpServlet implements Filter{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		this.doGet(request, response);

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//转换成HttpServletRequest
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		HttpSession session=httpServletRequest.getSession();
		//看看请求的资源是什么
		String uri=httpServletRequest.getRequestURI();
		System.out.println("资源名："+uri);
		if("/sbook1/register/register.jsp".equals(uri)||"/sbook1/register/register.css".equals(uri)||"/sbook1/images/index_clip_image001.gif".equals(uri)||"/sbook1/images/reg1.jpg".equals(uri)||"/sbook1/register".equals(uri)||"/sbook1/images/rabit.gif".equals(uri)||"/sbook1/images/index_clip_image001.gif".equals(uri)||session.getAttribute(Const.LOGINUNAME)!=null||"/sbook1/login.jsp".equals(uri)||"/sbook1/css/commons.css".equals(uri)||"/sbook1/css/login.css".equals(uri)||"/sbook1/images/login_logo.jpg".equals(uri)||"/sbook1/images/login_bg3.png".equals(uri)||"/sbook1/login".equals(uri)||session.getAttribute("admin")!=null){
			//直接放行
			chain.doFilter(request, response);
		}else{
			httpServletRequest.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
