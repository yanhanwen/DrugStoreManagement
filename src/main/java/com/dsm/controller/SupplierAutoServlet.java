package com.dsm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.dao.impl.SupplierDao;
import com.dsm.model.entity.Supplier;
import com.dsm.model.entity.User;

/**
 * Servlet implementation class SupplierAutoServlet
 */
public class SupplierAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierAutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String ID = "0123456";//(String)session.getAttribute("user_id");
		String message = "";
		if( !ID.startsWith("0"))
		{
			message = "您没有供应商管理权限。";
			return;
		}
		String method = request.getParameter("method");
		if(!method.equals("autoQuery"))
		{
			message = "非法访问。";
			return;
		}
		/*request.setAttribute("ID", ID);*/
		SupplierDao supplier = new SupplierDao();
		String sql = "select * from Supplier where onduty=1";
		List<Supplier> suppliers = supplier.getForList(sql, null);
		request.getSession().setAttribute("supplier-list", suppliers);
		request.getSession().setAttribute("message", "autoQuery");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
