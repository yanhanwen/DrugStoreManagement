package com.dsm.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dsm.model.dao.impl.OnSaleDao;
import com.dsm.model.dao.impl.SaleDao;
import com.dsm.model.entity.OnSale;
import com.dsm.model.entity.Sale;

public class OnSaleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		OnSaleDao onSaleDao = new OnSaleDao();
		SaleDao saleDao = new SaleDao();
		DateFormat sdf = new SimpleDateFormat("yyMMddHHmmss"); 
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		String choose = request.getParameter("choose");
		if (choose.equals("addMedicine")) {
			String onSaleNo = request.getParameter("onSaleNo");
			String medicineNo = request.getParameter("medicineNo");
			BigDecimal saleNum = new BigDecimal(request.getParameter("saleNum"));
			String storeNo = request.getParameter("storeNo");
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			BigDecimal cost = new BigDecimal(request.getParameter("cost"));
			Timestamp validPeriod = Timestamp.valueOf(request.getParameter("validPeriod"));
			BigDecimal frameNo = new BigDecimal(request.getParameter("frameNo"));
			String hasMedicine = "select * from onsale where medicineno=?";
			OnSale os = onSaleDao.getSingleObject(hasMedicine, medicineNo);
			try {
				if (os != null) {
					String updateCount = "update onsale set count=count+?,price=?,cost=?,frameno=?,validPeriod=?,onsaleno=? where medicineno = ?";
					String message = onSaleDao.update(updateCount, saleNum, price, cost, frameNo, validPeriod, onSaleNo,
							medicineNo);
					session.setAttribute("message", "提交成功");
				} else {
					OnSale onSale = new OnSale(medicineNo, storeNo, saleNum, price, cost, validPeriod, frameNo);
					onSale.setOnsaleno(onSaleNo);
					onSaleDao.addObject(onSale);
					session.setAttribute("message", "提交成功");
				}
			} catch (Exception e) {
				System.out.println(12321);
				session.setAttribute("message", "提交失败");
			}
		}
		
		if(choose.equals("sellMedicineForm")) {
			String onSaleNo = request.getParameter("onSaleNo");
			BigDecimal saleNum = new BigDecimal(request.getParameter("saleNum"));
			String getSql = "select * from onsale where onsaleno=?";
			OnSale onSale = onSaleDao.getSingleObject(getSql, onSaleNo);
			if(onSale.getCount().equals(saleNum)) {
				onSaleDao.deleteObjectByKey(onSaleNo);
			}else {
			onSaleDao.reduceOnSaleNum(onSaleNo,saleNum);
			}
			Sale sale = new Sale();
			sale.setSerialno("311"+sdf.format(ts));
			sale.setMedicineno(onSale.getMedicineno());
			sale.setSalesmanno("311");
			sale.setSaletime(new Timestamp(System.currentTimeMillis()));
			sale.setTotal(onSale.getPrice().multiply(saleNum));
			sale.setCount(saleNum);
			saleDao.addObject(sale);
		}	
		response.sendRedirect("onsale/OnSale.jsp");
	}
}
