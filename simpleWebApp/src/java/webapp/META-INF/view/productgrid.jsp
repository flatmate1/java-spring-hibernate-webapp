<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resource/css/style.css"/>">

<link href="<c:url value="/resource/css/productgrid.css" />" rel="stylesheet">



</head>
<body>

 <div class="container ">
        <div class="row">
            <div class="col-sm-8 col-md-10">
                <div class="page-header">
					<p>product list</p>
                </div>
            </div>
        </div>
        <!-- Title -->
        <br>
        <!-- Page Features -->
        <div class="row text-center">

            <c:forEach items="${productList}" var="product">
                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="<c:url value="/resources/product_images/${producto.producto_id}.png" />"
                             alt="${product.name}">
                        <hr>
                        <div class="caption">
                            <p class="product-name"><b>${product.name}</b></p>
                            <p class="precio">${product.price}</p>

                            <p>
                                <spring:url value="/product/${product.id}" var="userUrl" />
                                <button class="btn btn-info" 
                                          onclick="location.href='${userUrl}'">Details</button>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</body>
</html>
