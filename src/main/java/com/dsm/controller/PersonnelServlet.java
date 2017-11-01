package com.dsm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsm.model.dao.impl.SalesmanDao;
import com.dsm.model.dao.impl.StoreManagerDao;
import com.dsm.model.dao.impl.WarehouseManagerDao;
import com.dsm.model.entity.Salesman;
import com.dsm.model.entity.StoreManager;
import com.dsm.model.entity.WarehouseManager;

/**
 * Servlet implementation class PersonnelServlet
 */
public class PersonnelServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	// 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024;  	// 1MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 4; 	// 4MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 5; 	// 5MB
       
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();
		//String ID = (String)session.getAttribute("user_id");
		String ID = "00000001";
		if(!ID.startsWith("0") && !ID.startsWith("2"))
		{
			request.getRequestDispatcher("ErrorJsp.jsp").forward(request, response);
			return;
		}
		String method = request.getParameter("method");
		System.out.println(method);
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
		/*雇佣店员*/
		else if(method.equals("deleteSalesman"))
		{
			deleteSalesman(request, response);
		}
		else if(method.equals("deleteWarehouseManager"))
		{
			deleteWarehouseManager(request, response);
		}
		else if(method.equals("deleteStoreManager"))
		{
			deleteStoreManager(request, response);
		}
		request.getRequestDispatcher("/personnel/personnel.jsp").forward(request,response);
	}
    
    private void salesman(HttpServletRequest request, HttpServletResponse response, int OnDuty)
    {
    	SalesmanDao salesman = new SalesmanDao();
    	String sql = "select SalesmanNo, SalesmanName, Sex, Birthday, Telephone, HireDate, StoreNo, StoreName "
    			+ "from Salesman left join Store where OnDuty = " + OnDuty;
    	List<Salesman> salesmen = salesman.getForList(sql, null);
    	request.setAttribute("salesman-list", salesmen);
    }
    private void warehouseManager(HttpServletRequest request, HttpServletResponse response, int OnDuty)
    {
    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
    	String sql = "select WareManNo, WareManName, Sex, Birthday, Telephone, HireDate, WarehouseNo, WarehouseName "
    			+ "from WarehouseManager left join Warehouse where OnDuty = " + OnDuty;
    	List<WarehouseManager> wareMans = warehouseManager.getForList(sql, null);
    	request.setAttribute("warehouseManager-list", wareMans);
    }
    private void storeManager(HttpServletRequest request, HttpServletResponse response, int OnDuty)
    {
    	StoreManagerDao storeManager = new StoreManagerDao();
    	String sql = "select StoreManNo, StoreManName, Sex, Birthday, Telephone, Hiredate, StoreNo, StoreName "
    			+ "from StoreManager left join Store where OnDuty = " + OnDuty;
    	List<StoreManager> storeMans = storeManager.getForList(sql, null);
    	request.setAttribute("storeManager-list", storeMans);
    }
    private void deleteSalesman(HttpServletRequest request, HttpServletResponse response)
    {
    	SalesmanDao salesman = new SalesmanDao();
    	String sql = "select SalesmanNo from Salesman where OnDuty = 1";
    	List<Salesman> salesmen = salesman.getForList(sql, null);
    	int count = 0;
    	for(Salesman iter : salesmen)
    	{
    		if("on".equals(request.getParameter(iter.getSalesmanno())))
    		{
    			sql = "update Salesman set OnDuty = 0 where SalesmanNo = ?";
    			String pk = salesman.update(sql, iter.getSalesmanno());
    			if(pk != null)
    				count++;
    		}
    	}
    	request.setAttribute("message", "" + count);
    }
    private void deleteWarehouseManager(HttpServletRequest request, HttpServletResponse response)
    {
    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
    	String sql = "select WareManNo from WarehouseManager where OnDuty = 1";
    	List<WarehouseManager> warehouseManagers = warehouseManager.getForList(sql, null);
    	int count = 0;
    	for(WarehouseManager iter : warehouseManagers)
    	{
    		if("on".equals(request.getParameter(iter.getWaremanno())))
    		{
    			sql = "update WarehouseManager set OnDuty = 0 where WareManNo = ?";
    			String pk = warehouseManager.update(sql, iter.getWaremanno());
    			if(pk != null)
    				count++;
    		}
    	}
    	request.setAttribute("message", "" + count);
    }
    private void deleteStoreManager(HttpServletRequest request, HttpServletResponse response)
    {
    	StoreManagerDao storeManager = new StoreManagerDao();
    	String sql = "update StoreManager set OnDuty = 0 where StoreManNo = ?";
    	String[] nos = request.getParameterValues("nos");
    	System.out.println(nos.length);
    	for(String no : nos)
    	{
    		System.out.println(no);
    		storeManager.update(sql, no);
    	}
    }
}
