<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
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
				<div style="background-color: white;"class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
					<form method="post" action="write.do" class="login100-form validate-form flex-sb flex-w" enctype="multipart/form-data">
			<table>
				<tr>
					<td><span class="login100-form-title p-b-32">글쓰기</span><td>
				</tr>
				<tr>
					<td><span class="txt1 p-b-11">제목</span></td>
				</tr>
				<tr>
					<td>
						<div class="wrap-input100">
							<input style="width:400px;" type="text" name="btitle"/>
						</div>
					</td>
				</tr>
				<tr>
					<td><span class="txt1 p-b-11">내용</span></td>
				</tr>
				<tr>
				
					<td>
						<div class="wrap-input100">
							<textarea style="width:400px; resize: none" name="bcontent" rows="5"></textarea>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div>							
							<div style="display:inline-block;">
								장르
								<select id="bgenre" name="bgenre">
									<option>액션</option>
									<option>로맨스</option>
									<option>SF/판타지</option>
									<option>호러</option>
									<option>코미디</option>
								</select>
							</div>
						</div>
						<br/>
					</td>
				</tr>
				<tr>					
					<td>
						포스터 업로드<input type="file" name="bposter" />
					</td>
				</tr>
				<tr>
					<td>비디오 업로드</td>
				</tr>
				<tr>
					<td><input type="file" name="bvideo"/></td>
				</tr>
			</table>
			
			<div style="margin-top: 25px" class="container-login100-form-btn">
				<button class="login100-form-btn" type="submit">
					글쓰기
				</button>
			</div>
			<!-- <input type="submit" value="글쓰기" style="margin-top:10px"/> -->
		
				</form>
				</div>
			</div>
		</div>
	</body>
</html>