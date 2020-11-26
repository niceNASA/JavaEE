package com.oshop.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oshop.Model.Goods;
import com.oshop.Service.GoodService;
import com.oshop.Service.GoodServiceImpl;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
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
		//doPost(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GoodService se = new GoodServiceImpl();
		HttpSession session = request.getSession();
		ArrayList<String> list = (ArrayList<String>)session.getAttribute("list"); 
		ArrayList<Goods> payList = new ArrayList<Goods>();
		for(int i=0; i<list.size(); i++) {
			payList.add(se.findByName(list.get(i)));
		}
		session.setAttribute("payList", payList);
		this.getServletContext().getRequestDispatcher("/Pay.jsp").forward(request, response);
	}

}
