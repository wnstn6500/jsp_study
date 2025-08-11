<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/head_css.jsp" %>
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
					<div class="col-md-8 offset-md-2">
						<h2>${board}</h2>
						
						<c:if test="${ list.size() eq 0 }">
							<h2>아무것도 없습니다...</h2>							
						</c:if>
						<c:if test="${ list.size() gt 0 }">
						
						<div class="row">
							<form id="serachForm">
							<div class="input-group mb-3">
							<input type="hidden" name="pageNum" id="pageNum">
							<select class="form-control" name="kind" aria-label="Default select example">
							  <option value="k1" ${pager.kind eq 'k1'?'selected':''}>Title</option>
							  <option value="k2" ${pager.kind eq 'k2'?'selected':''}>Contents</option>
							  <option value="k3" ${pager.kind eq 'k3'?'selected':''}>Writer</option>
							</select>
							  <input type="text" class="form-control" value="${pager.keyword}" name="keyword" placeholder="Recipient’s username" aria-label="Recipient’s username" aria-describedby="button-addon2">
							  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Button</button>
							</div>
							</form>	
						</div>
						
						
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Num</th>
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
									<c:catch>
										<c:forEach begin="1" end="${vo.boardDepth}">--</c:forEach>
									</c:catch>
									<a href="./detail?boardNum=${vo.boardNum}">${vo.boardTitle}</a></td>
									<td>${vo.boardWriter}</td>
									<td>${vo.boardDate}</td>
									<td>${vo.boardHit}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div>
							<nav aria-label="Page navigation example">
							<ul class="pagination">
							  <li class="page-item"><a class="page-link pn">Previous</a></li>
							  <c:forEach begin="${pager.startNum}" end="${pager.endNum}" var="i">
							  <li class="page-item"><a class="page-link pn" data-pn="${i}">${i}</a></li>
							  </c:forEach>
							  <li class="page-item">
							  	<a class="page-link pn" data-pn="${pager.endNum+1}" aria-label="Next">Next</a>
							  	
							  </li>
							  
							  
							  
							</ul>
							</nav>
						</div>
						</c:if>
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
	<script type="text/javascript" src="/js/board/board_list.js"></script>
	
	
	
</body>
</html>