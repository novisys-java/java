<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<h2>User Details</h2>

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
<td><c:out value="${empDetails.deptno}"/></td>
</tr>
</table>

</html>