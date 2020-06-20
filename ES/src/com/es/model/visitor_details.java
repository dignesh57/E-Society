package com.es.model;

import lombok.Getter;
import lombok.Setter;

public class visitor_details {

	@Getter
	@Setter
	private String options, name, phone_number, vehical_number, wing_name, house_number, member_name, in_time_with_date,
			out_time_with_date, purpose, entered_by, entered_on, last_updated_by, last_updated_on, is_active_Y_N;
	@Getter
	@Setter
	private String soc_id;

}