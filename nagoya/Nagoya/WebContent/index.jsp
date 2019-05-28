<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!doctype html>
<html>
	<head>
	    <title>TripToNagoya</title>
	    <meta charset="utf-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	    <link href="css/common.css" rel="stylesheet">
	    <link href="css/jangsu.css" rel="stylesheet">
	    <link href="css/jquery.bxslider.css" rel="stylesheet">
	    <script src="js/jquery-3.3.1.min.js"></script>
	    <script src="js/jquery.bxslider.js"></script>
	    <script src="js/script.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	    
	</head>
	<div class="hb">
	    <div class="w1200">
	        <div class="h80">
	            <ul class="side">
	                <li><a href="https://www.nagoya-info.jp/view/">사이트맵</a></li>
	                <li><a href="#">전체메뉴</a></li>
	            </ul>
	        </div>
	    </div>
	</div>
	
	<div class="header">
	    <header>
	        <h1 class="logo"><a href="index.jsp">Nagoya</a></h1>
	        <nav id="nav">
	            <ul class="depth1">
	                <li><a href="intro/intro.html">나고야소개</a>
	                    <ul class="depth2">
	                        <li><a href="intro/abtNagoya.jsp">나고야에 대하여</a></li>
	                    </ul>
	                </li>
	                <li><a href="../recommend/recommend.jsp">추천관광지</a>
	                	<ul class="depth2">
	                        <li><a href="RecommendRootServlet?command=root_list">おすすめのルート</a></li>
	                        <li><a href="GurumeServlet?command=gurume_list">おすすめのグルメ</a></li>
	                    </ul>
	                </li>       
	                <li><a href="#">여행도우미</a>
	                    <ul class="depth2">
	                        <li><a href="HelpDeskServlet?command=notice_list">공지사항</a></li>
	                    </ul>
	                </li>
	            </ul>
	        </nav>
	    </header>
	</div>
	<div class="bxslider">
		<div>
			<img src="images/main1.png" class="w100">
		</div>
		<div>
			<img src="images/main2.png" class="w100">
		</div>
		<div>
			<img src="images/main3.png" class="w100">
		</div>
	</div>
	<section class="news_group">
		<div class="news_tit">
			<p class="sub_tit">名古屋グルメ</p>
			<h2>나고야食べ物</h2>
			<p class="text">나고야의 음식을 소개해드립니다</p>
			<a href="GurumeServlet?command=gurume_list" class="btn-border">READ MORE</a>
		</div>
		<ul class="news_list">
			<c:forEach var="gurumelist" items="${gurumelist}">
				<li>
					<a href="GurumeServlet?command=gurume_view&gnum=${gurumelist.gnum}">
						<img src="upload/${gurumelist.gimgurl}" alt="${gurumelist.gtitle}" class="w100">
						<strong>${gurumelist.gtitle}</strong>
						<p>${gurumelist.gcontent}</p>
						
					</a>
				</li>
			</c:forEach>	
		</ul>
	</section>
	<section class="tab-cont">
		<h2 class="readonly">탭 메뉴</h2>
		<div class="inner">
			<ul class="tab-style">
				<li class="active">
					<ul class="inner-tab">
						<li><a href="#"></a>
								<p class="p1">공지사항</p>
								<c:forEach var="noticeLastest5" items="${noticelist}" varStatus="status">		<!-- 책 364페이지,  -->						
									<c:choose>
										<c:when test="${status.first}">
											<p class="p2"><a href="HelpDeskServlet?command=notice_view&nnum=${noticeLastest5.nnum}">${noticeLastest5.ntitle}</a></p>
											<span class="date">${noticeLastest5.nwritedate}</span>
												<p class="text">${noticeLastest5.ncontent}</p>			
										</c:when>
										<c:otherwise>
											<li><a href="HelpDeskServlet?command=notice_view&nnum=${noticeLastest5.nnum}">${noticeLastest5.ntitle}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</li>
					</ul>
				</li>
				<li class="last"></li>
			</ul>
		</div>
	</section>

	<script>
			$(document).ready(function(){
				$(".tab-style>li>a").click(function(){})
			})
		</script>
	<div class="wrap-body">
		<div class="wrap-list">
			<ul>
				<li class="notice-title">
					<p class="txt20">나고야명물</p>
					<p class="txt40">히쯔마부시</p>
					<!-- <p class="txt17">JSL</p> -->
				</li>
				<li class="notice1">
					<p class="txt20">나고야명물</p>
					<p class="txt40">미소카츠</p>
				</li>
				<li class="notice2">
					<p class="txt20">나고야명소</p>
					<p class="txt40">과학관</p>
				</li>
				<li class="notice3">
					<p class="txt20">나고야명소</p>
					<p class="txt40">사카에</p>
				</li>
			</ul>
		</div>
	</div>
<%@ include file="footer.jsp" %>
