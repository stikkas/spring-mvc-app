
<%@include file="include.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><fmt:message key="title"/></title>
	</head>
	<body>
		<h1><fmt:message key="heading"/></h1>
		<p><fmt:message key="greeting"/> ${model.now}</p>
		<h3>Products</h3>
		<c:forEach items="${model.products}" var="prod">
			${prod.description}  <i>$${prod.price}</i><br><br>
		</c:forEach>
	</body>
</html>
