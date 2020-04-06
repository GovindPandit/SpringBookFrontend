<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
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
		<sp:form modelAttribute="user" action="${pageContext.request.contextPath}/user/add" method="post" class="col-lg-6 col-md-6 col-sm-6 col-xs-6 myclass">
			<h1>Registration Form</h1>
			<div class="form-group">
				<label>Enter Username</label>
				<sp:input path="username" cssClass="form-control" placeholder="Enter Username"/>
			</div>
			
			<div class="form-group">
				<label>Enter Email</label>
				<sp:input path="email" cssClass="form-control" placeholder="Enter Email"/>
			</div>
			
			<div class="form-group">
				<label>Enter Password</label>
				<sp:password path="password" cssClass="form-control" placeholder="Enter Password"/>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Register" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</sp:form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>