<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/head_css.jsp"%>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">

</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/include/sidebar.jsp"></c:import>

		<!-- Start  -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/include/topbar.jsp"></c:import>
				<div class="container-fluid">
					<!-- page contents 내용 -->
					<div class="row justify-content-center ">
						<div class="col-md-8">
							<form  method="post" enctype="multipart/form-data">
								<div class="mb-3">
									<label for="username" class="form-label">ID</label> 
									<input type="text" class="form-control" name="username"
										id="username" aria-describedby="writerHelp">
								</div>
								<div class="mb-3">
									<label for="password" class="form-label">PASSWORD</label> 
									<input type="password" class="form-control" name="password"
										id="password" aria-describedby="passwordHelp">
								</div>		
								<div class="mb-3">
									<label for="passwordCheck" class="form-label">PASSWORD</label> 
									<input type="password" class="form-control" name="passwordCheck"
										id="passwordCheck" aria-describedby="passwordCheckHelp">
								</div>																
								<div class="mb-3">
									<label for="name" class="form-label">NAME</label> 
									<input type="text" class="form-control" name="name"
										id="name" aria-describedby="nameHelp">
								</div>
								<div class="mb-3">
									<label for="email" class="form-label">EMAIL</label> 
									<input type="email" class="form-control" name="email"
										id="email" aria-describedby="emailHelp">
								</div>		
								<div class="mb-3">
									<label for="phone" class="form-label">PHONE</label> 
									<input type="text" class="form-control" name="phone"
										id="phone" aria-describedby="phoneHelp">
								</div>	
								
								<div>																						<div class="mb-3">
								<label for="birth" class="form-label">BIRTH</label> 
									<input type="date" class="form-control" name="birth"
										id="birth" aria-describedby="birthHelp">
								</div>
								<div>	
								<label for="profile" class="form-label">PROFILE</label> 
									<input type="file" class="form-control" name="profile"
										id="profile">
								</div>									
								

							

								<button type="submit" class="btn btn-primary">Submit</button>
							</form>
						</div>
					</div>

				</div>
			</div>
			<!--  End Content  -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>


	</div>
	<c:import url="/WEB-INF/views/include/tale.jsp"></c:import>
	<script type="text/javascript" src ="/js/board/board_add.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
	<script type="text/javascript">
	$("#contents").summernote({
		callbacks:{
			onImageUpload: function (files) {
				console.log("files: ", files[0]);
				let f = new FormData();
				f.append("bf", files[0])
				
				fetch("./boardFile",{
					method:"POST",
					body:f
				})
				.then(r=>r.text())
				.then(r=>{
					$("#contents").summernote('editor.insertImage', r);
				})
				.catch(e => console.log(e))
				
				;
			},
			onMediaDelete: function(files){
				let f = $(files[0]).attr("src"); // /files/notice/****.jpg
				
				let params = new URLSearchParams();
				params.append("fileName", f);
				fetch("./boardFileDelete", {
					method:"POST",
					body:params
				})
				.then(r=>r.json())
				.then(r=>{
					console.log(r)
				})
				
			}
		}
		
	})
	</script>
</body>
</html>