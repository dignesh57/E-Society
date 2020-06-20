package com.es.formDesignUltility;

import java.util.List;

import com.es.dao.DbTransactionServices;
import com.es.dao.DbTransactionServicesImpl;

public class HtmlReportHeaderDesign {

	public static final String getReoprtDesign(HtmlTableHeaderParam param, String header,int count) {
		DbTransactionServices dbts=new DbTransactionServicesImpl();
		String html = "";
		StringBuffer buffer = new StringBuffer();
		List<HtmlTable> firstRow = param.getFirstRow();
		buffer.append("<div>"); /*buffer.append("<div style=\"background-color:white;\">");*/
		buffer.append("<h2><b><center>");
		buffer.append(header);
		//buffer.append(count);
		buffer.append("</div><br/>");
		buffer.append("<div>");

		buffer.append("<table id=\"" + "1" + "\"  class=\"" + "class" + "\">");
		buffer.append("<thead>");

		buffer.append("<tr><td colspan=\"" + "1" + "\" style=\"display:none;\" data-tableexport-display=\"always\"> "
				+ "1"
				+ "</td></tr><tr><td colspan=\"11\" style=\"display:none;\" data-tableexport-display=\"always\"></td></tr>");

		if (null != firstRow) {
			buffer.append("<tr>");
			for (int i = 0; i < firstRow.size(); i++) {
				HtmlTable column = firstRow.get(i);
				String columnName = column.getTitle();
				if (null != column) {
					String rowspan = column.getRowspan() == "" ? "1" : column.getRowspan();
					String colspan = column.getColspan() == "" ? "1" : column.getColspan();
					String TableClass = "border";
					/*
					 * String colClass = column.getColClass();String colName = column.getColName();
					 */
					//HtmlTableHeader h = new HtmlTableHeader();
					buffer.append("<th rowspan=" + rowspan + " colspan=" + colspan + "><p class=" + TableClass
							+ ">" + columnName + "</p></th>");
				}
			}
			buffer.append("</tr>");
		}
		buffer.append("</div>");
		html = buffer.toString();
		return html;
	}
}
