package com.es.model;

public class notice {
	private String notice_id,soc_id,secretary_id,notice,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N;
	
	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}

	public String getSoc_id() {
		return soc_id;
	}

	public void setSoc_id(String soc_id) {
		this.soc_id = soc_id;
	}

	public String getSecretary_id() {
		return secretary_id;
	}

	public void setSecretary_id(String secretary_id) {
		this.secretary_id = secretary_id;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getEntered_by() {
		return entered_by;
	}

	public void setEntered_by(String entered_by) {
		this.entered_by = entered_by;
	}

	public String getEntered_on() {
		return entered_on;
	}

	public void setEntered_on(String entered_on) {
		this.entered_on = entered_on;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public String getLast_updated_on() {
		return last_updated_on;
	}

	public void setLast_updated_on(String last_updated_on) {
		this.last_updated_on = last_updated_on;
	}

	public String getIs_active_Y_N() {
		return is_active_Y_N;
	}

	public void setIs_active_Y_N(String is_active_Y_N) {
		this.is_active_Y_N = is_active_Y_N;
	}

}
