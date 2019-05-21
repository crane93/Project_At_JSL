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
	                        <li><a href="intro/history.jsp">역사</a></li>
	                        <li><a href="intro/location.jsp">위치</a></li>
	                    </ul>
	                </li>
	                <li><a href="../recommend/recommend.jsp">추천관광지</a>
	                	<ul class="depth2">
	                        <li><a href="recommend/recommend.jsp">관광지소개</a></li>
	                        <li><a href="RecommendRootServlet?command=root_list">おすすめのルート</a></li>
	                        <li><a href="recommend/gurume.jsp">おすすめのグルメ</a></li>
	                    </ul>
	                </li>    
	                <li><a href="../cityTour/cityTour.html">시티투어</a>
	                	<ul class="depth2">
	                        <li><a href="cityTour/courseIntro.jsp">코스소개</a></li>
	                        <li><a href="cityTour/reservation.jsp">예약 및 현황</a></li>
	                    </ul>
	                </li>    
	                <li><a href="#">여행도우미</a>
	                    <ul class="depth2">
	                        <li><a href="helpDesk/notice.jsp">공지사항</a></li>
	                        <li><a href="helpDesk/guide.jsp">관광안내</a></li>
	                        <li><a href="helpDesk/explain.jsp">문화관광해설 신청</a></li>
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
	<section class="tab-cont">
		<h2 class="readonly">탭 메뉴</h2>
		<div class="inner">
			<ul class="tab-style">
				<li class="active"><a href="javascript:void(0);">공지사항</a>
					<ul class="inner-tab">
						<li><a href="#">
								<p class="p1">하이라이트 뉴스입니다</p>
								<p class="p2">하이라이트 뉴스는 언제 제일 빠른 정보를 전달합니다</p>
						</a> <span>2019. <span class="date">03.25</span>
						</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
					</ul></li>
				<li class="active"><a href="javascript:void(0);">제품안내</a>
					<ul class="inner-tab">
						<li><a href="#">
								<p class="p1">하이라이트 뉴스입니다</p>
								<p class="p2">하이라이트 뉴스는 언제 제일 빠른 정보를 전달합니다</p>
						</a> <span>2019. <span class="date">03.25</span>
						</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
					</ul></li>
				<li class="active"><a href="javascript:void(0);">제품안내</a>
					<ul class="inner-tab">
						<li><a href="#">
								<p class="p1">하이라이트 뉴스입니다</p>
								<p class="p2">하이라이트 뉴스는 언제 제일 빠른 정보를 전달합니다</p>
						</a> <span>2019. <span class="date">03.25</span>
						</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
						<li><a href="#">경제뉴스 취재를 하다</a><span>2019.03.24</span></li>
					</ul></li>
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
					<p class="txt20">내 인생을 새롭게 하자</p>
					<p class="txt40">[일본취업]</p>
					<p class="txt17">JSL</p>
				</li>
				<li class="notice1"></li>
				<li class="notice2"></li>
				<li class="notice3"></li>
			</ul>
		</div>
	</div>
<%@ include file="footer.jsp" %>
