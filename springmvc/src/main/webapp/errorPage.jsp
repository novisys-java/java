<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

Error: <br>

<c:forEach items="${errors.allErrors}" var="error">
	<li><c:out value="${error.defaultMessage}"></c:out></li>
</c:forEach>
