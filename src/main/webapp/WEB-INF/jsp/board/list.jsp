<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- 부트스트랩 시작 -->
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

		<!-- 부트스트랩 끝 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/bootstrap/css/bootstrap.min.css">
		<script src="${pageContext.request.contextPath}/resource/jquery/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/popper/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}/resource/bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/jquery-ui/jquery-ui.min.css">
		<link rel="icon" href="data:;base64,iVBORw0KGgo=">
		<script src="${pageContext.request.contextPath}/resource/jquery-ui/jquery-ui.min.js"></script>
		<script>
			var count=0
			var ID=""
			function mouseover_videohandler(ID){
				console.log("마우스가 범위 안으로 들어왔습니다.")
				video = document.getElementById(ID);
				video.reload;
				video.style = "width:480px; height:360px; margin:10px";
				video.style.backgroundColor="black";
				video.volmun = "5";
				if(video.paused){
					video.play(); 								
				}else{
					video.pause();
				}
				
			}
			function mouseout_videohandler(ID){
				console.log("마우스가 범위 밖으로 나갔습니다.");
				video = document.getElementById(ID);			
				video.style = "width:360px; height:240px; margin:10px";
				video.style.backgroundColor="black";				

				video.pause();
			}
			function mouseover_videohandler1(){
				console.log("마우스가 범위 안으로 들어왔습니다.")
				video = document.getElementById("videomain");
				video.volmun = "5";
							
				video.play();				
				
			}
			function mouseout_videohandler1(){
				console.log("마우스가 범위 밖으로 나갔습니다.");
				video = document.getElementById("videomain");							
				video.pause();
			}

		</script>
		<style type="text/css">
			body, p, h1, h2, h3, h4, h5, h6, ul, ol, li, dl, dt, dd, table, th, td, form, fieldset, legend, input, textarea, button, select, figure, figurecaption {
	    		margin: 0;
	    		padding: 0;
			}
			
			div{
				display:inline-block;
			}
			video{
				width:360px; height:240px; 
				border:1px; 
				background-color:rgb(20,20,20); 
				margin:10px;
			}
			section{
				width:100%;
				display:flex;
				flex-direction: row;
				justify-content: center;
			}
			li{
				color:#e5e5e5;
				position: relative;
			}
			a{
				color:#e5e5e5;
				position: relative;
				font-size: medium;
			}
			
		</style>
	</head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<body style="background-color:rgb(20,20,20);">
		<header style="text-align:center">		
			<!-- <h1 style="text-align: center;background-color:rgb(20,20,20);color:#e5e5e5; padding:20px;font-size:3rem;">보드리스트</h1> 	 -->							
			<a href="${pageContext.request.contextPath}/board/list.do"><img style="center; width:330px;height:110px; margin-top: 20px;" 
				src="${pageContext.request.contextPath}/resource/img/yongflix.png"/></a>
    	</header>
    	<nav style=" width:100%; height:60%">
    		<section style="justify-content: flex-end;">
	    		<div>
	    			<table style="margin-right: 50px;">	
		    			<tr>
							<td>
								<c:if test="${sessionMid == null}">
										<form action="${pageContext.request.contextPath}/member/login.do" >
									
											<button class="btn btn-secondary btn-lg">로그인</button>
								
										</form>
								</c:if>	
							</td>
						</tr>
						<tr>
							<td>
								<c:if test="${sessionMid != null}">
									<form action="${pageContext.request.contextPath}/member/gate.do">
										<button style="background-color:rgb(20,20,20);">											
											<svg class="bi bi-person-circle" width="3em" height="3em" viewBox="0 0 16 16" center fill="white" xmlns="http://www.w3.org/2000/svg">
											 	<path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
											 	<path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
											 	<path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
											</svg>			
										</button>
									</form>
									<form action="${pageContext.request.contextPath}/member/logout.do">							
										<button class="btn btn-secondary btn-lg">로그아웃</button>
									</form>
								</c:if>	
							</td>
						</tr>
					</table>
				</div>
			</section>
			<section>
				<div style="min-width:80%;min-height:300px;text-align:center;">
					<video id="videomain" src="${pageContext.request.contextPath}/resource/img/harry.mp4"
						style="min-width:100%;min-height:400px;background-color: black"
						onmouseover="mouseover_videohandler1()"
						onmouseout="mouseout_videohandler1()"
						preload="auto"
						loop
						autoplay
						>
					</video>
				</div>
			</section>
			<section>
				<br/>
				<br/>
				<br/>
			</section>
    		<section>
				<br/>			
				<div class="slider" style="display:inline-block;">
					<div style="padding-left:1%; margin-left: 2%"></div>
					<div style="color:#e5e5e5; display:inline-block;margin-right:30px">	
							<h1> 영화리스트  </h1>
					</div>
					<div>
						<c:if test="${sessionMid != null}">
							<ul>
								<li>																				
									<a href="${pageContext.request.contextPath}/board/write.do">글쓰기</a>
								</li>
							</ul>
						</c:if>
					</div>	
					<table style="margin-bottom: 7%;backgroundColor:black">
					<c:set var="i" value="0" /> 
					<c:set var="j" value="5" />

					<c:forEach var="board" items="${boardlist}">
						<c:if test="${i%j == 0 }">	<tr>	</c:if>			
							<td>
								<a href="${pageContext.request.contextPath}/board/detail.do?cno=-1&bno=${board.bno}">
									<video id="${board.bno}"
											poster = "bposterDownload.do?bno=${board.bno}"
											src = "bvideoDownload.do?bno=${board.bno}"
											onmouseover="mouseover_videohandler(${board.bno})"
											onmouseout="mouseout_videohandler(${board.bno})"
											
											
											><!-- controls 생략 -->
									</video>
								</a>
							</td>
						<c:if test="${i%j == j-1 }">	</tr>	</c:if>
					    <c:set var="i" value="${i+1}"/>
					</c:forEach>
					</table>
				</div>			
			</section>
			<!-- -----------------------------------------------------------------------------------------  -->
		</nav>	
</html>
