<%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> --%>
  
<%@ page isELIgnored="false" %> 
     
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-credit-card"></i> R STUDIOS</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp"><i class="fa-solid fa-house"></i> Home</a>
        </li>
       
      </ul>
      
      
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

      <li class="nav-item">
          <a class="nav-link" href="Login.jsp"><i class="fa-solid fa-circle-user"></i>${loginUser.fullname }</a>
        </li>
          <li class="nav-item">
          <a class="nav-link" href="Register.jsp"><i class="fa-solid fa-right-to-bracket"></i>Logout</a>
        </li>
 
    
   
      </ul>
         
    </div>
  </div>
</nav>
