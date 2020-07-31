<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
h1 {
	color: red;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 15px;
	text-align: left;
}
</style>
<title>Getting All Employee</title>
</head>
<body>
	<a href="newEmployee"><h2>Insert New Employee</h2></a>
	
	<c:if test="${Register eq 'NewForm'}">
		<form action="saveEmployee" method="post">
	</c:if>
	<c:if test="${Register ne 'NewForm'}">
		<form action="saveEmployee" method="post">
	</c:if>

	<table border="2" style="width: 100%"background-color:#eee;>
		<thead>
			<tr>
				<th>EMPID</th>
				<th>EMPNAME</th>
				<th>EMPSALARY</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${EmployeeList}" var="emp">
			      		
				<c:if test="${employeeid eq emp.empid}">
					<tr>
						<td><input type="text" name="empid"
							value="${emp.empid}" readonly="readonly" /></td>
						<td><input type="text" name="empname"
							value="${emp.empname}" /></td>
						<td><input type="text" name="empsalary"
							value="${emp.empsalary}" /></td>
						<td><input type="submit" value="update" /></td>
					</tr>
				</c:if>
				<c:if test="${employeeid ne emp.empid}">
					<tr>
						
                    <td>${emp.empid}</td>
                    <td>${emp.empname}</td>
                    <td>${emp.empsalary}</td>
                    <td><a href="getEmployee?id=${emp.empid}">Update</a></td>
                     <td><a href="deleteEmployee?id=${emp.empid}">Delete</a></td>
					</tr>
				</c:if>
				</c:forEach>
					<c:if test="${insertEmployee eq 'newemployee'}">
						<tr>
							<td><input type="text" name="empid" /></td>
							<td><input type="text" name="empname" /></td>
							<td><input type="text" name="empsalary"/></td>
							<td colspan="2"><input type="submit" value="save"/></td>
						</tr>
					</c:if>	
		</tbody>
	</table>
</form>
</body>
</html>