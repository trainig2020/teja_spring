<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>STUDEN ADMISSION FORM FOR ENGINEERING COURSES</h1>
<h2>${headerMessage}</h2>

<form:errors path="studen1."/>
<form action="/Databindingwithcollection/submitAdmissionForm.html" method="post">
<table>
<tr>
<td>Student Name:</td><td><input type="text" name="studentName"></td>
</tr><tr>
<td>Student Hobby:</td><td><input type="text" name="studentHobby"></td>
</tr><tr>
<td>Student Mobile:</td><td><input type="text" name="studentMobile"></td>
</tr><tr>
<td>Student DOB:</td><td><input type="text" name="studentDOB"></td>
</tr><tr>
<td>Student Skills:</td><td><select  name="studentSkills" multiple>
                          <option value="java">java</option>
                          <option value="c">c</option>
                          <option value="c#">c#</option>
                            </select></td>
   </tr>                     

</table>
<table>
<tr><td>Student Address:</td></tr>

<tr>
<td>country:<input type="text" name="studentAddress.country"></td>
<td>city:<input type="text" name="studentAddress.city"></td>
<td>street:<input type="text" name="studentAddress.street"></td>
<td>pincode:<input type="text" name="studentAddress.pincode"></td>
</tr>

<tr><td><input type="submit" value="submit this form"></td></tr>

</table>
</form>

</body>
</html>