package com.dsm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.dao.impl.SalesmanDao;
import com.dsm.model.dao.impl.StoreManagerDao;
import com.dsm.model.dao.impl.WarehouseManagerDao;
import com.dsm.model.entity.Salesman;
import com.dsm.model.entity.StoreManager;
import com.dsm.model.entity.User;
import com.dsm.model.entity.WarehouseManager;

/**
 * Servlet implementation class PersonnelAutoServlet
 */
public class PersonnelAutoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonnelAutoServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String ID = (String)session.getAttribute("ID");
		String message = "";
		if(user == null || !ID.startsWith("0") || !ID.startsWith("2"))
		{
			message = "您没有人事管理权限。";
			return;
		}
		String method = request.getParameter("method");
		if(!method.equals("autoQuery"))
		{
			message = "非法访问。";
			return;
		}
		request.setAttribute("ID", ID);
		if(ID.startsWith("0"))
		{
			StoreManagerDao storeManager = new StoreManagerDao();
	    	String sql = "select StoreManNo, StoreManName, Sex, Birthday, Age, Telephone, Hiredate, StoreNo, StoreName "
	    			+ "from StoreManager left join Store where OnDuty = 1";
	    	List<StoreManager> storeMans = storeManager.getForList(sql, null);
	    	request.setAttribute("storeManager-list", storeMans);
	    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
	    	String sql = "select WareManNo, WareManName, Sex, Birthday, Age, Telephone, HireDate, WarehouseNo, WarehouseName "
	    			+ "from WarehouseManager left join Warehouse where OnDuty = 1";
	    	List<WarehouseManager> wareMans = warehouseManager.getForList(sql, null);
	    	request.setAttribute("warehouseManager-list", wareMans);
		}
		else if(ID.startsWith("2"))
		{
			SalesmanDao salesman = new SalesmanDao();
	    	String sql = "select SalesmanNo, SalesmanName, Sex, Birthday, Age, Telephone, HireDate, StoreNo, StoreName "
	    			+ "from Salesman left join Store where OnDuty = 1";
	    	List<Salesman> salesmen = salesman.getForList(sql, null);
	    	request.setAttribute("salesman-list", salesmen);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
