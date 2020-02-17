<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${msg ne null}">
   <c:out value="${msg}"/>  
</c:if>

<h1 style="color:red">Welcome To java Spring boot World</h1>
<hr/>
<center><a href="employeepage">Add Employee</a></center>
<center><a href="employeelist">List Employee</a></center>
