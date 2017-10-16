package com.dsm.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.entity.Manager;
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
		/*查询在职和离职店员，1在职，0离职*/
		if(method.equals("salesman")||method.equals("salesmanLeaved"))
		{
			if(method.equals("salesman"))
				salesman(request, response, 1);
			else
				salesman(request, response, 0);
		}
		/*查询在职和离职仓库管理员*/
		else if(method.equals("warehouseManager")||method.equals("warehouseManagerLeaved"))
		{
			if(method.equals("warehouseManager"))
				warehouseManager(request, response, 1);
			else
				warehouseManager(request, response, 0);
		}
		/*查询在职和离职分店经理*/
		else if(method.equals("storeManager")||method.equals("storeManagerLeaved"))
		{
			if(method.equals("storeManager"))
				storeManager(request, response, 1);
			else
				storeManager(request, response, 0);
		}
		/*查询在职和离职经理*/
		else if(method.equals("manager")||method.equals("managerLeaved"))
		{
			if(method.equals("manager"))
				manager(request, response, 1);
			else
				manager(request, response, 0);
		}
		/*雇佣店员*/
		else if(method.equals("addSalesman"))
		{
			addSalesman(request, response);
		}
	}
    
    private void salesman(HttpServletRequest request, HttpServletResponse response, int OnDuty)
    {
    	SalesmanDao salesman = new SalesmanDao();
    	String sql = "select SalesmanNo, SalesmanName, Sex, Birthday, Age, Telephone, HireDate, StoreNo, StoreName "
    			+ "from Salesman left join Store where OnDuty = " + OnDuty;
    	List<Salesman> salesmen = salesman.getForList(sql, null);
    	request.setAttribute("salesman-list", salesmen);
    }
    private void warehouseManager(HttpServletRequest request, HttpServletResponse response, int OnDuty)
    {
    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
    	String sql = "select WareManNo, WareManName, Sex, Birthday, Age, Telephone, HireDate, WarehouseNo, WarehouseName "
    			+ "from WarehouseManager left join Warehouse where OnDuty = " + OnDuty;
    	List<WarehouseManager> wareMans = warehouseManager.getForList(sql, null);
    	request.setAttribute("warehouseManager-list", wareMans);
    }
    private void storeManager(HttpServletRequest request, HttpServletResponse response, int OnDuty)
    {
    	StoreManagerDao storeManager = new StoreManagerDao();
    	String sql = "select StoreManNo, StoreManName, Sex, Birthday, Age, Telephone, Hiredate, StoreNo, StoreName "
    			+ "from StoreManager left join Store where OnDuty = " + OnDuty;
    	List<StoreManager> storeMans = storeManager.getForList(sql, null);
    	request.setAttribute("storeManager-list", storeMans);
    }
    private void manager(HttpServletRequest request, HttpServletResponse response, int OnDuty)
    {
    	ManagerDao manager = new ManagerDao();
    	String sql = "select ManagerNo, ManagerName, Sex, Birthday, Age, Telephone, Hiredate "
    			+ "from Manager where OnDuty = " + OnDuty;
    	List<Manager> managers = manager.getForList(sql, null);
    	request.setAttribute("mamager-list", managers);
    }
    private void addSalesman(HttpServletRequest request, HttpServletResponse response)
    {
    	SalesmanDao salesman = new SalesmanDao();
    	Salesman newSalesman = new Salesman(request.getParameter("No"), request.getParameter("Name"), 
    			request.getParameter("sex"), request.getParameter("birthday"), request.getParameter("age"), 
    			request.getParameter("telephone"), );
    	
    }
}
