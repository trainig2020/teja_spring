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
<title></title>
</head>
<body>
	<div align="center">
        <h1>Department List</h1>
        <h3>
            <a href="newDepartment">New Department</a>
        </h3>
        <table border="1">
 
            <th>DEPTID</th>
            <th>DEPTNAME</th>
            <th>DEPTSALARY</th>
            <th>Update&Delete</th>
            <c:forEach var="dept" items="${DepartmentList}">
                <tr>
 
                    <td>${dept.deptId}</td>
                    <td>${dept.deptName}</td>
                    <td>${dept.deptBranch}</td>
                    <td><a href="editDepartment?id=${dept.deptId}">Edit</a>
                        <a href="deleteDepartment?id=${dept.deptId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
