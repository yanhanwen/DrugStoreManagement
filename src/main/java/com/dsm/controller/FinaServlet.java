package com.dsm.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.entity.OnSale;
import com.dsm.model.entity.User;
import com.dsm.model.dao.impl.ManagerDao;
import com.dsm.model.dao.impl.OnSaleDao;
import com.dsm.model.dao.impl.SalesmanDao;
import com.dsm.model.dao.impl.StoreDao;
import com.dsm.model.dao.impl.StoreManagerDao;
import com.dsm.model.dao.impl.WarehouseDao;
import com.dsm.model.dao.impl.WarehouseManagerDao;

public class FinaServlet extends HttpServlet
{
	public FinaServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		doPost(request, response);
		request.getRequestDispatcher("/WEB-INF/finance/FinaInJsp.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("111");
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
		StoreDao s = new StoreDao();
		SalesmanDao sm = new SalesmanDao();
		StoreManagerDao smg = new StoreManagerDao();
		WarehouseManagerDao whm = new WarehouseManagerDao();
		ManagerDao m = new ManagerDao();
		OnSaleDao os = new OnSaleDao();
		String time = null;
		String message = null;
		BigDecimal whoutnum = wh.getOutNum();
		BigDecimal soutnum = s.getOutNum();
		BigDecimal smoutnum = sm.getOutNum();
		BigDecimal smgoutnum = smg.getOutNum();
		BigDecimal whmoutnum = whm.getOutNum();
		BigDecimal moutnum = m.getOutNum();
		time = request.getParameter("time");
		Date adate = null;
		try {
		    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
		    format.setLenient(false);  
		    adate=format.parse(time);
		} catch (Exception ex){
			message = "日期不合法";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/WEB-INF/finance/FinaInJsp.jsp");
			return;
		}
		String sql = "select * from OnSale natural join sale using(MedicineNo) where SaleTime like"+adate.toString()+"%";
		List<OnSale> los = os.getForList(sql,null);
		BigDecimal in = new BigDecimal(0);
		for(int i=0;i<los.size();i++)
			in = in.add((los.get(i).getPrice().subtract(los.get(i).getCost())).multiply(new BigDecimal(los.get(i).getCount())));
		BigDecimal out = whoutnum.add(soutnum).add(smoutnum).add(smgoutnum).add(whmoutnum).add(moutnum);
		BigDecimal allin = in.subtract(out);
		request.setAttribute("time",time);
		request.setAttribute("out",out);
		request.setAttribute("in",in);
		request.setAttribute("allin",allin);
		request.getRequestDispatcher("/WEB-INF/finance/FinaGetJsp.jsp").forward(request,response);
	}
}
