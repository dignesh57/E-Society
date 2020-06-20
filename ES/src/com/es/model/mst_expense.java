package com.es.model;

public class mst_expense {

	private String soc_id,exp_id,exp_type,price,entered_by,entered_on,last_update_by,last_update_on,is_active_Y_N;

	public String getSoc_id() {
		return soc_id;
	}

	public void setSoc_id(String soc_id) {
		this.soc_id = soc_id;
	}

	public String getExp_id() {
		return exp_id;
	}

	public void setExp_id(String exp_id) {
		this.exp_id = exp_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getExp_type() {
		return exp_type;
	}

	public void setExp_type(String exp_type) {
		this.exp_type = exp_type;
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

	public String getLast_update_by() {
		return last_update_by;
	}

	public void setLast_update_by(String last_update_by) {
		this.last_update_by = last_update_by;
	}

	public String getLast_update_on() {
		return last_update_on;
	}

	public void setLast_update_on(String last_update_on) {
		this.last_update_on = last_update_on;
	}

	public String getIs_active_Y_N() {
		return is_active_Y_N;
	}

	public void setIs_active_Y_N(String is_active_Y_N) {
		this.is_active_Y_N = is_active_Y_N;
	}	
}
