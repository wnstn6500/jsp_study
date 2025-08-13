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
					<h1>product Detail</h1>
					<h2>Name : ${vo.productName}</h2>
					<h2>Contents : ${vo.productContents}</h2>
					<h2>Rate : ${vo.productRate}</h2>
					<h2>Kind : ${vo.kindNum}</h2>
					<h2>kindName : ${vo.productKindVO.kindName}</h2>
				
				<div>
				<form action="./delete" method="post">
							<input type="hidden" name="productNum" value="${productNum.productNum}">
							<a class="btn btn-success" href="./update?productNum=${vo.productNum}">Update</a>
						<button class="btn btn-danger" data-kind="d">Delete</button>
						</form>
						
						<button class="btn btn-primary cart" data-product-num="${vo.productNum}">장바구니</button>
				
				
					</div>
				</div>
			</div>
			<!-- End Content -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>	
		</div>
		
		
	</div>
	<c:import url="/WEB-INF/views/include/tale.jsp"></c:import>
	<script type="text/javascript" src="/js/product/product_detail.js"></script>
</body>
</html>