<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div class="contents">
	<form name="root" method="post" action="RecommendRootServlet?command=root_update&rnum=${vo.rnum}" enctype="multipart/form-data" onsubmit="return check()">		<!-- 책 526페이지 -->
		<!--  <input type="hidden" name="rnum" value="${vo.rnum}"> -->
		<h2>추천루트글쓰기</h2>
		<p>필수 입력란은 반드시 입력하셔야 합니다</p>
		<table summary="번호, 제목, 내용, 글쓴이, 파일 입니다" class="member_table">
			<caption class="readonly">공지사항 표</caption>
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="rtitle" class="w80" value="${vo.rtitle}"></td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td><input type="text" name="rname" class="w80" value="${vo.rname}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea class="w80 noresize" name="rcontent" id="ir1">${vo.rcontent}</textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
					<input type="file" name="rimgurl" class="w80">&nbsp;&nbsp;&nbsp;<img src="upload/${vo.rimgurl}" style="width:30px; height:30px; vertical-align:middle;">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="rpass" class="w80"></td>
				</tr>
				<tr>
					<td colspan="2" class="txtc">
					<input type="submit" value="저장" class="btn_ok">
					<input type="reset" value="재작성" class="btn_reset">
					<input type="button" value="목록" onclick="location.href='RecommendRootServlet?command=root_list'">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<!-- content end -->
	<script>
		function check() {
			if(root.rname.value=="") {
				alert("글쓴이 입력");
				root.rname.focus();
				return false;
			}
			if(root.rtitle.value=="") {
				alert("제목을 입력");
				root.rtitle.focus();
				return false;
			}
			if(root.rcontent.value=="") {
				alert("내용을 입력");
				root.rcontent.focus();
				return false;
			}
			if(root.rimgurl.value=="") {
				alert("파일을 올리쇼");
				return false;
			}
			if(root.rpass.value=="") {
				alert("비밀번호 입력하시오");
				root.rpass.focus();
				return false;
			}
			return true;
		}
	</script>
	<script>
		alert('${message}');
	</script>
	<script type="text/javascript">

	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "ir1",
		sSkinURI: "../smarteditor2/SmartEditor2Skin.html",
		fCreator: "createSEditor2"
	});

	</script>
<%@ include file="../footer.jsp" %>