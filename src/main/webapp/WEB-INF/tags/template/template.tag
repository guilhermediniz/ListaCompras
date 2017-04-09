<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A layout example with a side menu that hides on mobile, just like the Pure website.">

<title>Sistema - Lista de Compras</title>




<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">








<!--[if lte IE 8]>
        <link rel="stylesheet" href="<c:url value='/assets/css/layouts/side-menu-old-ie.css'/>">
    <![endif]-->
<!--[if gt IE 8]><!-->
<link rel="stylesheet" href="<c:url value='/assets/css/layouts/side-menu.css'/>">
<!--<![endif]-->







<jsp:invoke fragment="extraStyles" />

</head>

<body>
	<jsp:doBody />
</body>
</html>