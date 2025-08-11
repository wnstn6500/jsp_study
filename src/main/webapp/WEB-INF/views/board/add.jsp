<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/include/head_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
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
					<div class="row justify-content-center" >
						<div class="col-md-6">
							<form method="post" enctype="multipart/form-data">
								<input type="hidden" name="boardNum" value="${vo.boardNum}">
								<div class="mb-3">
								  <label for="writer" class="form-label">Writer</label>
								  <input type="text" class="form-control" name="boardWriter"
								  	 id="writer" aria-describedby="writerHelp" value="${vo.boardWriter}">
								</div>
								<div class="mb-3">
									 <label for="title" class="form-label">Title</label>
									 <input type="text" class="form-control" name="boardTitle"
									  id="title" aria-describedby="writerHelp" value="${vo.boardTitle}">
								</div>
						
						<div class="mb-3">
						  <label for="contents" class="form-label">Contents</label>
						  <textarea class="form-control" id="contents" rows="9" name="boardContents">${vo.boardContents}</textarea>
						</div>

						<div>
							<button class="btn btn-primary" type="button" id="add">ADD</button>

						</div>

						<div class="mb-4">
							<label for="content">Comments</label>
							<textarea class="form-control"
							placeholder="write your content here!" id="content" 
							style="height: 100px" name="boardContent">${notice.boardContent}</textarea>
						</div>
						
						<div>
							<c:forEach items="${vo.boardFileVOs}" var="f">
								<button class="deleteFile" data-file-num="${f.fileNum}" type="button">${f.oriName}</button>
							</c:forEach>
						</div>
						<div id="result" data-file-count="${vo.boardFileVOs.size()}">
						
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
					</div>
					</div>
				</div>
			</div>
			<!-- End Content -->
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>	
		</div>
		
		
	</div>
	<c:import url="/WEB-INF/views/include/tale.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
	<script src="/js/board/board_add.js"></script>
	<script type="text/javascript">
	$('#contents').summernote({
		callbacks: {
			onImageUpload: (files) => {
				console.log("files: ", files[0]);
				let form = new FormData();
				form.append('bf', files[0]);
				fetch("./boardFile", {
					method: 'POST',
					body: form
				})
				.then(r => r.text())
				.then(r => {
					$("#contents").summernote('editor.insertImage', r);
				})
				.catch(e => console.log(e));
				
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
					if(r){
						alert('삭제 완료')
					} else{
						alert('失敗')
					}
				})
				
			}	
		}
	})
	</script>
</body>
</html>