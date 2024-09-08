<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

     <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Bootstrap/UserAllCss.jsp"%>
<style type="text/css">
.card-sh{
box-shadow:0 0 6px 0 rgba(0,0,0,0.3);
}

</style>
</head>
<body class="bg-light">
<c:if test="${empty loginUser}">
<c:redirect url="../Login.jsp"> </c:redirect>
</c:if>


<%@include file="Bootstrap/UserNavbar.jsp"%>
<div class="container p-5">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card card-sh">
<div class="card-header">
<p class="text-center fs-3">Add Expense page</p>
<c:if test="${not empty msg }">
  <p class="text-center text-succes fs-4">${msg}</p>
  <c:remove var="msg" />
</c:if>
</div>
<div class="card-body">
<form action="../SaveExpenseServlet" method="post">
<div class="mb-3">
<label>Enter Title </label>
<input type="text" name="title" class="form-control">
</div>
<div class="mb-3">
<label>Enter date </label>
<input type="date" name="date" class="form-control">
</div>
<div class="mb-3">
<label>Enter Time </label>
<input type="time" name="time" class="form-control">
</div>
<div class="mb-3">
<label>Enter description </label>
<input type="text" name="description" class="form-control">
</div>
<div class="mb-3">
<label> Enter Price  </label>
<input type="text" name="price" class="form-control">
</div>
<button class="btn btn-success col-md-12">Add </button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>