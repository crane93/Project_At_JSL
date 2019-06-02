<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!-- content area -->
	<div class="contents">
		<div class="product_contents">
			<h2>공지사항데스네</h2>
			<p>여행 일정에 따른 루트를 추천해드립니다</p>
			<div class="line"></div>
			<div class="search_form">
				<form method="post" action="HelpDeskServlet?command=notice_list">
				
					<select name="sel">
						<option value="ntitle">제목</option>
						<option value="ncontent">내용</option>
					</select>
					<input type="text" name="search" class="se_txt">
					<input type="submit" value="검색" class="btn_submit">
				</form>
			</div>
		</div>
		<div class="record_group">
			<p>총게시글<span>${totalcount}</span>건</p>
		</div>
		<div class="notice_body">
			<table summary="공지사항표입니다. 번호, 제목, 글쓴이, 날짜, 조회수 항목이 있습니다" style="width:100%">
				<caption class="readonly">공지사항</caption>
				<colgroup>
					<col width="5%">
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="5%">
				</colgroup>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>날짜</th>
				</tr>
				<c:set var="num" value="${totcount - ((nowpage-1) * 10)}"/>
				<c:forEach var="noticelist" items="${noticelist}">
					<tr>
						<td>${noticelist.nnum}</td>
						<td><a href="HelpDeskServlet?command=notice_view&nnum=${noticelist.nnum}">${noticelist.ntitle}</a></td>
						<td>${noticelist.nname}</td>
						<td>${noticelist.nwritedate}</td>
					</tr>
					<c:set var="num" value="${num-1}"/>		
				</c:forEach>
			</table>
		</div>
		
		<div class="page">
			<div>
				${elfunc:pageList(nowpage,totpage,url,addtag)}
			</div>
			<a href="HelpDeskServlet?command=notice_write_form" class="btn_write">글쓰기</a>
		</div>
		
	</div>
		<!-- content end -->
<%@ include file="../footer.jsp" %>