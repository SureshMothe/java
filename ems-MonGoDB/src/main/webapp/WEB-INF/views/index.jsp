
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<center><h1 style="color:red">Welcome to Mongo Database Test</h1></center>
<center>
   <c:if test="${emp ne null}">
      <c:out value="${emp}"></c:out>
   </c:if>
</center>
<hr>

<center><a href="registerpage">Go To Register Page</a></center>
<center><a href="Employeelist">Get Employee List Details</a></center>