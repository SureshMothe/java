<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<center><h1>Update Data Here</h1><center>
<hr>
<form:form action="updatedata" method="POST" modelAttribute="emp">
    <table>
       <tr>
         <td>Empid:</td> <td><form:input path="empno" readonly="true"/></td>
       </tr>
       
       <tr>
         <td>EmpName:</td> <td><form:input path="empname" /></td>
       </tr>
       
       <tr>
         <td>Age:::</td> <td><form:input path="age" /></td>
       </tr>
       
       <tr>
         <td>Salary::</td> <td><form:input path="sal" /></td>
       </tr>
       
       <tr>
         <td colspan="2"><input type="submit" value="Update Data"/></td>
       </tr>
    </table>
</form:form>
