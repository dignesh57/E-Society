package com.es.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.formDesignUltility.FormFieldUltilityconstant;

/**
 * Servlet implementation class SuccessController
 */
@WebServlet("/SuccessController")
public class SuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String formname=request.getParameter("formname");
		if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_state_name)) {
			response.sendRedirect("mst_state.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_city_name)) {
			response.sendRedirect("mst_mst_city.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_area_name)) {
			response.sendRedirect("mst_mst_mst_area.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.register_society_name)) {
			response.sendRedirect("register_society.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_role_name)) {
			response.sendRedirect("mst_role.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_service_name)) {
			response.sendRedirect("mst_service.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_problem_type__name)) {
			response.sendRedirect("mst_problem_Type.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_amenities_name)) {
			response.sendRedirect("mst_amenities.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_complain_name)) {
			response.sendRedirect("mst_complain.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_event_name)) {
			response.sendRedirect("mst_event.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_tax_name)) {
			response.sendRedirect("mst_tax.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_bill_name)) {
			response.sendRedirect("mst_bill.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_expense_name)) {
			response.sendRedirect("mst_expense.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_visitor_name)) {
			response.sendRedirect("mst_visitor.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_id_name)) {
			response.sendRedirect("mst_id_type.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.registration_page_name)) {
			response.sendRedirect("registration_page.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.login_page_name)) {
			response.sendRedirect("login_page.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.forgot_password_name)) {
			response.sendRedirect("forgot_password.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_status_name)) {
			response.sendRedirect("mst_status.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_problem_type__name)) {
			response.sendRedirect("mst_problem_Type.jsp");
		}
		else if(formname.equalsIgnoreCase(FormFieldUltilityconstant.mst_maintenance_name)) {
			response.sendRedirect("mst_maintenance.jsp");
		}
		else {
			response.sendRedirect("Page_not_found.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
