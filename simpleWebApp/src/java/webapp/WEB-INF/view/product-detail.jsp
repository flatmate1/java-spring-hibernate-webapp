<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
 
   <div class="page-title">Product</div>
 
   <form:form modelAttribute="productDetail" method="GET">
       <table style="text-align:left;">
           <tr>
               <td>Code *</td>
               <td style="color:red;">
                       ${product.code}
               </td>
       </table>
   </form:form>
 
 
 
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>