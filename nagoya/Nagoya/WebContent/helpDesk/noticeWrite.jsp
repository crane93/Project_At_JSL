<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="contents">
	<form name="notice" method="post" action="HelpDeskServlet">
	<input type="hidden" name="command" value="notice_write">
		<h2>공지사항작성</h2>
		<p>모든항목을 빠짐없이 입력하세유</p>
		<table summary="번호, 제목, 내용, 글쓴이, 파일 입니다" class="member_table">
			<caption class="readonly">공지사항 표</caption>
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="ntitle" class="w80"></td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td><input type="text" name="nname" class="w80"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea class="w80 noresize" name="ncontent" id="ir1"></textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="npass" class="w80"></td>
				</tr>
				<tr>
					<td colspan="2" class="txtc">
					<input type="submit" value="저장" id="btn_ok"> &nbsp;&nbsp; <input type="button" value="취소" onclick="location.href=HelpDeskServlet?command=notice_list" id="btn_reset">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<!-- content end -->

<script type="text/javascript">

	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "ir1",
		sSkinURI: "../smarteditor2/SmartEditor2Skin.html",
		fCreator: "createSEditor2"
	});

	</script>
<%@ include file="../footer.jsp"%>