package com.oshop.Servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class shopFilter
 */
@WebFilter(filterName="shopFilter", urlPatterns="/*", initParams= {@WebInitParam(name="encoding",value="utf-8")})
public class shopFilter implements Filter {
	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public shopFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//String encoding = config.getInitParameter("encoding");
		//request.setCharacterEncoding(encoding);
		HttpServletRequest requ = (HttpServletRequest)request;
		HttpSession session = requ.getSession(true);
		String requestPath = requ.getServletPath();
		System.out.println(requestPath);
		System.out.println(session.getAttribute("username"));
		if(session.getAttribute("username")==null && !requestPath.endsWith("index.jsp") && !requestPath.endsWith("LoginServlet") && !requestPath.endsWith("LoginError.jsp") && !requestPath.endsWith("LoginError2.jsp") && !requestPath.endsWith("Register.jsp") && !requestPath.endsWith("RegisterServlet")) {
			((HttpServletResponse)response).sendRedirect("index.jsp");
			//return; 报错？
			//System.out.println(session.getAttribute("user"));
		}else {
			chain.doFilter(request, response);
		}
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = null;
	}

}
