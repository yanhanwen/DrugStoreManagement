package com.dsm.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class SupplierServlet
 */
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupplierServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String ID = "0123456";//(String) session.getAttribute("user_id");
		if ( !ID.startsWith("0")) {
			return;
		}
		String method =null;
		method = request.getParameter("method");
		if (method.equals("supplier") || method.equals("supplierLeaved")) {
			if (method.equals("supplier"))
				supplier(request, response, 1);// 查询在职供应商
			else
				supplier(request, response, 0);// 查询离职供应商
		} else if (method.equals("addSupplier")) {
			addSupplier(request, response);
		} else if (method.equals("deleteSupplier")) {
			deleteSupplier(request,response);
		} else if (method.equals("modifySupplier")) {
			modifySupplier(request, response);
		}
		request.getRequestDispatcher("/supplier/Supplier.jsp").forward(request, response);
	}

	private void deleteSupplier(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SupplierDao supplierDao=new SupplierDao();
		String supplierNo=request.getParameter("SupplierNo");
		String sql="update Supplier set OnDuty=0 where SupplierNo="+"'"+supplierNo+"'";
		String message=supplierDao.update(sql);
		if(message.equals("noneof")||message.equals("0")) {
			request.setAttribute("message","删除失败");
		}else {
			request.setAttribute("message","删除成功");
		}
	}

	private void modifySupplier(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SupplierDao supplierDao=new SupplierDao();
		String SupplierNo=request.getParameter("SupplierNo");
		String SupplierName=request.getParameter("SupplierName");
		String ContactName=request.getParameter("ContactName");
		String Telephone=request.getParameter("Telephone");
		String Province=request.getParameter("Province");
		String City=request.getParameter("City");
		String District=request.getParameter("District");
		String Street=request.getParameter("Street");
		String AddrDetail=request.getParameter("AddrDetail");
		String Rate=request.getParameter("Rate");
		String Remark=request.getParameter("Remark");
		String sql="update Supplier set SupplierName=?,ContactName=?,Telephone=?,Province=?,"
				+ "City=?,District=?,Street=?,"
				+ "AddrDetail=?,Rate=?,Remark=? where SupplierNo=?";
		String message=supplierDao.update(sql, SupplierName, ContactName,Telephone,Province,City,District,Street,AddrDetail,Rate,Remark,SupplierNo);
		if(message.equals("noneof")||message.equals("0")) {
			request.setAttribute("message","修改失败");
		}else {
			request.setAttribute("message","修改成功");
		}
	}

	private void addSupplier(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// String sql="insert into Supplier"
		SupplierDao supplierDao = new SupplierDao();
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false); // 是否是严格的匹配
		String addDate = request.getParameter("AddDate");
		java.util.Date utilDate = null;
		try {
			utilDate = sdf.parse(addDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = sdf.format(new java.util.Date());
		Timestamp timestamp=null;
		timestamp=Timestamp.valueOf(s);
		BigDecimal Rate=new BigDecimal(request.getParameter("Rate"));
		Supplier supplier = new Supplier(request.getParameter("SupplierNo"), request.getParameter("SupplierName"),
				request.getParameter("ContactName"), request.getParameter("Telephone"),
				request.getParameter("Province"), request.getParameter("City"), request.getParameter("District"),
				request.getParameter("Street"), request.getParameter("AddrDetail"),
				Rate, timestamp, request.getParameter("Remark"), new BigDecimal(1));
		supplierDao.addObject(supplier);
		if(supplierDao.getKey().equals("noneof")) {
			request.setAttribute("message","添加失败");
		}else {
			request.setAttribute("message","添加成功");
		}
	}

	private void supplier(HttpServletRequest request, HttpServletResponse response, int onduty) {
		// TODO Auto-generated method stub
		SupplierDao supplier = new SupplierDao();
		String sql = "select * from Supplier where onduty=" + onduty;
		List<Supplier> suppliers = supplier.getForList(sql, null);
		request.setAttribute("supplier-list", suppliers);

	}

}

