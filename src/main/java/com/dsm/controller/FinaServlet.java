package com.dsm.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsm.model.entity.OnSale;
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
		doPost(request, response);
//		request.getRequestDispatcher("/finance/FinaInJsp.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession sess = request.getSession();
		if(sess==null||sess.getAttribute("user_id")==null||!sess.getAttribute("user_id").toString().startsWith("0"))
		{
			request.getRequestDispatcher("ErrorJsp.jsp").forward(request, response);
			return;
		}
		WarehouseDao wh = new WarehouseDao();
		StoreDao s = new StoreDao();
		SalesmanDao sm = new SalesmanDao();
		StoreManagerDao smg = new StoreManagerDao();
		WarehouseManagerDao whm = new WarehouseManagerDao();
		ManagerDao m = new ManagerDao();
		OnSaleDao os = new OnSaleDao();
		String message = null;
		BigDecimal whoutnum = wh.getOutNum();
		BigDecimal soutnum = s.getOutNum();
		BigDecimal smoutnum = sm.getOutNum();
		BigDecimal smgoutnum = smg.getOutNum();
		BigDecimal whmoutnum = whm.getOutNum();
		BigDecimal moutnum = m.getOutNum();
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String time = year+"-"+month;
		String sql = "select * from OnSale natural join sale using(MedicineNo) where SaleTime like"+time+"%";
		List<OnSale> los = os.getForList(sql,null);
		BigDecimal in = new BigDecimal(0);
		for(int i=0;i<los.size();i++)
			in = in.add((los.get(i).getPrice().subtract(los.get(i).getCost())).multiply(los.get(i).getCount()));
		BigDecimal out = whoutnum.add(soutnum).add(smoutnum).add(smgoutnum).add(whmoutnum).add(moutnum);
		BigDecimal allin = in.subtract(out);
		request.setAttribute("year",year);
		request.setAttribute("month",month);
		request.setAttribute("out",out);
		request.setAttribute("in",in);
		request.setAttribute("allin",allin);
		request.getRequestDispatcher("/finance/FinaGetJsp.jsp").forward(request,response);
	}
}
