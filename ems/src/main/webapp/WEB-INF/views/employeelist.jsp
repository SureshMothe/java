<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<center><h2>=====Employee List=======</h2></center>
<hr>

<a href="employeepage">Click For Registration</a>
<table border="1">
   <tr>
      <td>EmpId:</td><td>EmpName:</td><td>Age:</td><td>Salary:</td><td>Action</td>
   </tr>
   
   <c:if test="${emp ne null}">
      <c:forEach items="${emp}" var="data">
         <tr>
           <td><c:out value="${data.empno}"/></td>
           <td><c:out value="${data.empname}"/></td>
           <td><c:out value="${data.age}"/></td>
           <td><c:out value="${data.sal}"/></td>
           
           <td><a href="editemployee?empId=${data.empno}">Edit</a>  &nbsp; &nbsp;
               <a href="deleteemployee?empId=${data.empno}">Delete</a>
           </td>
           
         </tr>
      </c:forEach>
   </c:if>      
</table>