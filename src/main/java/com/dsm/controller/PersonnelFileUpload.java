package com.dsm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dsm.model.dao.impl.SalesmanDao;
import com.dsm.model.dao.impl.StoreManagerDao;
import com.dsm.model.dao.impl.WarehouseManagerDao;
import com.dsm.model.entity.Salesman;
import com.dsm.model.entity.StoreManager;
import com.dsm.model.entity.WarehouseManager;
import com.dsm.model.utils.JDBCTools;

import oracle.sql.BLOB;

/**
 * Servlet implementation class PersonnelFileUpload
 */
public class PersonnelFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonnelFileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
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
		String method = null;
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> list = null;
		try
		{
			list = sfu.parseRequest(request);
			for(FileItem fileItem : list)
			{
				if(fileItem.isFormField())
				{
					if("method".equals(fileItem.getFieldName()))
					{
						method = fileItem.getString();
						break;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if("addStoreManager".equals(method))
		{
			addStoreManager(list);
		}
		else if("addWarehouseManager".equals(method))
		{
			addWarehouseManager(list);
		}
		else if("addSalesman".equals(method))
		{
			addSalesman(list);
		}
		else if("modifyStoreManager".endsWith(method))
		{
			modifyStoreManager(list);
		}
		request.getRequestDispatcher("/personnel/personnel.jsp").forward(request,response);
	}
	@SuppressWarnings({ "deprecation" })
	private void addStoreManager(List<FileItem> list)
	{
		Map<String, String> values = new HashMap<String, String>();
		java.sql.Timestamp curTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
		java.sql.Timestamp birthday = null;
    	File icon = null;
    	try
		{
			for(FileItem fileItem : list)
			{
				if(fileItem.isFormField())
				{
					if("addStoreManBirthday".equals(fileItem.getFieldName()))
					{
						birthday = new java.sql.Timestamp(System.currentTimeMillis());
				    	String birthdayString = new String(fileItem.getString("UTF-8"));
				    	birthdayString += " 00:00:00";
				    	try
				    	{
				    		birthday = Timestamp.valueOf(birthdayString);
				    	}
				    	catch(Exception e)
				    	{
				    		e.printStackTrace();
				    	}
					}
					else
					{
						String value = new String(fileItem.getString("UTF-8"));
						values.put(fileItem.getFieldName(), value);
					}
				}
				else
				{
					if("addIcon".equals(fileItem.getFieldName()))
					{
						File f = new File(new String(fileItem.getName()));
						icon = new File(this.getServletContext().getRealPath("attachement"), f.getName());
						icon.getParentFile().mkdirs();
						icon.createNewFile();
						InputStream ins = fileItem.getInputStream();
						OutputStream ous = new FileOutputStream(icon);
						try
						{
							byte[] buffer = new byte[1024];
							int len = 0;
							while((len = ins.read(buffer)) > -1)
								ous.write(buffer, 0, len);
						}
						finally
						{
							ous.close();
							ins.close();
						}
						
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	StoreManagerDao storeManager = new StoreManagerDao();
    	StoreManager newStoreManager = new StoreManager(values.get("addStoreManNo"), values.get("addStoreManName"), 
    			values.get("addStoreManSex"), birthday, values.get("addStoreManTelephone"), 
    			curTimestamp, values.get("addStoreManStoreNo"), new java.math.BigDecimal(values.get("addStoreManSalary")), 
    			values.get("addStoreManPasswd"), values.get("addStoreManManagerNo"), new java.math.BigDecimal(1));
    	storeManager.addObject(newStoreManager);
		FileInputStream fis = null;
		try
		{
			Connection con = JDBCTools.getConnection();
			String sql = "update StoreManager set icon = empty_blob() where StoreManNo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, values.get("addStoreManNo"));
			pstmt.executeUpdate();
			JDBCTools.releaseConnection(con, pstmt, null);
			
			con = JDBCTools.getConnection();
			sql = "select icon from StoreManager where StoreManNo = ? for update";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, values.get("addStoreManNo"));
			ResultSet rs = pstmt.executeQuery();
			BLOB blob = null;
			if(rs.next())
			{
				blob = (BLOB)rs.getBlob(1);
			}
			fis = new FileInputStream(icon);
			byte[] temp = new byte[fis.available()];
			fis.read(temp);
			OutputStream ous = blob.getBinaryOutputStream();
			ous.write(temp);
			fis.close();
			ous.close();
			sql = "update StoreManager set Icon = ? where StoreManNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setBlob(1, blob);
			pstmt.setString(2, values.get("addStoreManNo"));
			pstmt.executeUpdate();
			JDBCTools.releaseConnection(con, pstmt, null);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		icon.delete();
	}
	@SuppressWarnings({ "deprecation", "unused" })
	private void addWarehouseManager(List<FileItem> list)
	{
		Map<String, String> values = new HashMap<String, String>();
		java.sql.Timestamp curTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
		java.sql.Timestamp birthday = null;
    	File icon = null;
    	try
		{
			for(FileItem fileItem : list)
			{
				if(fileItem.isFormField())
				{
					if("addWareManBirthday".equals(fileItem.getFieldName()))
					{
						birthday = new java.sql.Timestamp(System.currentTimeMillis());
				    	String birthdayString = new String(fileItem.getString("UTF-8"));
				    	birthdayString += " 00:00:00";
				    	try
				    	{
				    		birthday = Timestamp.valueOf(birthdayString);
				    	}
				    	catch(Exception e)
				    	{
				    		e.printStackTrace();
				    	}
					}
					else
					{
						String value = new String(fileItem.getString("UTF-8"));
						values.put(fileItem.getFieldName(), value);
					}
				}
				else
				{
					if("addIcon".equals(fileItem.getFieldName()))
					{
						File f = new File(new String(fileItem.getName()));
						icon = new File(this.getServletContext().getRealPath("attachement"), f.getName());
						icon.getParentFile().mkdirs();
						icon.createNewFile();
						InputStream ins = fileItem.getInputStream();
						OutputStream ous = new FileOutputStream(icon);
						try
						{
							byte[] buffer = new byte[1024];
							int len = 0;
							while((len = ins.read(buffer)) > -1)
								ous.write(buffer, 0, len);
						}
						finally
						{
							ous.close();
							ins.close();
						}
						
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	WarehouseManagerDao warehouseManager = new WarehouseManagerDao();
    	WarehouseManager newWarehouseManager = new WarehouseManager(values.get("addWareManNo"), values.get("addWareManName"), 
    			values.get("addWareManSex"), birthday, values.get("addWareManTelephone"), 
    			curTimestamp, values.get("addWareManWarehouseNo"), new java.math.BigDecimal(values.get("addWareManSalary")), 
    			values.get("addWareManPasswd"), values.get("addWareManManagerNo"), new java.math.BigDecimal(1));
    	warehouseManager.addObject(newWarehouseManager);
		FileInputStream fis = null;
		try
		{
			Connection con = JDBCTools.getConnection();
			String sql = "update WarehouseManager set icon = empty_blob() where WareManNo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, values.get("addWareManNo"));
			pstmt.executeUpdate();
			JDBCTools.releaseConnection(con, pstmt, null);
			
			con = JDBCTools.getConnection();
			sql = "select icon from WarehouseManager where WareManNo = ? for update";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, values.get("addWareManNo"));
			ResultSet rs = pstmt.executeQuery();
			BLOB blob = null;
			if(rs.next())
			{
				blob = (BLOB)rs.getBlob(1);
			}
			fis = new FileInputStream(icon);
			byte[] temp = new byte[fis.available()];
			fis.read(temp);
			OutputStream ous = blob.getBinaryOutputStream();
			ous.write(temp);
			fis.close();
			ous.close();
			sql = "update WarehouseManager set Icon = ? where WareManNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setBlob(1, blob);
			pstmt.setString(2, values.get("addWareManNo"));
			pstmt.executeUpdate();
			JDBCTools.releaseConnection(con, pstmt, null);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		icon.delete();
	}
	@SuppressWarnings({ "deprecation", "unused" })
	private void addSalesman(List<FileItem> list)
	{
		Map<String, String> values = new HashMap<String, String>();
		java.sql.Timestamp curTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
		java.sql.Timestamp birthday = null;
    	File icon = null;
    	try
		{
			for(FileItem fileItem : list)
			{
				if(fileItem.isFormField())
				{
					if("addSalesmanBirthday".equals(fileItem.getFieldName()))
					{
						birthday = new java.sql.Timestamp(System.currentTimeMillis());
				    	String birthdayString = new String(fileItem.getString("UTF-8"));
				    	birthdayString += " 00:00:00";
				    	try
				    	{
				    		birthday = Timestamp.valueOf(birthdayString);
				    	}
				    	catch(Exception e)
				    	{
				    		e.printStackTrace();
				    	}
					}
					else
					{
						String value = new String(fileItem.getString("UTF-8"));
						values.put(fileItem.getFieldName(), value);
					}
				}
				else
				{
					if("addIcon".equals(fileItem.getFieldName()))
					{
						File f = new File(new String(fileItem.getName()));
						icon = new File(this.getServletContext().getRealPath("attachement"), f.getName());
						icon.getParentFile().mkdirs();
						icon.createNewFile();
						InputStream ins = fileItem.getInputStream();
						OutputStream ous = new FileOutputStream(icon);
						try
						{
							byte[] buffer = new byte[1024];
							int len = 0;
							while((len = ins.read(buffer)) > -1)
								ous.write(buffer, 0, len);
						}
						finally
						{
							ous.close();
							ins.close();
						}
						
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	SalesmanDao salesman = new SalesmanDao();
    	Salesman newSalesman = new Salesman(values.get("addSalesmanNo"), values.get("addSalesmanName"), 
    			values.get("addSalesmanSex"), birthday, values.get("addSalesmanTelephone"), 
    			curTimestamp, values.get("addSalesmanStoreNo"), new java.math.BigDecimal(values.get("addSalesmanSalary")), 
    			values.get("addSalesmanPasswd"), new java.math.BigDecimal(1));
    	salesman.addObject(newSalesman);
		FileInputStream fis = null;
		try
		{
			Connection con = JDBCTools.getConnection();
			String sql = "update Salesman set icon = empty_blob() where SalesmanNo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, values.get("addSalesmanNo"));
			pstmt.executeUpdate();
			JDBCTools.releaseConnection(con, pstmt, null);
			
			con = JDBCTools.getConnection();
			sql = "select icon from Salesman where SalesmanNo = ? for update";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, values.get("addSalesmanNo"));
			ResultSet rs = pstmt.executeQuery();
			BLOB blob = null;
			if(rs.next())
			{
				blob = (BLOB)rs.getBlob(1);
			}
			fis = new FileInputStream(icon);
			byte[] temp = new byte[fis.available()];
			fis.read(temp);
			OutputStream ous = blob.getBinaryOutputStream();
			ous.write(temp);
			fis.close();
			ous.close();
			sql = "update Salesman set Icon = ? where SalesmanNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setBlob(1, blob);
			pstmt.setString(2, values.get("addSalesmanNo"));
			pstmt.executeUpdate();
			JDBCTools.releaseConnection(con, pstmt, null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		icon.delete();
	}
	private void modifyStoreManager(List<FileItem> list)
	{
		Map<String, String> values = new HashMap<String, String>();
		java.sql.Timestamp birthday = null;
    	File icon = null;
    	boolean hasIcon = false;
    	try
		{
			for(FileItem fileItem : list)
			{
				if(fileItem.isFormField())
				{
					if("modifyStoreManBirthday".equals(fileItem.getFieldName()))
					{
						birthday = new java.sql.Timestamp(System.currentTimeMillis());
				    	String birthdayString = new String(fileItem.getString("UTF-8"));
				    	birthdayString += " 00:00:00";
				    	try
				    	{
				    		birthday = Timestamp.valueOf(birthdayString);
				    	}
				    	catch(Exception e)
				    	{
				    		e.printStackTrace();
				    	}
					}
					else
					{
						String value = new String(fileItem.getString("UTF-8"));
						values.put(fileItem.getFieldName(), value);
					}
				}
				else
				{
					if("modifyStoreManIcon".equals(fileItem.getFieldName()))
					{
						File f = new File(new String(fileItem.getName()));
						if(f.exists())
						{
							hasIcon = true;
							icon = new File(this.getServletContext().getRealPath("attachement"), f.getName());
							icon.getParentFile().mkdirs();
							icon.createNewFile();
							InputStream ins = fileItem.getInputStream();
							OutputStream ous = new FileOutputStream(icon);
							try
							{
								byte[] buffer = new byte[1024];
								int len = 0;
								while((len = ins.read(buffer)) > -1)
									ous.write(buffer, 0, len);
							}
							finally
							{
								ous.close();
								ins.close();
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	String sql = "update StoreManager set StoreManName=?, birthday=?, telephone=?, StoreNo=?, salary=? where StoreManNo = ?";
    	StoreManagerDao storeManager = new StoreManagerDao();
    	storeManager.update(sql, values.get("modifyStoreManName"), birthday, values.get("modifyStoreManTelephone"), 
    			values.get("modifyStoreManStoreNo"), values.get("modifyStoreManSalary"), values.get("modifyStoreManNo"));
		if(hasIcon)
		{
			FileInputStream fis = null;
			try
			{
				Connection con = JDBCTools.getConnection();
				sql = "update StoreManager set icon = empty_blob() where StoreManNo = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, values.get("modifyStoreManNo"));
				pstmt.executeUpdate();
				JDBCTools.releaseConnection(con, pstmt, null);
				
				con = JDBCTools.getConnection();
				sql = "select icon from StoreManager where StoreManNo = ? for update";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, values.get("modifyStoreManNo"));
				ResultSet rs = pstmt.executeQuery();
				BLOB blob = null;
				if(rs.next())
				{
					blob = (BLOB)rs.getBlob(1);
				}
				fis = new FileInputStream(icon);
				byte[] temp = new byte[fis.available()];
				fis.read(temp);
				OutputStream ous = blob.getBinaryOutputStream();
				ous.write(temp);
				fis.close();
				ous.close();
				sql = "update StoreManager set Icon = ? where StoreManNo = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setBlob(1, blob);
				pstmt.setString(2, values.get("modifyStoreManNo"));
				pstmt.executeUpdate();
				JDBCTools.releaseConnection(con, pstmt, null);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			icon.delete();
		}
	}
}
