<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	

<!-- content area -->
	<div class="contents">
		<div class="product_contents">
			<h2>おすすめのグルメ</h2>
			<p>꿀맛!</p>
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
			<ul>
				<li>
					<a href="product_view.html">
						<img src="../images/box1.jpg" alt="상품명" class="w100">
						<span class="pro_title">오이시이데스!</span>
						<span class="pro_cont">벌써 몇 주동안 사람들이 입소문에 의해 편의점과 슈퍼마켓에 진통 아닌 ...</span>
					</a>
				</li>
			</ul>
		</div>
		<div class="page">
			<a href=""><< 이전</a> <a href="">1</a> <a href="">2</a> <a href="">3</a> <a href="">4</a> <a href="">5</a> <a href="">다음 >></a>
			<a href="product_write.html" class="btn_write">글쓰기</a>
		</div>
	</div>
<!-- content end -->

	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});

		$(".gallery_wrap > ul > li > a").on("click",function(e) {
			e.preventDefault();												/*임시링크(href="")가 있을 때 그 임시링크를 클릭해도 스크롤바가 위로 안가게 해줌*/
			var image = $(this).children().attr('src');						/*작은사진의 경로가 image에 저장됨/   this:.gallery_wrap > ul > li > a*/
			//var gogo = $(this).next().children().attr("href");			/*(this).next():.gallery_wrap > ul > li > a의 다음요소 */
			var noajax = $(this).next().children('#okval').attr('class');	/*경로의 결과 ${photolist.num}가 noajax로 저장된다*/
			
			$.ajax ({									//ajax: 비동기식으로 처리하는 방법, 조회수증가하고 작은사진이 큰사진으로 보임
				type:"post",							//데이터 전송방식: post
				dataType:"json",
				url:'photocount.do',					/*비동기식으로 처리되는 프로그램*/
				data: {no:noajax},			
				async:false,							
				success:function(data) {				//성공하면 처리된 결과값을 data에 담아서...
					alert("ajaxa mondainai");
					addCount = data.like;				
					$("#okayval"+"."+noajax).html(addCount);
				},
				error:function(request,status,error) {
					alert("ajax fail");
				}
			});
						
			$(".img-res").attr("src",image);
			$(".modal").fadeIn(1000);
				
			});

		$(".modal .modal_content > a").on("click", function(e) {
			e.preventDefault();
			$(".modal").fadeOut(1000);
		});

		});
	</script>
<%@ include file="../footer.jsp"%>