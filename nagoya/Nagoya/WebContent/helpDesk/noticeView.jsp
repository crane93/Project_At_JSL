<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<!-- content area -->
<div class="contents">
	<div class="bbs_view">
		<h2>${noticelist.ntitle}</h2>
		<span>${noticelist.nname}</span>
		<span>${noticelist.nwritedate}</span>
		<p>${noticelist.ncontent}</p>
	</div>
	<div class="btn_view">
		<a href=""><< 이전글</a> 
		<a href="HelpDeskServlet?command=notice_modify&nnum=${noticelist.nnum}">수정</a> 
		<a href="HelpDeskServlet?command=notice_delete&nnum=${noticelist.nnum}" onClick="return confirm('삭제할거임?')">삭제</a> 
		<a href="HelpDeskServlet?command=notice_list">목록</a> 
		<a href="">다음글 >></a>
	</div>
</div>
<!-- content end -->
<%@ include file="../footer.jsp"%>