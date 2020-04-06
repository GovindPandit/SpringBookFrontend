<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
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
		<form class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myclass" action="<sp:url value='/loginaction'></sp:url>" method="post">
			<h1>Login Page</h1>
			<div class="form-group">
				<label>Enter Username</label>
				<input type="text" name="username" placeholder="Enter Username" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Enter Password</label>
				<input type="password" name="password" placeholder="Enter Password" class="form-control"/>
			</div>
			<div>
				<input type="submit" value="Login" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</form>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>