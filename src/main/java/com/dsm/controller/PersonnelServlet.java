package com.dsm.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.entity.Salesman;
import com.dsm.model.entity.StoreManager;
import com.dsm.model.entity.User;
import com.dsm.model.entity.WarehouseManager;
import com.dsm.model.dao.impl.*;

/**
 * Servlet implementation class PersonnelServlet
 */
public class PersonnelServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonnelServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String ID = (String)session.getAttribute("ID");
		if(user == null || !ID.startsWith("X"))
		{
			return;
		}
		String method = request.getParameter("method");
		if(method.equals("salesman"))
		{
			salesman(request, response);
		}
		else if(method.equals("WarehouseManager"))
		{
			warehouseManager(request, response);
		}
		else if(method.equals("StoreManager"))
		{
			storeManager(request, response);
		}
		else if(method.equals("Manager"))
		{
			manager(request, response);
		}
	}
    
    private void salesman(HttpServletRequest request, HttpServletResponse response)
    {
    	SalesmanDao salesman = new SalesmanDao();
    	String sql = "select SalesmanNo, SalesmanName, Sex, Birthday, Age, Telephone, HireDate, StoreNo, StoreName "
    			+ "from Salesman left join Store where OnDuty = 1";
    	List<Salesman> salesmen = salesman.getForList(sql, null);
    	request.setAttribute("salesman-list", salesmen);
    }
    private void warehouseManager(HttpServletRequest request, HttpServletResponse response)
    {
    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
    	String sql = "select WareManNo, WareManName, Sex, Birthday, Age, Telephone, HireDate, WarehouseNo, WarehouseName "
    			+ "from WarehouseManager left join Warehouse where OnDuty = 1";
    	List<WarehouseManager> wareMans = warehouseManager.getForList(sql, null);
    	request.setAttribute("WarehouseManager-list", wareMans);
    }
    private void storeManager(HttpServletRequest request, HttpServletResponse response)
    {
    	StoreManagerDao storeManager = new StoreManagerDao();
    	String sql = "select StoreManNo, StoreManName, Sex, Birthday, Age, Telephone, Hiredate, StoreNo, StoreName "
    			+ "from StoreManager left join Store where OnDuty = 1";
    	List<StoreManager> StoreMans = storeManager.getForList(sql, null);
    }
    private void manager(HttpServletRequest request, HttpServletResponse response)
    {
    	
    }
}
