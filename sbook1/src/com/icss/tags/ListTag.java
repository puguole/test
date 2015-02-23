package com.icss.tags;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ListTag extends TagSupport {

	private List<?> list;
	private String indexName="index",voName="vo";
	

	
	   
	@Override
	public int doStartTag() throws JspException {
		int index = 0;
		try {
			pageContext.setAttribute(indexName, index);
	    	pageContext.setAttribute(voName, list.get(index));
		} catch (Exception e) {
		}
		return EVAL_BODY_INCLUDE;
	}
	
	
	@Override
	public int doAfterBody() throws JspException {
		int index = (Integer) pageContext.getAttribute(indexName);
    	++index;
    	if(list.size()>index){
    	    pageContext.setAttribute(indexName, index);
    		pageContext.setAttribute(voName, list.get(index));
    		return EVAL_BODY_AGAIN;
    	}else{
    		return SKIP_BODY;
    	}
	}


	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getVoName() {
		return voName;
	}
	public void setVoName(String voName) {
		this.voName = voName;
	}
	   
	   
}
