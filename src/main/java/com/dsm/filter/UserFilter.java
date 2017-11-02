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
	private FilterConfig config;  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession sess = req.getSession();
		String noLoginPaths = config.getInitParameter("noLoginPaths");  
		String path = req.getServletPath();	
		String charset = config.getInitParameter("charset");  
        if(charset==null){  
            charset = "UTF-8";  
        }  
        request.setCharacterEncoding(charset);  
        if(noLoginPaths!=null)
        {  
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++)
            {  
                if(strArray[i]==null || "".equals(strArray[i]))
                	continue;  
                if(req.getRequestURI().indexOf(strArray[i])!=-1){  
                    chain.doFilter(request, response);  
                    return;  
                }  
            }  
        }  
		if(sess==null||sess.getAttribute("user_id")==null)
		{
			req.getRequestDispatcher("error.jsp").forward(req, res);
			return;
		}
		else
		{
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig arg0) throws ServletException
	{  
        config = arg0;  
    }
	public void destroy() {}  
}
