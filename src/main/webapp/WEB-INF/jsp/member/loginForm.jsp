<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>로그인</title>
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
					<c:if test="${sessionMid == null}">
						<form:form method="post" action="login.do" class="login100-form validate-form flex-sb flex-w" modelAttribute="member">
							<span class="login100-form-title p-b-32">
								<!-- Account Login --> 계정 로그인
							</span>
		
							<span class="txt1 p-b-11">
								<!-- Identification --> 아이디
							</span>
								<form:errors path="mid" style="color:red"/>						
							<div class="wrap-input100 validate-input m-b-36">
								<form:input path="mid" class="input100"/>
							</div>
							
							<span class="txt1 p-b-11">
								<!-- Password --> 비밀번호
							</span>
								<form:errors path="mpassword" style="color:red"/>
							<div class="wrap-input100 validate-input m-b-12">
								<form:password path="mpassword" class="input100"/>
								<form:hidden path="mname"/>
								<form:hidden path="mtel"/>
								<form:hidden path="memail"/>
							</div>
							
							<div class="flex-sb-m w-full p-b-48">
								<div>
									<a href="${pageContext.request.contextPath}/board/list.do" class="txt3">
										홈으로
									</a>
								</div>
								<div>
									<a href="join.do" class="txt3">
										회원가입
									</a>
								</div>
								<div>
									<a href="findId.do" class="txt3">
										아이디 찾기
									</a>
								</div>
								<div>
									<a href="findPassword.do" class="txt3">
										비밀번호 찾기
									</a>
								</div>
							</div>
							
							<div class="container-login100-form-btn">
								<button class="login100-form-btn">
									로그인
								</button>
							</div>
						</form:form>
					</c:if>
					<c:if test="${sessionMid != null}">
						<form:form method="post" action="login.do" class="login100-form validate-form flex-sb flex-w" modelAttribute="member">
							<span class="login100-form-title p-b-32">
								현재 로그인 상태입니다.
							</span>
		
							<div class="flex-sb-m w-full p-b-48">
								<div>
									<a href="${pageContext.request.contextPath}/board/list.do" class="txt3">
										홈으로
									</a>
								</div>
								<div>
									<a href="logout.do" class="txt3">
										로그아웃
									</a>
								</div>
							</div>
						</form:form>
					</c:if>
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