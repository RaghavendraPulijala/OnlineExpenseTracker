package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;

/**
 * Servlet implementation class DeleteExpenseServlet
 */
public class DeleteExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int i = Integer.parseInt(request.getParameter("id"));
		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f=dao.deleteExpense(i);
		
		
		HttpSession session = request.getSession();
		if(f)
		{
			session.setAttribute("msg", "Deleted Successfully");
			response.sendRedirect("User/ViewExpense.jsp");
		}
		else
		{
			session.setAttribute("msg", "not  Successfully");
			response.sendRedirect("User/ViewExpense.jsp");
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
