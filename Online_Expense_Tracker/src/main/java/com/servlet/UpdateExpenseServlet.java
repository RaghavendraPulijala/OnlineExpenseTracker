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
@SuppressWarnings("unused")
public class UpdateExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExpenseServlet() {
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
		
	int id=Integer.parseInt(request.getParameter("id"));	
    String title =request.getParameter("title"); 
    String date = request.getParameter("date");
    String time = request.getParameter("time");
    String Description=request.getParameter("description");
    String price = request.getParameter("price");
	
	HttpSession session = request.getSession();
	User user=(User) session.getAttribute("loginUser");
	Expense ex = new Expense(title, date, time, Description, price, user);
	ex.setId(id);
	ExpenseDao expenseDao = new ExpenseDao(HibernateUtil.getSessionFactory());
	
	boolean f=expenseDao.UpdateExpense(ex);
	
	if(f)
	{
		session.setAttribute("msg","Expense Saved Succesfully");
		response.sendRedirect("User/ViewExpense.jsp");
	}
	else
	{
		session.setAttribute("msg","Expense Not Saved Succesfully");
		response.sendRedirect("User/ViewExpense.jsp");
	}
	
	
	
	
	
	
	}

}

