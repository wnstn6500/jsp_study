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
					<h1>Notice</h1>
					<div class="row col-md-8 offset-md-2">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>No</th>
									<th>Title</th>
									<th>Writer</th>
									<th>Date</th>
									<th>Hit</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="vo">
								<tr>
									<td>${vo.boardNum}</td>
									<td>
									<c:forEach begin="1" end="${vo.boardDepth}">--</c:forEach>
									<a href="./detail?boardNum=${vo.boardNum}">${vo.boardTitle}</a></td>
									<td>${vo.boardWriter}</td>
									<td>${vo.boardDate}</td>
									<td>${vo.boardHit}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						
						<div>
							<a href="./add" class="btn btn-outline-success">글쓰기</a>
						</div>
						
					</div>
				</div>
			</div>
			<!-- End Content -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>	
		</div>
		
		
	</div>
	<c:import url="/WEB-INF/views/include/tale.jsp"></c:import>
	
	
	
</body>
</html>