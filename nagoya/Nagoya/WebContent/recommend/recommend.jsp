<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- content area -->
<div class="contents">
	<div class="product_contents">
		<h2>추천여행지</h2>
		<p>나고야의 관광명소를 소개합니다!</p>
		<div class="line"></div>
		<div class="search_form">
			<form name="search" method="post" action="product.html">
				<select name="sel">
					<option value="제목">제목</option>
					<option value="내용">내용</option>
				</select> <input type="text" name="search_txt" class="se_txt"> <input
					type="submit" value="검색" class="btn_submit">
			</form>
		</div>
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">나고야여행 추천루트데 고자이마스</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rootlist" items="${rootlist}">
					<tr>
						<td>${rootlist.rnum}</td>
						<td class="title"><a href="RecommendRootServlet?command=root_view&num=${rootlist.rnum}">${rootlist.rtitle}</a></td>
						<td>${rootlist.rname}</td>
						<td><fmt:formatDate value="${rootlist.rwritedate}"></fmt:formatDate></td>
						<td>${rootlist.rreadcount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="page">
		<a href=""><< 이전</a> <a href="">1</a> <a href="">2</a> <a href="">3</a>
		<a href="">4</a> <a href="">5</a> <a href="">다음 >></a> <a
			href="RecommendRootServlet?command=root_write_form" class="btn_write">글쓰기</a>
	</div>
</div>
<!-- content end -->
<%@ include file="../footer.jsp"%>