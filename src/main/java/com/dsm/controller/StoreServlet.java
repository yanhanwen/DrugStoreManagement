package com.dsm.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dsm.model.dao.impl.StoreDao;
import com.dsm.model.entity.Store;
import com.dsm.model.entity.User;

/**
 * Servlet implementation class StoreServlet
 */
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String ID = "23456";
		//String ID = (String) session.getAttribute("user_id");
		if ( !ID.startsWith("2")) {
			return;
		}
		
		String method = null;
		method = request.getParameter("method");
		
		if (method.equals("addStore"))
		{
			addStore(request, response);
		}
		else if (method.equals("getStoreInfo"))
		{
			getStoreInfo(request, response);
		}
		else if (method.equals("closeStore"))
		{
			closeStore(request, response);
		}
		else if (method.equals("modifyStoreInfo"))
		{
			modifyStoreInfo(request, response);
		}
	}
	
	private void addStore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = sdf.format(new java.util.Date());
		Timestamp timestamp=null;
		timestamp=Timestamp.valueOf(s);
    	
		StoreDao store = new StoreDao();
		Store    newStore = new Store(request.getParameter("StoreNo"),   request.getParameter("StoreName"),
									  request.getParameter("Province"),  request.getParameter("City"), 
									  request.getParameter("District"),  request.getParameter("Street"),
									  request.getParameter("AddrDetail"), request.getParameter("Telephone"),
									  timestamp, new java.math.BigDecimal(request.getParameter("MonthlyCost")), new BigDecimal(1));
		//String sql = "select * from Store";
		store.addObject(newStore);
		request.setAttribute("message","添加成功");
	}
	
	private void modifyStoreInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		StoreDao store = new StoreDao();
		
		String StorerNo=request.getParameter("StorerNo");
		String StoreName=request.getParameter("StoreName");
		String Province=request.getParameter("Province");
		String City=request.getParameter("City");
		String District=request.getParameter("District");
		String Street=request.getParameter("Street");
		String AddrDetail=request.getParameter("AddrDetail");
		String Telephone=request.getParameter("Telephone");
		//String Remark=request.getParameter("Remark");
		String sql="update Store set StoreName=?,Province=?,"
				+ "City=?,District=?,Street=?,"
				+ "AddrDetail=?,Telephone=?, where StoreNo=?";
		String message=store.update(sql, StoreName,Province,City,District,Street,AddrDetail,Telephone, StorerNo);
		if(message.equals("noneof")||message.equals("0")) {
			request.setAttribute("message","修改失败");
		}else {
			request.setAttribute("message","修改成功");
		}
	}
	
	private void closeStore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		StoreDao store = new StoreDao();
		
		String storeNo=request.getParameter("StoreNo");
		String sql = "update Store set isOpen = 0 where StoreNo = " + "'" +  storeNo + "'";
		String message=store.update(sql);
		request.setAttribute("message","删除成功");
	}
	
	private void getStoreInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		StoreDao store = new StoreDao();
		
		String sql = "select * from Store";
		List<Store> storeInfo = store.getForList(sql, null);
		request.setAttribute("storeInfo-list", storeInfo);
	}

}
