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
        <h1>Employee List</h1>
        <h3>
            <a href="newEmployee">New Employee</a>
        </h3>
        <table border="1">
 
            <th>EMPID</th>
            <th>EMPNAME</th>
            <th>EMPSALARY</th>
            <th>Update&Delete</th>
            <c:forEach var="emp" items="${EmployeeList}">
                <tr>
 
                    <td>${emp.empid}</td>
                    <td>${emp.empname}</td>
                    <td>${emp.empsalary}</td>
                    <td><a href="editEmployee?id=${emp.empid}">Edit</a>
                        <a href="deleteEmployee?id=${emp.empid}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
