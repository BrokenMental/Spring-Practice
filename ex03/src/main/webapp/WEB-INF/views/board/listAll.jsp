<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
</script>

<%@ include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
<div class="row">
	<!--  left column -->
	<div class="col-md-12">
		<!--  general form elements -->
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">LIST ALL PAGE</h3>
				<table class="table table-bordered">
					<tr>
						<th style="width: 10px">BNO</th>
						<th>TITLE</th>
						<th>WRITTER</th>
						<th>REGDATE</th>
						<th style="width: 40px">VIEWCNT</th>
					</tr>

					<c:forEach items="${list}" var="boardVO">

						<tr>
							<td>${boardVO.bno}</td>
							<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
							<!-- jsp의  %=와 동일한 역할을 한다. -->
							<td>${boardVO.writer}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${boardVO.regdate}" /></td>
							<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
						</tr>
					</c:forEach>
				</table>
				<div class="text-center">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li><a href="listPage?page=${pageMaker.startPage -1} }">&laquo;</a></li>
						</c:if>

						<c:forEach begin="${pageMaker.startPage}"
							end="${pageMaker.endPage }" var="idx">
							<li><c:out
									value="${pageMaker.cri.page == idx?'class = active':''}" />> <a
								href="listPage?page=${idx}">${idx}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a href="listPage?page=${pageMaker.endPage +1}">&raquo;</a></li>
						</c:if>
					</ul>
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