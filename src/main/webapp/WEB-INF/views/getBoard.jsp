<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<form action="updateBoard" method="post">
	<p>
		<label>제목</label> <input type="text" name="subject" value="${board.subject}">
	</p>

	<p>
		<label>작성자</label> <input type="text" name="writer" size="15" readonly="readonly" value="${board.writer}">
	<p>
		<label>비밀번호</label> <input type="text" name="pwd" size="15" value="${board.pwd}">

	</p>
	<label>내용</label>
	<p>
		<textarea rows="15" cols="65" name="content" >${board.content}</textarea>
	<p>
	
	
	<input name="no" type="hidden" value="${board.no}" />

	<button type="submit" formaction="deleteBoard" formmethod="get">삭제</button>
		<button type="submit">수정</button>
</form>

</body>
</html>