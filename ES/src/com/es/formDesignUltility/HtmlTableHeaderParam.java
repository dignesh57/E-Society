package com.es.formDesignUltility;

import java.util.List;

public class HtmlTableHeaderParam {

	private String tableId, tableClass;
	private List<HtmlTable> firstRow;

	public HtmlTableHeaderParam(String tableID, String tableClass, List<HtmlTable> Htmltable) {
		super();
		this.tableId = tableID;
		this.tableClass = tableClass;
		this.firstRow = Htmltable;

	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getTableClass() {
		return tableClass;
	}

	public void setTableClass(String tableClass) {
		this.tableClass = tableClass;
	}

	public List<HtmlTable> getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(List<HtmlTable> firstRow) {
		this.firstRow = firstRow;
	}

}
