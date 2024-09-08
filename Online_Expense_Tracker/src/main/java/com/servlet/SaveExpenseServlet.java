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
import com.entity.Expense;
import com.entity.User;

/**
 * Servlet implementation class SaveExpenseServlet
 */
public class SaveExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
    String title =request.getParameter("title"); 
    String date = request.getParameter("date");
    String time = request.getParameter("time");
    String Description=request.getParameter("description");
    String price = request.getParameter("price");
	
	HttpSession session = request.getSession();
	User user=(User) session.getAttribute("loginUser");
	Expense ex = new Expense(title, date, time, Description, price, user);
	
	ExpenseDao expenseDao = new ExpenseDao(HibernateUtil.getSessionFactory());
	
	boolean f=expenseDao.saveExpense(ex);
	
	if(f)
	{
		session.setAttribute("msg","Expense Saved Succesfully");
		response.sendRedirect("User/AddExpense.jsp");
	}
	else
	{
		session.setAttribute("msg","Expense Not Saved Succesfully");
		response.sendRedirect("User/AddExpense.jsp");
	}
	
	
	
	
	
	
	}

}
