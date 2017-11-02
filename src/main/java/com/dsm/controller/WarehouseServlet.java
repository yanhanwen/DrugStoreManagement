package com.dsm.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.math.BigDecimal;
//import java.security.Timestamp;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.entity.Stock;
//import com.dsm.model.entity.Manager;
//import com.dsm.model.entity.Salesman;
//import com.dsm.model.entity.StoreManager;
import com.dsm.model.entity.User;
//import com.dsm.model.entity.WarehouseManager;
import com.dsm.model.entity.*;
import com.dsm.model.dao.impl.*;

public class WarehouseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String WareManNo=null; 
	private String EnterNo="0000000000";
	private String LeaveNo="1000000000";
	//private String EnvirNo="00000";
	private String No="000";
 	public WarehouseServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		WareManNo = (String)session.getAttribute("ID");
		if(user == null || !WareManNo.startsWith("1"))
		{
			response.sendRedirect("/WEB-INF/ErrorJsp.jsp");
		//	return;
		}
		String method = request.getParameter("method");
		if(method.equals("addMedicine")) {
			addMedicine(request,response);
			//request.getRequestDispatcher("/warehouse/addMedicine.jsp").forward(request,response);
		}else if(method.equals("deleteMedicine")) {
			deleteMedicine(request,response);
		}else if(method.equals("queryMedicine")) {
			queryMedicine(request,response);
		}
		request.getRequestDispatcher("/warehouse").forward(request,response);
		
	}
	//将从jsp页面得到的string型转为data型
	public java.sql.Date stringToDate(String str){		
		java.util.Date Date=null; 
		try {
			System.out.println(str);
			Date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		java.sql.Date date=new java.sql.Date(Date.getTime());
		return date;
	}
	//将从jsp页面得到的string型转为int型
	public int stringToInt(String str) {
		return Integer.valueOf(str).intValue();
	}
	//将从jsp页面得到的string型转为时间戳型
	public Timestamp currentTime() {
		Timestamp Time=new Timestamp(System.currentTimeMillis());
		return Time;
	}
	//将从jsp页面得到的string型转为BigDecimal型
	public BigDecimal stringToBigDecimal(String str) {
		BigDecimal bigDecimal=new BigDecimal(str);
		//设置小位位数，第一个变量是小位位数，第二个变量是取舍方法（四舍五入）
		//bigDecimal=bigDeciaml.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bigDecimal;
	}
	//对EnterNo的编号进行累加，即每有一次入库，入库的编号加一
	/*public String getEnterNo() {
		String sql="select MAX(EnterNo) from EnterWare";
		EnterWareDao enterWare=new EnterWareDao();
		EnterNo=(String)enterWare.getSingleValue(sql, null);
		//如果入库的表中有数据，则取出最大值并进行加一操作
		//如果表中无数据，则把0000000000作为第一个入库编号
		if(EnterNo!="") {
			int enterNo=stringToInt(EnterNo);
			enterNo++;
			EnterNo=String.valueOf(enterNo);
		}			
		return EnterNo;
	}
	public String getEnvirNo() {
		String sql="select MAX(EnvirNo) from WarehouseEnvir";
		WarehouseEnvirDao envirNo=new WarehouseEnvirDao();
		EnvirNo=(String)envirNo.getSingleValue(sql, null);
		//如果入库的表中有数据，则取出最大值并进行加一操作
		//如果表中无数据，则把00000作为第一个仓库条件编号
		if(EnvirNo!="") {
			int envirNo2=stringToInt(EnterNo);
			envirNo2++;
			EnvirNo=String.valueOf(envirNo2);
		}			
		return EnvirNo;
	}
	
	public String getLeaveNo() {
		String sql="select MAX(LeaveNo) from LeaveWare";
		LeaveWareDao leaveWare=new LeaveWareDao();
		LeaveNo=(String)leaveWare.getSingleValue(sql, null);
		if(LeaveNo!="") {
			int leaveNo=stringToInt(LeaveNo);
			leaveNo++;
			LeaveNo=String.valueOf(leaveNo);
		}
		return LeaveNo;
	}*/
	public String getNo(String No,String table) {
		String sql="select MAX("+No+") from"+ table;
		EnterWareDao base=new EnterWareDao();
		No=(String)base.getSingleValue(sql, null);
		//如果入库的表中有数据，则取出最大值并进行加一操作
		//如果表中无数据，则把默认值作为第一个入库编号
		if(No!="") {
			int no=stringToInt(No);
			no++;
			No=String.valueOf(no);
		}			
		return No;
	}
	public String getSheleNo(String No,String table) {
		String sql="select MAX("+No+") from"+ table;
		EnterWareDao base=new EnterWareDao();
		No=(String)base.getSingleValue(sql, null);
		//如果入库的表中有数据，则取出最大值并进行加一操作
		//如果表中无数据，则把默认值作为第一个入库编号
		if(No!="") {
			//提取出No中的数字来
			String regEx="[^0-9]";  
			Pattern p = Pattern.compile(regEx);  
			Matcher m = p.matcher(No);  
			int no=stringToInt(m.replaceAll("").trim());
			no++;
			No=String.valueOf(no);
		}			
		return No;
	}
	
	//药品入库
	//大约、好像、应该得先看看药品信息表里有没有该药品（咋看？根据药品名称还是药品编号）
	//药品名称的话会不会重复，药品编号的话，你咋知道刚来的药品编号是多少，难道是国家统一编制
	//如果是的话，那我就没啥意见了，也不应该是自己编号，那样是真二，就默认药品编号如同二维码，不存在重复的
	private void addMedicine(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/warehouse/addMedicine.jsp").forward(request,response);
		String MedicineNo=request.getParameter("MedicineNo");
		MedicineDao medicine=new MedicineDao();
		String sql="select MedicineNo,MedicineName,Category,factory,Indication,StorageCond,LifeTime"
				+"from Medicine where MedicineNo ="+MedicineNo;
		List<Medicine> medicines=medicine.getForList(sql, null);
		//如果存放药信息的表中无该数据，则向该表中加入该药的一行信息
		java.sql.Date LifeTime=stringToDate(request.getParameter("LifeTime"));
		if(medicines.isEmpty()) {
			MedicineDao Medicine=new MedicineDao();
			//将从jsp页面中得到的string型转为date型
			
			//if(LifeTime==null) {
				
			//}
			Medicine newMedicine=new Medicine(request.getParameter("MedicineNo"),request.getParameter("MedicineName"),request.getParameter("Category"),
						request.getParameter("Factory"),request.getParameter("Indication"),request.getParameter("StorageCond"),
						LifeTime);
			Medicine.addObject(newMedicine);
		}
		
		//药品入库，
		EnterWareDao enterWare=new EnterWareDao();
		int EnterCount=stringToInt(request.getParameter("EnterCount"));
		Timestamp EnterTime=currentTime();
		//将从jsp页面得到的string型转为data型
		java.sql.Date ProductDate=stringToDate(request.getParameter("ProductDate"));
		//将从jsp页面得到的string型转为BigDecimal型
		BigDecimal Cost=stringToBigDecimal(request.getParameter("Cost"));
		EnterNo=getNo(EnterNo,"EnterWare");
		EnterWare newEnterWare=new EnterWare(EnterNo,MedicineNo,request.getParameter("WarehouseNo"),
				request.getParameter("SupplierNo"),EnterCount,EnterTime,ProductDate,Cost,WareManNo);		
		enterWare.addObject(newEnterWare);
		
		//仓库环境，没啥卵用，也不是。好像可以得出库存里的货架号
		//仓库条件咋编号，在这里只是查看没有修改或添加啊
		WarehouseEnvirDao warehouseEnvir=new WarehouseEnvirDao();
		String sql2="Select Area from WarehouseEnvir where WareHouseNo="
				+request.getParameter("WarehouseNo")+"and "+request.getParameter("StorageCond")
				+"like %Condition%";
		String area=(String)warehouseEnvir.getSingleValue(sql2, null);
		//药品进入库存的表
		//因为库存里的表以入库编号为主键，所以即便是相同的药如果不是一批进库的，那么编号就不一样
		//这也就意味着一种药在库存里有多行信息，每一行的入库编号不同、生产日期可能相同，也可能不同
		StockDao stock=new StockDao();
		String StockNo=EnterNo;
		No=getSheleNo(No,"Stock");
		String SheleNo=area+No;
		//这里的有效期应该是生产日期加上保质期吧，未完成！！！！！！
		java.sql.Date ValidPeriod=LifeTime;
		Stock newStock=new Stock(StockNo,MedicineNo,request.getParameter("WarehouseNo"),
				SheleNo,EnterCount,Cost,ProductDate,ValidPeriod);
		stock.addObject(newStock);
		//request.getRequestDispatcher("/warehouse/addMedicine.jsp").forward(request,response);
		
				
	}
	private void deleteMedicine(HttpServletRequest request,HttpServletResponse response) {
		//药品出库，对库存表进行操作
		//先看看库存中指定仓库号、药品号的药品数量能不能满足需求
		String MedicineNo=request.getParameter("MedicineNo");
		String WareHouseNo=request.getParameter("WareHouseNo");
		//药品出库时的的进价，默认为最新日期的进价
		BigDecimal Cost=null;
		int Count=stringToInt(request.getParameter("Count"));
		String sql="select SUM(Count) from Stock where Medicine="+MedicineNo+"and WareHouseNo="+"WareHouseNo";
		StockDao stock=new StockDao();
		//库存中该仓库该药的数量
		int count=(Integer)stock.getSingleValue(sql, null);
		//若不能满足需求
		if(count<Count) {
			//一些提醒或者跳转啥的
		}else {		//若能够满足需求
			String Sql="select StockNo,MedicineNo,WareHouseNo,ShelfNo,Count,Cost,ProductDate,ValidPeriod "+
					"from Stock where Medicine="+MedicineNo+"and WareHouseNo="+"WareHouseNo order by ProductDate";
			List<Stock> stockList=stock.getForList(Sql, null);
			for(int i=0;i<stockList.size();i++) {
				if(Count>=stockList.get(i).getCount()) {
					Count=Count-stockList.get(i).getCount();
					String StockNo=stockList.get(i).getStockno();
					//String sql2="delete from Stock where StockNo="+StockNo;
					stock.deleteObjectByKey(StockNo);
				}else {
					int Count2=stockList.get(i).getCount()-Count;
					Cost=stockList.get(i).getCost();
					String sql2="update Stock set Count="+Count2+"where StockNo="+stockList.get(i).getStockno();
					stock.update(sql2, null);
					break;
				}
			}
		}
		
		//药品出库，类似于药品进库
		LeaveWareDao leaveWare=new LeaveWareDao();
	//	BigDecimal Cost=stringToBigDecimal(request.getParameter("Cost"));
		int LeaveCount=Count;
		Timestamp LeaveTime=currentTime();
		LeaveNo=getNo(LeaveNo,"LeaveWare");
		LeaveWare newLeaveWare=new LeaveWare(LeaveNo,request.getParameter("MedicineNo"),request.getParameter("WarehouseNo"),
					request.getParameter("StoreNo"),Cost,LeaveCount,LeaveTime,WareManNo);
		leaveWare.addObject(newLeaveWare);
		
		
		
		
	}
	private void queryMedicine(HttpServletRequest request,HttpServletResponse response) {
		//库存查询，是按什么查询，药品名称、药品类别、适应症、保质期。。。。
		//假如这里按药品名称查询，显示的是库存表里对应的某一行或者不存在
		//那在这里就需要一个变量，来表示需要查询的药品名称
		//试着写写
		String MedicineName =request.getParameter("MedicineName");
		StockDao stock=new StockDao();
		String sql="select StockNo,MedicineNo,WarehouseNo,ShelfNo,Count,Cost,ProductDate,ValidPeriod "+
				"from Medicine left join Store where MedicineName = "+MedicineName;
		List<Stock> medicineStock=stock.getForList(sql, null);
		request.setAttribute("medicineStock", medicineStock);
		//上面这小部分好像是完成了根据药品名称查询库存表里某一行，
		//但是如果不存在那一行应该怎样操作？
		//还有这里面需不需要写药品信息查询？
		//如果写的话，是另外写还是在先前的那个sql语句中加上药品信息表里的几列
		
	}
}
