package com.dsm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class UserFilter implements Filter
{
    public UserFilter() {}
	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession sess = req.getSession();
		ServletContext application=sess.getServletContext();
		if(sess.getAttribute("user_id")==null)
		{
			res.sendRedirect("/WEB-INF/ErrorJsp.jsp");
			return;
		}
		else
		{
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException 
	{}
}
