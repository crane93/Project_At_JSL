<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="contents">
	<form name="notice" method="post" action="">
		<h2>공지사항</h2>
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
					<td><input type="text" name="title" class="w80"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea class="w80 noresize" name="ir1" id="ir1"></textarea></td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td><input type="text" name="writer" class="w80"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="purl" class="w80"></td>
				</tr>
				<tr>
					<td colspan="2" class="txtc">
					<input type="button" value="전송" id="btn_ok"> &nbsp;&nbsp; <input type="button" value="취소" onclick="location.href='../index.html'" id="btn_reset">
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