package com.icss.express.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {

	/**
	 * 当前页码
	 */
	private int pagination;
	/**
	 * 每页最大数，默认 10
	 */
	private int rowMax=10;
	/**
	 * 所有记录数
	 */
	private long rowAll;
	
	/**
	 * 显示的页面数量
	 */
	private int num=6;
	
	/**
	 * 页码的存放名称
	 */
	private String pageVar="page";
	/**
	 * 页码内容的存放名称
	 */
	private String textVar="text";
	
	private List<String> textList;
	private List<Integer> pageList;
	
	private int count;
	
	@Override
	public int doAfterBody() throws JspException {
		++ count;
    	if(count>=pageList.size()){
    		return SKIP_BODY;
    	}else{
            pageContext.setAttribute(textVar, textList.get(count));
            pageContext.setAttribute(pageVar, pageList.get(count));
        	return EVAL_BODY_AGAIN;
    	}
	}
	
	@Override
	public int doStartTag() throws JspException {
		int pageMax = (int)(rowAll-1)/rowMax+1;
		if(pageMax<2){
			return SKIP_BODY;
		}
		
		textList=new ArrayList<String>(0);
		pageList=new ArrayList<Integer>(0);
		count=0;
		
		if(pagination<1){
			pagination=1;
		}
		if(pagination>pageMax){
			pagination=pageMax;
		}
		
		if(pagination>1){
			textList.add("首页");
			pageList.add(1);
			textList.add("上一页");
			pageList.add(pagination-1);
		}
		
		int beginPage = pagination-(int)(num/2);
		if(beginPage<1){
			beginPage=1;
		}
		
		int endPage = beginPage+num-1;
		if(endPage>pageMax){
			endPage=pageMax;
			beginPage=endPage-num+1;
			if(beginPage<1){
				beginPage=1;
			}
		}
		
		for(int i=beginPage;i<=endPage;i++){
			textList.add(Integer.toString(i));
			pageList.add(i);
		}
		
		if(pagination<pageMax){
			textList.add("下一页");
			pageList.add(pagination+1);
			textList.add("末页");
			pageList.add(pageMax);
		}
		
        pageContext.setAttribute(textVar, textList.get(count));
        pageContext.setAttribute(pageVar, pageList.get(count));
		return EVAL_BODY_INCLUDE;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public int getRowMax() {
		return rowMax;
	}

	public void setRowMax(int rowMax) {
		this.rowMax = rowMax;
	}

	public long getRowAll() {
		return rowAll;
	}

	public void setRowAll(long rowAll) {
		this.rowAll = rowAll;
	}

	public String getPageVar() {
		return pageVar;
	}

	public void setPageVar(String pageVar) {
		this.pageVar = pageVar;
	}

	public String getTextVar() {
		return textVar;
	}

	public void setTextVar(String textVar) {
		this.textVar = textVar;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
