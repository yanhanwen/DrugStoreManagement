package com.dsm.controller;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dsm.model.entity.Manager;
import com.dsm.model.entity.Salesman;
import com.dsm.model.entity.StoreManager;
import com.dsm.model.entity.User;
import com.dsm.model.entity.WarehouseManager;
import com.dsm.model.utils.JDBCTools;
import com.dsm.model.dao.impl.*;

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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String ID = (String)session.getAttribute("user_id");
		request.setAttribute("ID", ID);
		String message = "";
		if(!ID.startsWith("0") || !ID.startsWith("2"))
		{
			message = "您没有人事管理权限。";
			return;
		}
		String method = request.getParameter("method");
		if(method.equals("autoQuery"))
		{
			if(ID.startsWith("0"))
			{
				StoreManagerDao storeManager = new StoreManagerDao();
		    	String sql = "select StoreManNo, StoreManName, Sex, Birthday, Age, Telephone, Hiredate, StoreManager.StoreNo, StoreName "
		    			+ "from StoreManager left join Store where OnDuty = 1";
		    	List<StoreManager> storeMans = storeManager.getForList(sql, null);
		    	request.setAttribute("storeManager-list", storeMans);
		    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
		    	sql = "select WareManNo, WareManName, Sex, Birthday, Age, Telephone, HireDate, WarehouseNo, WarehouseName "
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
		/*查询在职和离职店员，1在职，0离职*/
		else if(method.equals("salesman")||method.equals("salesmanLeaved"))
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
		/*else if(method.equals("manager")||method.equals("managerLeaved"))
		{
			if(method.equals("manager"))
				manager(request, response, 1);
			else
				manager(request, response, 0);
		}*/
		/*雇佣店员*/
		else if(method.equals("addSalesman"))
		{
			addSalesman(request, response);
		}
		else if(method.equals("addWarehouseManager"))
		{
			addWarehouseManager(request, response);
		}
		else if(method.equals("addStoreManager"))
		{
			addStoreManager(request, response);
		}
		/*else if(method.equals("addManager"))
		{
			addManager(request, response);
		}*/
		/*else if(method.startsWith("add") && method.endsWith("Icon"))
		{
			String temp = method.substring(3);
			StringBuilder sb = new StringBuilder(temp);
			temp = sb.reverse().toString();
			String role = new StringBuilder(temp.substring(4)).reverse().toString();
			addIcon(request, response, role);
		}*/
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
		else if(method.equals("moditySalesman"))
		{
			modifySalesman(request, response);
		}
		else if(method.equals("modifyWarehouseManager"))
		{
			modifyWarehouseManager(request, response);
		}
		else if(method.equals("modifyStoreManager"))
		{
			modifyStoreManager(request, response);
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
    /*private void manager(HttpServletRequest request, HttpServletResponse response, int OnDuty)
    {
    	ManagerDao manager = new ManagerDao();
    	String sql = "select ManagerNo, ManagerName, Sex, Birthday, Age, Telephone, Hiredate "
    			+ "from Manager where OnDuty = " + OnDuty;
    	List<Manager> managers = manager.getForList(sql, null);
    	request.setAttribute("mamager-list", managers);
    }*/
    private void addSalesman(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	java.util.Date utilDate = new java.util.Date();					//获取当前时间
    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());	//将当前时间转为java.sql.Date类型
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		//设置日期格式
    	java.util.Date utilBirthday = null;
    	try
    	{
    		utilBirthday = sdf.parse(request.getParameter("addSalesmanBirthday"));	//将string转为java.util.Date格式
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	java.sql.Date sqlBirthday = new java.sql.Date(utilBirthday.getTime());		//转为sql.Date格式
    	SalesmanDao salesman = new SalesmanDao();
    	Salesman newSalesman = new Salesman(request.getParameter("addSalesmanNo"), request.getParameter("addSalesmanName"), 
    			request.getParameter("addSalesmanSex"), sqlBirthday, request.getParameter("addSalesmanTelephone"), 
    			sqlDate, request.getParameter("addSalesmanStoreNo"), new java.math.BigDecimal(request.getParameter("addSalesmanSalary")), 
    			request.getParameter("addSalesmanPasswd"), 1);
    	addIcon(request, response, "salesman", "salesman");
    	salesman.addObject(newSalesman);
    }
    private void addWarehouseManager(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	java.util.Date utilDate = new java.util.Date();					//获取当前时间
    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());	//将当前时间转为java.sql.Date类型
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		//设置日期格式
    	java.util.Date utilBirthday = null;
    	try
    	{
    		utilBirthday = sdf.parse(request.getParameter("addWarehouseManBirthday"));	//将string转为java.util.Date格式
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	java.sql.Date sqlBirthday = new java.sql.Date(utilBirthday.getTime());		//转为sql.Date格式
    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
    	WarehouseManager newWarehouseManager = new WarehouseManager(request.getParameter("addWarehouseManNo"), request.getParameter("addWarehouseManName"), 
    			request.getParameter("addWarehouseManSex"), sqlBirthday, request.getParameter("addWarehouseManTelephone"), 
    			sqlDate, request.getParameter("addWarehouseManWarehouseNo"), new java.math.BigDecimal(request.getParameter("addWarehouseManSalary")), 
    			request.getParameter("addWarehouseManPasswd"), request.getParameter("addWarehouseManManagerNo"), 1);
    	addIcon(request, response, "warehouseManager", "wareMan");
    	warehouseManager.addObject(newWarehouseManager);
    }
    private void addStoreManager(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	java.util.Date utilDate = new java.util.Date();					//获取当前时间
    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());	//将当前时间转为java.sql.Date类型
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		//设置日期格式
    	java.util.Date utilBirthday = null;
    	try
    	{
    		utilBirthday = sdf.parse(request.getParameter("addWarehouseManBirthday"));	//将string转为java.util.Date格式
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	java.sql.Date sqlBirthday = new java.sql.Date(utilBirthday.getTime());		//转为sql.Date格式
    	StoreManagerDao storeManager = new StoreManagerDao();
    	StoreManager newStoreManager = new StoreManager(request.getParameter("addStoreManNo"), request.getParameter("addStoreManName"), 
    			request.getParameter("addStoreManSex"), sqlBirthday, request.getParameter("addStoreManTelephone"), 
    			sqlDate, request.getParameter("addStoreManStoreNo"), new java.math.BigDecimal(request.getParameter("addStoreManSalary")), 
    			request.getParameter("addStoreManPasswd"), request.getParameter("addStoreManManagerNo"), 1);
    	addIcon(request, response, "storeManager", "storeMan");
    	storeManager.addObject(newStoreManager);
    }
    /*private void addManager(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	java.util.Date utilDate = new java.util.Date();					//获取当前时间
    	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());	//将当前时间转为java.sql.Date类型
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		//设置日期格式
    	java.util.Date utilBirthday = null;
    	try
    	{
    		utilBirthday = sdf.parse(request.getParameter("birthday"));	//将string转为java.util.Date格式
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	java.sql.Date sqlBirthday = new java.sql.Date(utilBirthday.getTime());		//转为sql.Date格式
    	ManagerDao manager = new ManagerDao();
    	Manager newManager = new Manager(request.getParameter("No"), request.getParameter("Name"), 
    			request.getParameter("sex"), sqlBirthday, request.getParameter("telephone"), 
    			sqlDate, new java.math.BigDecimal(request.getParameter("salary")), 
    			request.getParameter("passwd"), 1);
    	addIcon(request, response, "manager", "manager");
    	manager.addObject(newManager);
    }*/
    private void addIcon(HttpServletRequest request, HttpServletResponse response, String role, String roleNo)
    {
    	//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
    	String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
    	File file = new File(savePath);
    	//判断上传文件的保存目录是否存在
    	if (!file.exists() && !file.isDirectory())
    	{
    		//创建目录
    		file.mkdir();
    	}
    	//消息提示
        String message = "";
        try
        {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8"); 
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request))
            {
                //按照传统方式获取数据
                return;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list)
            {
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField())
                {
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    //System.out.println(name + "=" + value);
                }
                else
                {
                	//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    String filename = item.getName();
                    if(filename==null || filename.trim().equals(""))
                    {
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //转为FileInputStream
                    //FileInputStream fin = null;
                    //if(in instanceof FileInputStream)
                    	//fin = (FileInputStream) in;
                    //else
                    	//throw new Exception();
                    Connection con = JDBCTools.getConnection();
                    String sql = "update " + role + "set Icon = ? where " + roleNo + "No = ?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setBinaryStream(1, in, (int)file.length());
                    pstmt.setString(2, request.getParameter("No"));
                    int i = pstmt.executeUpdate();
                    JDBCTools.releaseConnection(con, pstmt, null);
                    //创建一个文件输出流
                    //FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                    //创建一个缓冲区
                    //byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    //int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    //while((len=in.read(buffer))>0)
                    //{
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        //out.write(buffer, 0, len);
                    //}
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    //out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    if(i == 1)
                    	message = "头像上传成功！";
                    else
                    	message = "头像上传失败！";
                }
            }
        }
        catch (Exception e)
        {
            message= "头像上传失败！";
            e.printStackTrace();
        }
    }
    private void deleteSalesman(HttpServletRequest request, HttpServletResponse response)
    {
    	SalesmanDao salesman = new SalesmanDao();
    	String sql = "select SalesmanNo from Salesman where OnDuty = 1";
    	List<Salesman> salesmen = salesman.getForList(sql, null);
    	int count = 0;
    	for(Salesman iter : salesmen)
    	{
    		if("on".equals(request.getParameter(iter.getSalesmanNo())))
    		{
    			sql = "update Salesman set OnDuty = 0 where SalesmanNo = ?";
    			String pk = salesman.update(sql, iter.getSalesmanNo());
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
    		if("on".equals(request.getParameter(iter.getWareManNo())))
    		{
    			sql = "update WarehouseManager set OnDuty = 0 where WareManNo = ?";
    			String pk = warehouseManager.update(sql, iter.getWareManNo());
    			if(pk != null)
    				count++;
    		}
    	}
    	request.setAttribute("message", "" + count);
    }
    private void deleteStoreManager(HttpServletRequest request, HttpServletResponse response)
    {
    	StoreManagerDao storeManager = new StoreManagerDao();
    	String sql = "select WareManNo from WarehouseManager where OnDuty = 1";
    	List<StoreManager> storeManagers = storeManager.getForList(sql, null);
    	int count = 0;
    	for(StoreManager iter : storeManagers)
    	{
    		if("on".equals(request.getParameter(iter.getStoreManNo())))
    		{
    			sql = "update StoreManager set OnDuty = 0 where StoreManNo = ?";
    			String pk = storeManager.update(sql, iter.getStoreManNo());
    			if(pk != null)
    				count++;
    		}
    	}
    	request.setAttribute("message", "" + count);
    }
    private void modifySalesman(HttpServletRequest request, HttpServletResponse response)
    {
    	SalesmanDao salesman = new SalesmanDao();
    	String sql = "update salesman set SalesmanName=?, Birthday=to_date(?), telephone=?, storeNo=?, "
				+ "salary=? where SalesmanNo = ?";
    	salesman.update(sql, request.getParameter("name"), request.getParameter("birthday"), 
				request.getParameter("telephone"), request.getParameter("storeNo"), 
				request.getParameter("salary"), request.getParameter("no"));
    }
    private void modifyWarehouseManager(HttpServletRequest request, HttpServletResponse response)
    {
    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
    	String sql = "update WarehouseManager set WareManName=?, Birthday=to_date(?), telephone=?, warehouseNo=?, "
				+ "salary=? where WareManNo = ?";
    	warehouseManager.update(sql, request.getParameter("name"), request.getParameter("birthday"), 
				request.getParameter("telephone"), request.getParameter("warehouseNo"), 
				request.getParameter("salary"), request.getParameter("no"));
    }
    private void modifyStoreManager(HttpServletRequest request, HttpServletResponse response)
    {
    	StoreManagerDao storeManager = new StoreManagerDao();
    	String sql = "update StoreManager set StoreManName=?, Birthday=to_date(?), telephone=?, storeNo=?, "
				+ "salary=? where StoreManNo = ?";
    	storeManager.update(sql, request.getParameter("name"), request.getParameter("birthday"), 
				request.getParameter("telephone"), request.getParameter("storeNo"), 
				request.getParameter("salary"), request.getParameter("no"));
    }
}
