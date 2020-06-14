<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<title>회원정보</title>
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
					<form method="post" action="update.do" class="login100-form validate-form flex-sb flex-w" enctype="multipart/form-data">
						<span class="login100-form-title p-b-32">
							글 수정
						</span>
	
						<span class="txt1 p-b-11">
							제목
						</span>			
						<div class="wrap-input100 validate-input m-b-12">
							<input name="bno" type="hidden" class="input100" value="${board.bno}"/>
							<input name="btitle" class="input100" value="${board.btitle}"/>
						</div>
						
						<span class="txt1 p-b-11">
							내용
						</span>
						<div class="wrap-input100 validate-input m-b-12">
							<textarea class="input100" name="bcontent" rows="5" style="width:400px; height:300px">${board.bcontent}</textarea>
						</div>
						
						<span class="txt1 p-b-11">
							장르
						</span>
						
						<select value="${board.bgenre}" id="bgenre" name="bgenre">
								<option>액션</option>
								<option>로맨스</option>
								<option>SF/판타지</option>
								<option>호러</option>
								<option>코미디</option>
							</select>
						<div class="wrap-input100 validate-input m-b-12"></div>
						
						<span class="txt1 p-b-11">
							포스터
						</span><br/>
							<img style="margin-right: 100px"width=250px height=300px src="bposterDownload.do?bno=${board.bno}"/><br/>
							<input style="margin-top: 2px"name="bposter" type="file" class="input100" value="${board.bposter}"/>
						<div class="wrap-input100 validate-input m-b-12"></div>
						<span class="txt1 p-b-11">
							비디오
						</span>		
						<video loop="loop" autoplay="autoplay" style="margin-right: 100px"width=400px height=320px src="bvideoDownload.do?bno=${board.bno}"></video>
						<input type="file" name="bvideo" class="input100" value="${board.bvideo}"/>
						
						
						<div class="container-login100-form-btn">
							<button class="login100-form-btn">
								수정
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
	<%-- <body>
		<h5 class="alert alert-info">/board/updateForm.jsp</h5>
		<form method="post" action="update.do" enctype="multipart/form-data">
			<table>
				<tr><td><input type="hidden" name="bno" value="${board.bno}"/></td></tr>
				<tr>
					<td>제목</td>
					<td><input value="${board.btitle}" type="text" name="btitle" style="width:400px"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="bcontent" rows="5" style="width:400px">${board.bcontent}</textarea></td>
				</tr>
				<tr>
					<td>장르</td>
					<td>
						<select value="${board.bgenre}" id="bgenre" name="bgenre">
							<option>액션</option>
							<option>로맨스</option>
							<option>SF/판타지</option>
							<option>호러</option>
							<option>코미디</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>포스터</td>
					<td><img width=200px height=300px src="bposterDownload.do?bno=${board.bno}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="file" name="bposter"/></td>
				</tr>
				<tr>
					<td>비디오</td>
					<td><video width=200px height=300px src="bvideoDownload.do?bno=${board.bno}"/></video>
				</tr>
				<tr>
					<td></td>
					<td><input type="file" name="bvideo"/></td>
				</tr>
			</table>
			<input type="submit" value="수정" style="margin-top:10px"/>
		</form>		
	</body>
</html> --%>