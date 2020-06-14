<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>오류</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--===============================================================================================-->	
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resource/login/images/icons/favicon.ico"/>
	<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/vendor/bootstrap/css/bootstrap.min.css">
	<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/vendor/animate/animate.css">
	<!--===============================================================================================-->	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/vendor/css-hamburgers/hamburgers.min.css">
	<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/vendor/animsition/css/animsition.min.css">
	<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/vendor/select2/select2.min.css">
	<!--===============================================================================================-->	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/vendor/daterangepicker/daterangepicker.css">
	<!--===============================================================================================-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/css/util.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/login/css/main.css">
	<!--===============================================================================================-->
	</head>
	
	<body>
		<div class="limiter" >
			<div class="container-login100">
				<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
					<form method="get" action="${pageContext.request.contextPath}/board/list.do" class="login100-form validate-form flex-sb flex-w">
						<span class="login100-form-title p-b-32">
							오류	:	잘못된 접근입니다.
						</span>
	
						<div class="container-login100-form-btn">
							<button class="login100-form-btn">
								홈으로
							</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
		
	
		<div id="dropDownSelect1"></div>
		
	<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resource/login/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resource/login/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resource/login/vendor/bootstrap/js/popper.js"></script>
		<script src="${pageContext.request.contextPath}/resource/login/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resource/login/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resource/login/vendor/daterangepicker/moment.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/login/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resource/login/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
		<script src="${pageContext.request.contextPath}/resource/login/js/main.js"></script>
	
	</body>
</html>