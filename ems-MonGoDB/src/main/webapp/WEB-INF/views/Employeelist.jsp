<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<center><h1 style="color:red">All Employee List</h1></center>
<center><a href="registerpage">Go For Registration</a></center>
<hr>
<center><table border="2">
   <tr>
     <td>EmpId:</td><td>EmpName:</td><td>Age:</td><td>Salary:</td><td>Action:</td>
   </tr>
  
   <c:forEach items="${emp}" var="data">
     <tr>
       <td>${data.id}</td><td>${data.name}</td><td>${data.age}</td><td>${data.salary}</td>
       <td><a href="editData?empId=${data.id}">Edit</a> | <a href="deleteData?empId=${data.id}">Delete</a></td>
     </tr>
   </c:forEach>
</table></center>

<center><a href="home">Back To Home Page</a></center>