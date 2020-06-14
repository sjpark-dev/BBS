<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/bootstrap/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resource/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resource/popper/popper.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resource/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/jquery-ui/jquery-ui.min.css">
<script
	src="${pageContext.request.contextPath}/resource/jquery-ui/jquery-ui.min.js"></script>


<c:if test="${updateStatus == null}">
	<script>
		$(function() {
			load_commentList();
		})
	</script>
	
</c:if>

<c:if test="${updateStatus != null}">
	<script>
		$(function() {
			load_commentList_updateForm();
		})
	</script>

</c:if>

<script>
	function load_commentList() {
		//매개값으로 object를 준다. jQuery 레퍼런스 참고
		$.ajax({
			url : "${pageContext.request.contextPath}/comment/commentList.do",
			method : "POST",
			data : {
				bno : "${board.bno}"
			},
			//Callback 함수 : 응답이 도착했을 때 자동실행
			success : function(data, textStatus, jqXHR) {
				$("#commentList").html(data); // data -> 결국 요청한 jsp파일의  html 구성 요소
			}
		});
	}

	function load_commentList_updateForm() {
		console.log("${updateStatus}");
		console.log("${board.bno}");
		console.log("${cno}");
		//매개값으로 object를 준다. jQuery 레퍼런스 참고
		$.ajax({
					url : "${pageContext.request.contextPath}/comment/commentListUpdateForm.do",
					method : "POST",
					data : {
						bno : "${board.bno}",
						cno : "${cno}"
					},
					//Callback 함수 : 응답이 도착했을 때 자동실행
					success : function(data, textStatus, jqXHR) {
						$("#commentList").html(data); // data -> 결국 요청한 jsp파일의  html 구성 요소
					}
				});
	}
	
	function writeComment() {
		if($("#ccontent").val()==""){
			alert("댓글을 입력해주세요.");
		}
		else{
			$.ajax({
					//비동기 요청 경로
					url : "${pageContext.request.contextPath}/comment/write.do",
					method : "POST",
					data : {
						bno : "${board.bno}",
						bwriter: "${sessionMid}",
						ccontent: $("#ccontent").val()
					},
					//Callback 함수 : 응답이 도착했을 때 자동실행
					success : function(data, textStatus, jqXHR) {
						$("#ccontent").val("");
						$("#commentList").html(data); // data -> 결국 요청한 jsp파일의  html 구성 요소
						
					}
				});
			}
	}
	
	function temp(){
		console.log("들어옴??");
		alert("이미 별점을 등록 했습니다.");
	}
</script>
<style>
	.title{
		font-size: 3vw;
		padding: 0 5%;
		color: white;
		line-height: 2.03125vw;
		margin-top: 100px;
	}
	.content{
		font-family:Agenda-Light,Agenda\ Light,Agenda,Arial\ Narrow,sans-serif;
        font-weight:100;
        background:rgba(0,0,0,.3);
        color:#fff;
        padding:2rem;
        width:600px;
        height:500px;
        font-size:1.2rem;
        text-align: center;
        margin-left: 350px;
	}
	.board{
		font-family:Agenda-Light,Agenda\ Light,Agenda,Arial\ Narrow,sans-serif;
        font-weight:100;
        background:rgba(0,0,0,.3);
        color:#fff;
        padding:2rem;
        width:600px;
        height:500px;
        font-size:1.2rem;
        text-align: center;
	}
    h1{
        font-size:3rem;
        text-transform:uppercase;
        margin-top:0;
        letter-spacing:.3rem
    }
    .video {
		width: 1280px;
		height:800px;
	}
</style>
</head>
<body style="background-color: rgb(20, 20, 20)">
	
	<div style="text-align: center;" class="title">
		<a>${board.btitle}</a>
	</div>
	
	
	<div style="float: right;">
		<h5>
			<c:if test="${sessionMid == board.bwriter}">
			<a href="${pageContext.request.contextPath}/board/update.do?bno=${board.bno}">
				<button>
					<svg class="bi bi-tools" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M0 1l1-1 3.081 2.2a1 1 0 0 1 .419.815v.07a1 1 0 0 0 .293.708L10.5 9.5l.914-.305a1 1 0 0 1 1.023.242l3.356 3.356a1 1 0 0 1 0 1.414l-1.586 1.586a1 1 0 0 1-1.414 0l-3.356-3.356a1 1 0 0 1-.242-1.023L9.5 10.5 3.793 4.793a1 1 0 0 0-.707-.293h-.071a1 1 0 0 1-.814-.419L0 1zm11.354 9.646a.5.5 0 0 0-.708.708l3 3a.5.5 0 0 0 .708-.708l-3-3z"/>
					  <path fill-rule="evenodd" d="M15.898 2.223a3.003 3.003 0 0 1-3.679 3.674L5.878 12.15a3 3 0 1 1-2.027-2.027l6.252-6.341A3 3 0 0 1 13.778.1l-2.142 2.142L12 4l1.757.364 2.141-2.141zm-13.37 9.019L3.001 11l.471.242.529.026.287.445.445.287.026.529L5 13l-.242.471-.026.529-.445.287-.287.445-.529.026L3 15l-.471-.242L2 14.732l-.287-.445L1.268 14l-.026-.529L1 13l.242-.471.026-.529.445-.287.287-.445.529-.026z"/>
					</svg>
				</button>
			</a>
			<a href="${pageContext.request.contextPath}/board/delete.do?bno=${board.bno}">
				
				<button>
				<svg class="bi bi-trash" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  					<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  					<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
				</svg>
				</button>
			</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/board/list.do">
				<button>
					<svg class="bi bi-house-door" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
					  <path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
					</svg>
				</button>
			</a>
		</h5>
	</div>
	
	<div style="margin-left:5%;text-align: center;">
	<video class="video"
		   poster = "bposterDownload.do?bno=${board.bno}"
		   controls
		   src = "bvideoDownload.do?bno=${board.bno}">
		   
	</video>
	</div>
	
	<table>
	<tr>
	<td>
	<section class="content" style="overflow-y:scroll">
		<p>${board.bcontent}</p>
	</section>
	</td>
	<td>
	<section class="board">
		<p>장르 : ${board.bgenre}</p>
		<p>작성자 : ${board.bwriter}</p>
		<p>조회수 : ${board.bhitcount}</p>
		<p>게시글 날짜 : <fmt:formatDate value="${board.bdate}"	pattern="yyyy-MM-dd hh:mm" /></p>
		<p>평점 : <a><c:if test="${board.btotalrating/board.bratingcount == 'NaN'}">0</c:if>
				    <c:if test="${board.btotalrating/board.bratingcount != 'NaN'}">${rating}</c:if></a></p>
		<p>
			<c:if test="${sessionMid != null}">
				<form method="post" action="rating.do">
					<input type="hidden" name="bno" value="${board.bno}" />
					<select name="btotalrating">
								<option>0</option>
								<option>0.5</option>
								<option>1</option>
								<option>1.5</option>
								<option>2</option>
								<option>2.5</option>
								<option>3</option>
								<option>3.5</option>
								<option>4</option>
								<option>4.5</option>
								<option>5</option>
					</select> 
					<input type="submit" style="margin-bottom: 2px" class="btn btn-secondary btn-sm" value="평점주기" />
				</form>
				<form method="post" action="ratingupdate.do">
					<input type="hidden" name="bno" value="${board.bno}" /> 
					<select
						name="btotalrating">
						<option>0</option>
						<option>0.5</option>
						<option>1</option>
						<option>1.5</option>
						<option>2</option>
						<option>2.5</option>
						<option>3</option>
						<option>3.5</option>
						<option>4</option>
						<option>4.5</option>
						<option>5</option>
					</select> <input type="submit" style="margin-bottom: 2px" class="btn btn-secondary btn-sm" value="평점수정" />
				</form>
				<form method="post" action="ratingdelete.do">
					<input type="hidden" name="bno" value="${board.bno}" /> <input
						type="submit" class="btn btn-secondary btn-sm" value="평점제거" />
				</form>
			</c:if>
		</p>
	</section>
	</td>
	</tr>
	</table>
	
	<section>
	<br/>
	<div class="row" > <!-- 추가 -->
	  	<div class="col-sm-2" ></div> <!-- 추가 -->
	  	<div class="col-sm-8"> <!-- 추가 -->
  	
	
	<c:if test="${sessionMid != null }">
		<c:if test="${updateStatus == null}">
			<%--댓글 입력 --%>
				<div class="text-center">
				<div class="input-group flex-nowrap" >
		  						<input id="ccontent" 
		  							   name="ccontent" 
		  							   type="text" 
		  							   class="form-control" 
		  							   placeholder="댓글을 입력하세요." 
		  							   aria-describedby="resisterBtn"
		  							>
								 <button class="btn btn-secondary"
								 		id="resisterBtn"
								 		onclick="writeComment()">
								 등록</button>
	  					</div>
				</div>
			</c:if>
		</c:if>
		<br/>
	 	</div> <!-- 추가 -->
	  	<div class="col-sm-2"></div><!-- 추가 -->
	</div><!-- 추가 -->
	
  	
	 	<%-- 댓글리스트 --%>
		<div class="col-sm-1" ></div> <!-- 추가 -->
		<div class="col-sm-12" id="commentList" align="center"></div>
		<div class="col-sm-1"></div>
	</section>
</body>
</html>





