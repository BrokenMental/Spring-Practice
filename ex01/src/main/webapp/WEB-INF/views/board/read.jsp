<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
<div class="row">
	<!--  left column -->
	<div class="col-md-12">
		<!--  general form elements -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">READ PAGE</h3>
				<form role="form" method="post">
					<input type='hidden' name='bno' value="${boardVO.bno}">
				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='title' class="form-control" value="${boardVO.title }"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${boardVO.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="writer " class="form-control" value="${boardVO.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="submit" class="btn btn-warning">Modify</button>
					<button type="submit" class="btn btn-danger">REMOVE</button>
					<button type="submit" class="btn btn-primary">LIST ALL</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /.col (left) -->
</div>
<!--  /.row --> </section>
<div style="bottom: 0px;">
	<%@ include file="../include/footer.jsp"%>
</div>
<!-- /.content -->

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[role='form']"); // formObj는 아래에 나오는 form태그를 의미한다.

		console.log(formObj);

		$(".btn-wrning").on("click", function() {
			formObj.attr("action", "/board/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-danger").on("click", function() {
			formObj.attr("action", "/board/remove");
			formObj.submit();
		});

		$(".btn-primary").on("click", function() {
			self.location = "/board/listAll";
		});

	});
</script>