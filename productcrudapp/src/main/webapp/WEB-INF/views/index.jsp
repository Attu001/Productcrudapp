<html>

<head>
<%@include file="./base.jsp" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<div class="container mt-3">

	<div class="row">
		
		<div class="col-md-12">
		
		<h1 class="text-center mb-3">Welcome To Product App</h1>
		
			<table class="table table-dark table-striped">
  <thead>
   
  
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Description</th>
      <th scope="col">Price</th>
            <th scope="col">Action</th>
      
    </tr> 
  </thead>
  <tbody>
   <c:forEach items="${product}" var="p">
    <tr>    
      <th scope="row">product-No.${p.pid}</th>
      <td>${p.name}</td>
      <td>${p.description}</td>
      <td>&#8377 ${p.price}</td>
            <td>
            <a href="delete/${p.pid}" style="font-size:25px"><i class="fa-solid fa-trash text-danger"></i></a>
            <a href="update/${p.pid}" style="font-size:25px"><i class="fa-solid fa-edit text-primry"></i></a>
            
            </td>
            
      
    </tr>
   </c:forEach>

  </tbody>
</table>

<div class="container text-center">

	<a href="add-product" class="btn btn-outline-success">Add-Product</a>

</div>
		
		</div>
	
	</div>

</div>


</body>
</html>
