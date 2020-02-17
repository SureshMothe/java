<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<center></center>
<h1 style="color: red">Welcome To Edit Date Page</h1>
</center>
<center>
	<a href="home">Back To Home Page</a>
</center>
<hr>
<form:form action="editedData" method="POST" modelAttribute="emp">

	<table>
		<tr>
			<td>EmpId::</td>
			<td><form:input path="id" readonly="true" /></td>
		</tr>
		
		<tr>
			<td>EmpName::</td>
			<td><form:input path="name" /></td>
		</tr>
		
		<tr>
			<td>EmpAge::</td>
			<td><form:input path="age" /></td>
		</tr>
		
		<tr>
			<td>EmpSalary::</td>
			<td><form:input path="salary" /></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="Update"></td>
			
		</tr>
	</table>

</form:form>
