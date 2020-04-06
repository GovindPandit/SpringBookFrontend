<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<link rel="stylesheet" href='<sp:url value="/css/book.css"></sp:url>'/>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="http://placekitten.com/400/252" /></div>
						</div>
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${book.bookname}</h3>
						<p class="product-description">${book.description}</p>
						<h4 class="price">current price: <span>Rs. ${book.price}</span></h4>
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
						<div class="action">
							<button class="btn btn-primary">Add To Cart</button>
							<c:if test="${book.price>0}">
								<a class="btn btn-warning" href="${pageContext.request.contextPath}/order/${book.bookid}">Buy</a>
							</c:if>
							
							<a class="btn btn-danger" href="${pageContext.request.contextPath}/book/delete/${book.bookid}">Delete</a>
							<a class="btn btn-warning" href="${pageContext.request.contextPath}/book/edit/${book.bookid}">Edit</a>
							<c:if test="${book.price<=0}">
								<a href="${book.booklink}" class="btn btn-success" target="_blank">Read</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>