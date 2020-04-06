<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.myclass
	{
		margin:0 auto;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<c:if test="${b==null}">
		<sp:form modelAttribute="book" action="${pageContext.request.contextPath}/book/add" method="post" cssClass="col-lg-6 col-md-6 col-sm-12 col-xs-12 myclass">
			<h1>Add Book</h1>
			<div class="form-group">
				<label>Enter BookName</label>
				<sp:input path="bookname" cssClass="form-control" placeholder="Enter Bookname"/>
			</div>
			<div class="form-group">
				<label>Enter BookLink</label>
				<sp:input path="booklink" cssClass="form-control" placeholder="Enter BookLink"/>
			</div>
			<div class="form-group">
				<label>Enter Description</label>
				<sp:textarea path="description" cssClass="form-control" placeholder="Enter Description"/>
			</div>
			<div class="form-group">
				<label>Enter Price</label>
				<sp:input path="price" cssClass="form-control" placeholder="Enter Price"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Add Book" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
			
		</sp:form>
		</c:if>
		
		<c:if test="${b!=null}">
		<sp:form modelAttribute="b" action="${pageContext.request.contextPath}/book/update" method="post" cssClass="col-lg-6 col-md-6 col-sm-12 col-xs-12 myclass">
			<h1>Add Book</h1>
			<div class="form-group">
				<label>Enter BookId</label>
				<sp:input path="bookid" cssClass="form-control" placeholder="Enter Bookid"/>
			</div>
			<div class="form-group">
				<label>Enter BookName</label>
				<sp:input path="bookname" cssClass="form-control" placeholder="Enter Bookname"/>
			</div>
			<div class="form-group">
				<label>Enter BookLink</label>
				<sp:input path="booklink" cssClass="form-control" placeholder="Enter BookLink"/>
			</div>
			<div class="form-group">
				<label>Enter Description</label>
				<sp:textarea path="description" cssClass="form-control" placeholder="Enter Description"/>
			</div>
			<div class="form-group">
				<label>Enter Price</label>
				<sp:input path="price" cssClass="form-control" placeholder="Enter Price"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Update Book" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
			
		</sp:form>
		</c:if>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>