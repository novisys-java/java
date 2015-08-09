<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<h2><spring:message code="heading"/></h2>

<table border="1" width="100%">

<tr>
<th>Emp ID</th>
<th>Employee Name</th>
<th>Salary</th>
<th>DeptNo</th>
</tr>

<tr>
<td><c:out value="${empDetails.empno}"/></td>
<td><c:out value="${empDetails.ename}"/></td>
<td><c:out value="${empDetails.salary}"/></td>
<td><c:out value="${empDetails.dept.deptno}"/></td>
</tr>
</table>

</html>