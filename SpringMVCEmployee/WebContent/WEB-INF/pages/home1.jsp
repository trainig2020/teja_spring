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
<title>Getting All departments</title>
</head>
<body>
	<a href="newEmployee"><h2>Insert New Department</h2></a>
	
	<c:if test="${Register eq 'NewForm'}">
		<form action="saveDepartment" method="post">
	</c:if>
	<c:if test="${Register ne 'NewForm'}">
		<form action="saveDepartment" method="post">
	</c:if>

	<table border="2" style="width: 100%"background-color:#eee;>
		<thead>
			<tr>
				<th>DEPTID</th>
				<th>DEPTNAME</th>
				<th>DEPTSALARY</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${DepartmentList}" var="dept">
			      		
				<c:if test="${departmentid eq dept.deptId}">
					<tr>
						<td><input type="text" name="deptId"
							value="${dept.deptId}" readonly="readonly" /></td>
						<td><input type="text" name="deptName"
							value="${dept.deptName}" /></td>
						<td><input type="text" name="deptBranch"
							value="${dept.deptBranch}" /></td>
						<td><input type="submit" value="update" /></td>
					</tr>
				</c:if>
				<c:if test="${departmentid ne dept.deptId}">
					<tr>
						
                    <td>${dept.deptId}</td>
                    <td>${dept.deptName}</td>
                    <td>${dept.deptBranch}</td>
                    <td><a href="getDepartment?id=${dept.deptId}">Update</a></td>
                     <td><a href="deleteDepartment?id=${dept.deptId}">Delete</a></td>
					</tr>
				</c:if>
				</c:forEach>
					<c:if test="${insertDepartment eq 'newdepartment'}">
						<tr>
							<td><input type="text" name="deptId" /></td>
							<td><input type="text" name="deptName" /></td>
							<td><input type="text" name="deptBranch"/></td>
							<td colspan="2"><input type="submit" value="save"/></td>
						</tr>
					</c:if>	
		</tbody>
	</table>
</form>
</body>
</html>