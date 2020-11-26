package com.oshop.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oshop.Model.Users;
//import com.oshop.Util.DBUtil;
import com.oshop.Service.UserService;
import com.oshop.Service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String password = request.getParameter("userpass");
		UserService se = new UserServiceImpl();
		if((name!=null) && (password!=null)) {
			Users u = se.findByNameAndPass(name, password);
			if(u != null) {	//u不为空，即在数据库中找到对应的用户
				HttpSession session = request.getSession();
				session.setAttribute("username", name);
				ArrayList<String> list = new ArrayList<String>();
				//list.add("test");
				session.setAttribute("list", list);
				this.getServletContext().getRequestDispatcher("/ProductServlet").forward(request, response);
			}else {
				this.getServletContext().getRequestDispatcher("/LoginError.jsp").forward(request, response);
			}
		}else {
			this.getServletContext().getRequestDispatcher("/LoginError2.jsp").forward(request, response);
		}
		
		
		
		
	}

}
