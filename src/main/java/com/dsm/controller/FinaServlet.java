package com.dsm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.entity.User;
import com.dsm.model.entity.Warehouse;
import com.dsm.model.dao.impl.WarehouseDao;

public class FinaServlet extends HttpServlet
{
	public FinaServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String ID = (String) session.getAttribute("XXXID");
		if(user == null && !ID.startsWith("XXX")) 
		{
			String url = request.getHeader("Referer");
			request.getRequestDispatcher("url").forward(request,response);
			return;
		}
		WarehouseDao wh = new WarehouseDao();
		String sql = "select MonthlyCost from Warehouse";
		
	}
}
