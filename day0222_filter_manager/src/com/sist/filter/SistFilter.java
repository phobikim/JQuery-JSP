package com.sist.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SistFilter
 */

public class SistFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SistFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 동작하였습니다");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("filter가 동작하였습니다");
		// pass the request along the filter chain
		// chain.doFilter(request, response);
		
		// 관리자로그인 관리하기 
		// Servlet과 HttpServlet이 is a 관계이기 때문에 casting하여서 사용한다
		HttpSession session = ((HttpServletRequest)request).getSession();
		// session에 setAttribute한 이름을 가져와서 검사한다
		// Object를 반환하기 때문에, String으로 casting하여 사용
		String manager = (String)session.getAttribute("manager");
		
		if(manager!=null && manager.equals("yes")) {
			// session이 유지되면서, 관리자로그인에 성공한다면
			chain.doFilter(request, response);
		}else {
			// 다시 로그인 페이지로 보낸다
			((HttpServletResponse)response).sendRedirect("http://localhost:9090/day0222_filter_manager/login.jsp");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init이 동작하였습니다");
	}

}
