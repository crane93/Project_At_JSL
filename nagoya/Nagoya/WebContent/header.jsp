<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="elfunc" uri="..//WEB-INF/tlds/el-functions.tld" %>
<!doctype html>
<html>
	<head>
	    <title>TripToNagoya</title>
	    <meta charset="utf-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	    <link href="css/common.css" rel="stylesheet">
	    <link href="css/jangsu.css" rel="stylesheet">
	    <link href="css/jquery.bxslider.css" rel="stylesheet">
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
	                <li><a href="../intro/intro.html">나고야소개</a>
	                    <ul class="depth2">
	                        <li><a href="../intro/abtNagoya.jsp">나고야에 대하여</a></li>
	                    </ul>
	                </li>
	                <li><a href="#">추천관광지</a>
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