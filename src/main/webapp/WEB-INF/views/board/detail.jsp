<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/include/sidebar.jsp"></c:import>
		
		<!-- Start -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
				<div class="container-fluid">
					<!-- page contents 내용 -->
					<h1>Detail page</h1>
					<h3>${result.boardTitle}</h3>
					<h3>${result.boardContents}</h3>
					
					<div>
						<form id="frm">
							<input type="hidden" name="boardNum" value="${result.boardNum}">
						</form>
						
						<button class="btn btn-outline-success action" data-kind="u">Update</button>
						<button class="btn btn-outline-danger action" data-kind="d">Delete</button>
						
						<c:if test="${board ne 'notice'}">
						<button class="btn btn-outline-primary action" data-kind="r">Reply</button>
						</c:if>
					</div>
					
				</div>
			</div>
			<!-- End Content -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>	
		</div>
		
		
	</div>
	<c:import url="/WEB-INF/views/include/tale.jsp"></c:import>
	<script type="text/javascript" src="/js/board/board_detail.js"></script>
</body>
</html>