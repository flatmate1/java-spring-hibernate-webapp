<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head></head>



<body>
    <h1>This is the body of the sample view</h1>
    <h2>see this if you logout</h2>
    <security:authorize access="isAnonymous()">
    <a href="<c:url value="/login" />">Login</a>
    <a href="<c:url value="/register" />">register</a>
    </security:authorize>
    
	
    <security:authorize access="hasRole('ROLE_USER')">
        This text is only visible to a user
        <br/> <br/>
        <a href="<c:url value="/adminpagel" />">Restricted Admin Page</a>
        <br/> <br/>
    </security:authorize>
	
    <security:authorize access="hasRole('ROLE_ADMIN')">
        This text is only visible to an admin
        <br/>
        <a href="<c:url value="/adminpage" />">Admin Page</a>
        <br/>
    </security:authorize>
    <br/> <br/>
    <br/> <br/>
	<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
        This text is only visible if you login
        <br/>
        <a href="<c:url value="/logout" />">logout</a>
        <br/> <br/>
    </security:authorize>
	

</body>
</html>