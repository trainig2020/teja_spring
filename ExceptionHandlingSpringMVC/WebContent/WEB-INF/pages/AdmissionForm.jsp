<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>

<p><a href="/ExceptionHandlingSpringMVC/admissionForm.html?sitetheme=green">green</a>
<a href="/ExceptionHandlingSpringMVC/admissionForm.html?sitetheme=red">red</a></p>

<a href="/ExceptionHandlingSpringMVC/admissionForm.html?sitelanguage=en">English</a>
<a href="/ExceptionHandlingSpringMVC/admissionForm.html?sitelanguage=fr">French</a>


<h3>${headerMessage}</h3>
<h3><spring:message code="label.admissionForm"/></h3>

<form:errors path="student1.*"/>
<form action="/InterceptorSpringMvc/submitAdmissionForm.html" method="post">
<table>
<tr>
<td><spring:message code="label.studentName"/></td><td><input type="text" name="studentName"></td>
</tr><tr>
<td><spring:message code="label.studentHobby"/></td><td><input type="text" name="studentHobby"></td>
</tr><tr>
<td><spring:message code="label.studentMobile"/></td><td><input type="text" name="studentMobile"></td>
</tr><tr>
<td><spring:message code="label.studentDOB"/></td><td><input type="text" name="studentDOB"></td>
</tr><tr>
<td><spring:message code="label.studentSkills"/></td><td><select  name="studentSkills" multiple>
                          <option value="java">java</option>
                          <option value="c">c</option>
                          <option value="c#">c#</option>
                            </select></td>
   </tr>                     

</table>

<table>
<tr><td><spring:message code="label.studentAddress"/></td></tr>

<tr>
<td><spring:message code="label.country"/><input type="text" name="studentAddress.country"></td>
<td><spring:message code="label.city"/><input type="text" name="studentAddress.city"></td>
<td><spring:message code="label.street"/><input type="text" name="studentAddress.street"></td>
<td><spring:message code="label.pincode"/><input type="text" name="studentAddress.pincode"></td>
</tr>

<tr><td>
<spring:message code="label.submit.admissionForm" var="labelSubmitAdmissionForm"></spring:message>
<input type="submit" value="${labelSubmitAdmissionForm}"/></td></tr>

</table>
</form>

</body>
</html>