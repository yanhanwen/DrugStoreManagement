package com.dsm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.dao.impl.ManagerDao;
import com.dsm.model.dao.impl.SalesmanDao;
import com.dsm.model.dao.impl.StoreManagerDao;
import com.dsm.model.dao.impl.WarehouseManagerDao;
import com.dsm.model.entity.Manager;
import com.dsm.model.entity.Salesman;
import com.dsm.model.entity.StoreManager;
import com.dsm.model.entity.WarehouseManager;

public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/user/LoginJsp.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String message = null;
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		if(user_id==null||password==null||user_id.equals("")||password.equals(""))
		{
			message = "不能为空";
			response.sendRedirect("/manager/LoginJsp.jsp");
		}
		char identity = user_id.charAt(0);
		HttpSession session = request.getSession();
		if(identity=='0')
		{
			String sql = "select passwd from Manager where ManagerNo = ?";
			ManagerDao mdao = new ManagerDao();
			Manager m = mdao.getSingleObject(sql,user_id);
			if(m==null)
			{
				message = "无此用户名";
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				return;
			}
			if(m.getPasswd()!=null&&m.getPasswd().equals(password))
			{
				session.setAttribute("user_id", user_id);
				request.getRequestDispatcher("/manager/FunctionJsp.jsp").forward(request, response);
				return;
			}
			else
			{
				message = "密码错误！";
				request.setAttribute("message",message);
				request.setAttribute("user_id", user_id);
				request.getRequestDispatcher("LoginJsp.jsp").forward(request, response);
				return;
			}
		}
		if(identity=='1')
		{
			String sql = "select passwd from WarehouseManager where WarehouseManagerNo = ?";
			WarehouseManagerDao wmdao = new WarehouseManagerDao();
			WarehouseManager wm = wmdao.getSingleObject(sql,user_id);
			if(wm==null)
			{
				message = "无此用户名";
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				return;
			}
			if(wm.getPasswd()!=null&&wm.getPasswd().equals(password))
			{
				session.setAttribute("user_id", user_id);
				request.getRequestDispatcher("/warehousemanager/FunctionJsp.jsp").forward(request, response);
				return;
			}
			else
			{
				message = "密码错误！";
				request.setAttribute("message",message);
				request.setAttribute("user_id", user_id);
				request.getRequestDispatcher("LoginJsp.jsp").forward(request, response);
				return;
			}
		}
		if(identity=='2')
		{
			String sql = "select passwd from StoreManager where StoreManagerNo = ?";
			StoreManagerDao smdao = new StoreManagerDao();
			StoreManager sm = smdao.getSingleObject(sql,user_id);
			if(sm==null)
			{
				message = "无此用户名";
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				return;
			}
			if(sm.getPasswd()!=null&&sm.getPasswd().equals(password))
			{
				session.setAttribute("user_id", user_id);
				request.getRequestDispatcher("/storemanager/FunctionJsp.jsp").forward(request, response);
				return;
			}
			else
			{
				message = "密码错误！";
				request.setAttribute("message",message);
				request.setAttribute("user_id", user_id);
				request.getRequestDispatcher("LoginJsp.jsp").forward(request, response);
				return;
			}
		}
		if(identity=='3')
		{
			String sql = "select passwd from Salesman where SalesmanNo = ?";
			SalesmanDao mdao = new SalesmanDao();
			Salesman m = mdao.getSingleObject(sql,user_id);
			if(m==null)
			{
				message = "无此用户名";
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				return;
			}
			if(m.getPasswd()!=null&&m.getPasswd().equals(password))
			{
				session.setAttribute("user_id", user_id);
				request.getRequestDispatcher("/salesman/FunctionJsp.jsp").forward(request, response);
				return;
			}
			else
			{
				message = "密码错误！";
				request.setAttribute("message",message);
				request.setAttribute("user_id", user_id);
				request.getRequestDispatcher("LoginJsp.jsp").forward(request, response);
				return;
			}
		}
	}
}
