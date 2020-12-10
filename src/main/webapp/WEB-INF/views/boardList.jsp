<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- <script type="text/javascript" src="/scripts.js"></script> -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/JavaScript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript"></script>

<meta charset="UTF-8">
<title>board</title>
</head>
<body>

<h2><a href="BoardList" >board list</a></h2>

	<table>
		<colgroup>
			<col style="width:5%;" />
			<col style="width:5%;" />
			<col style="width:20%;" />
			<col style="width:10%;" />
			<col style="width:25%;" />
			<col style="width:10%;" />
		</colgroup>
		<thead>
			<tr>
				<th></th>
				<th>NO</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성일</th>
			</tr>
				<hr/>
		</thead>
		
		<tbody>
		<form>
			<c:choose>
				<c:when test="${empty boardList }" >
					<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
				</c:when> 
				<c:when test="${!empty boardList}">
					<c:forEach var="list" items="${boardList}">
							<td><input type="checkbox" name="no" value="${list.no}"/></td>
							<td><c:out value="${list.no}"/></td>
							<td><a href="getBoard?no=${list.no}"><c:out value="${list.subject}"/></a></td>
							<td><c:out value="${list.writer}"/></td>
							<td><c:out value="${list.content}"/></td>
							<td><c:out value="${list.regdate}"/></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>

		<hr/>		
		<center/>
		
		
			<c:if test="${!empty sessionScope.search_keyword}">
				<c:forEach var="p" items="${p_num}">
				<input type="submit" formaction="paging" name="page" value="${p}"/>
				</c:forEach>	
			</c:if>
		
			<c:if test="${empty sessionScope.search_keyword}">
				<c:forEach var="p" items="${p_num}">
					<input type="submit" formaction="paging" name="page" value="${p}"/>
				</c:forEach>	
			</c:if>
		<br/>
		
		<br/>

		<button type="submit" formaction="deleteBoard" formmethod="get">삭제</button>
		<button type="submit" formaction="write" formmethod="get">글쓰기</button>

<br/><br/><br/>

	</form>
	
	<form action="boardSearch" method="get">
	<fieldset class="boardSearch">
		<legend>게시물 검색</legend>
		<p>
			<!-- <select id="search_date" name="search_date" 
				<option value="week">일주일</option>
				<option value="month">한달</option>
				<option value="month3">세달</option>
				<option value="all">전체</option>
			</select>  -->
			<select id="search_key" name="search_key" >
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="writer">글쓴이</option>
			</select>
			
			
			<c:if test="${!empty sessionScope.search_keyword}">
			<input id="search_keyword" name="search_keyword" class="inputTypeText" value="${sessionScope.search_keyword}" type="text"> 			
			</c:if>
			
			
			<c:if test="${empty sessionScope.search_keyword}">
			<input id="search_keyword" name="search_keyword" class="inputTypeText" value="" type="text"> 			
			</c:if>
			
		<button type="submit" formaction="boardSearch" >찾기</button>
		</p>
	</fieldset>
	</form>
	
</body>
</html>
