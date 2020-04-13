<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<form class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myclass" action="<sp:url value='/user/checkotp'></sp:url>" method="post">
			<h1>Login Page</h1>
			<div class="form-group">
				<label>Enter OTP</label>
				<input type="text" name="userotp" placeholder="Enter OTP" class="form-control"/>
			</div>
			<div class="form-group">
				<input type="hidden" name="otp" value="${otp}" placeholder="Enter OTP" class="form-control"/>
			</div>
			<div>
				<input type="submit" value="Check OTP" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
		</form>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	</body>
</body>
</html>