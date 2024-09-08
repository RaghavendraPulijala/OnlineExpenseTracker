<%@page import="com.entity.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="com.db.HibernateUtil"%>
<%@page import="com.dao.ExpenseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Bootstrap/UserAllCss.jsp"%>
</head>
<body>
<%@include file="Bootstrap/UserNavbar.jsp"%>
<c:if test="${not empty msg }">
  <p class="text-center text-succes fs-4">${msg}</p>
  <c:remove var="msg" />
</c:if>
<div class="container">
<div class="row">
<div class="col-md-8 offset-md-2">
<div class="card">
<div class="card-header text-center">
<p class="fs-3"> All Expenses </p>
</div>
<div class="card-body">
<table class="table">
  <thead>
    <tr>
      <th scope="col">Title</th>
      <th scope="col">Description</th>
      <th scope="col">Date</th>
      <th scope="col">Time</th>
       <th scope="col">Price</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  
  <%
  User user =(User)session.getAttribute("loginUser");
  ExpenseDao ex=new ExpenseDao(HibernateUtil.getSessionFactory());
 List<Expense> list= ex.getAllExpenseByUser(user);
 for(Expense exp:list)
 {
	 %>
	 <tr>
     <th scope="row"><%=exp.getTitle()%></th>
     <td><%=exp.getDecription()%></td>
     <td><%=exp.getDate() %></td>
     <td><%=exp.getTime() %></td>
     <td><%=exp.getPrice() %></td>
     <td>
     
     <a href="EditExpense.jsp?id=<%=exp.getId() %>" class="btn btn-sm btn-primary me-1">Edit </a>
     <a href="../DeleteExpenseServlet?id=<%=exp.getId() %>" class="btn btn-sm btn-danger me-1">Delete </a>
     
     </td>
    
   </tr>
	 <% 
 }
  
  %>
    
    
    
  </tbody>
</table>








</div>


</div>  



</div>


</div>


</div>






</body>
</html>