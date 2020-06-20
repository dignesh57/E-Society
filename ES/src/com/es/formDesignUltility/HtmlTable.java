package com.es.formDesignUltility;

public class HtmlTable {

	private String id,rowspan,colspan,classname,title;
	
	public HtmlTable(String id,String rowspan,String colspan,String classname,String title) {
		super();
		this.id=id;
		this.rowspan=rowspan;
		this.colspan=colspan;
		this.classname=classname;
		this.title=title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRowspan() {
		return rowspan;
	}

	public void setRowspan(String rowspan) {
		this.rowspan = rowspan;
	}

	public String getColspan() {
		return colspan;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
