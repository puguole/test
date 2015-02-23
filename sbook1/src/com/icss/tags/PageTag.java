package com.icss.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {

	private int p = 1;
	private int m = 4;
	private long total;
	private String url;
	
	@Override
	public int doStartTag() throws JspException {
		
		try {
			pageContext.getOut().print("<span style='float:right; padding-right:60px;'>");
			pageContext.getOut().print("总共"+((total-1)/m+1)+"页"+"&nbsp;&nbsp;");
			pageContext.getOut().print(p+"/"+((total-1)/m+1)+"&nbsp;&nbsp;");
			pageContext.getOut().print("<a href=\""+url+"1\">首页</a>"+"&nbsp;&nbsp;");
			if(p==1){
				pageContext.getOut().print("<a href=\""+url+"1\">上页</a>"+"&nbsp;&nbsp;");
			}else{
				pageContext.getOut().print("<a href=\""+url+(p-1)+"\">上页</a>");
			}
			for(int i=1;i<=(total-1)/m+1;i++){
				pageContext.getOut().print("<a href=\""+url+i+"\"><"+i+"></a>");
			}
			int pageMax = (int)(total-1)/m+1;
			if(p==pageMax){
				pageContext.getOut().print("<a href=\""+url+p+"\">下页</a>"+"&nbsp;&nbsp;");
			}else{
				pageContext.getOut().print("<a href=\""+url+(p+1)+"\">下页</a>"+"&nbsp;&nbsp;");
			}
			pageContext.getOut().print("<a href=\""+url+pageMax+"\">末页</a>"+"&nbsp;&nbsp;");
			pageContext.getOut().print("</span>");
		} catch (IOException e) {
			throw new JspException(e);
		}
		
		return super.doStartTag();
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
