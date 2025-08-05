<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
					<h1>product form</h1>
					<form method="post">
						<%-- <input type="hidden" name="boardNum" value="${vo.boardNum}"> --%>
						<div class="mb-3">
							<label for="name" class="form-label">상품명</label> <input
								type="text" class="form-control" name="productName" id="name"
								aria-describedby="writerHelp">
						</div>
						<div class="mb-3">
							<label for="date" class="form-label">날짜</label> <input
								type="date" class="form-control" name="productDate" id="date"
								aria-describedby="writerHelp">
						</div>
	
						<div class="mb-3">
							<label for="contents" class="form-label">상세내용</label>
							<textarea class="form-control" id="contents" rows="9"
								name="productContents"></textarea>
						</div>
						<div class="mb-3">
							<label for="rate" class="form-label">이율</label> <input
								type="number" step="0.01" class="form-control" name="productRate" id="rate"
								aria-describedby="writerHelp">
						</div>
						<div>
						
						</div>
	
						<button type="submit" class="btn btn-primary">등록하기</button>
	
					</form>
	
	
	
				</div>
			</div>
			<!-- End Content -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
	
	
	</div>
	<c:import url="/WEB-INF/views/include/tale.jsp"></c:import>

</body>
</html>