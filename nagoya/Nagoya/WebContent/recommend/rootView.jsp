<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<!-- content area -->
<div class="contents">
	<div class="bbs_view">
		<h2>${rootvo.rtitle}</h2>
		<span>${rootvo.rname}</span>
		<span>${rootvo.rwritedate}</span>
		<span>${rootvo.rreadcount}</span>
		<img src="upload/${rootvo.rimgurl}" alt="">
		<p>${rootvo.rcontent}</p>
	</div>
	<div class="btn_view">
		<a href=""><< 이전글</a> 
		<a href="RecommendRootServlet?command=root_modify&rnum=${rootvo.rnum}">수정</a> 
		<a href="RecommendRootServlet?command=root_delete&rnum=${rootvo.rnum}" onClick="return confirm('삭제할거임?')">삭제</a> 
		<a href="RecommendRootServlet?command=root_list">목록</a> 
		<a href="">다음글 >></a>
	</div>
</div>
<!-- content end -->
<%@ include file="../footer.jsp"%>