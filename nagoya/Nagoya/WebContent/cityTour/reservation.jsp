<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>-
<!-- content area -->
	<div class="contents">
		<div class="product_contents">
			<h2>예약일정 및 현황</h2>
			<p>여행 일정에 따른 루트를 추천해드립니다</p>
			<div class="line"></div>
			<div class="search_form">
				<form name="search" method="post" action="product.html">
					<select name="sel">
						<option value="제목">제목</option>
						<option value="내용">내용</option>
					</select>
					<input type="text" name="search_txt" class="se_txt">
					<input type="submit" value="검색" class="btn_submit">
				</form>
			</div>
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
					<th>조회수</th>
				</tr>
				<tr>
					<td>10</td>
					<td><a href="notice_view.html">2박 3일일정</a></td>
					<td>I♡NAGOYA</td>
					<td>2019-03-19</td>
					<td>112</td>
				</tr>
				<tr>
					<td>10</td>
					<td><a href="notice_view.html">3박 4일일정</a></td>
					<td>I♡NAGOYA</td>
					<td>2019-03-19</td>
					<td>112</td>
				</tr>
				<tr>
					<td>10</td>
					<td><a href="notice_view.html">평생일정</a></td>
					<td>I♡NAGOYA</td>
					<td>2019-03-19</td>
					<td>112</td>
				</tr>
			</table>
		</div>
		
		<div class="page">
			<a href=""><< 이전</a> <a href="">1</a> <a href="">2</a> <a href="">3</a> <a href="">4</a> <a href="">5</a> <a href="">다음 >></a>
			<a href="notice_write.html" class="btn_write">글쓰기</a>
		</div>
	</div>
		<!-- content end -->
<%@ include file="../footer.jsp" %>-