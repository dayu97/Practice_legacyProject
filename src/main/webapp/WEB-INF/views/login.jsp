<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
*        { margin:0; padding: 0; }
body{
         font-family: "���� ���";
         font-size: 0.75em;
         color: #333;
}

#login-form{
         width:200px;
         margin:100px auto;
         border: 1px solid gray;
         border-radius: 5px;
         padding: 15px;
}

/* inline�̿��� ��ҵ��� block���� �ٲ� */
#login-form input, #login-form label{
         display:block;
}

#login-form label{
         margin-top: 10px;
}
#login-form input{
         margin-top: 5px;
}
/* ��Ʈ����Ʈ ������ */

#login-form input[type='image']{
         margin: 20px auto;
         width: 100px;
}

</style>
<title>�α���</title>
</head>
<body>

	<c:choose>
		<c:when test="${!empty sessionScope.login}" >
			<form id="login-form" method="post" >		
			<tr align="center"><td colspan="5" align="center">${sessionScope.login} �� �α��� �Ǿ����ϴ�</td></tr>
				<input type="image" src="resources/logout.png" formaction="logout" name="logout" value="logout"  align="absmiddle">			
			</form>
		</c:when> 
		<c:when test="${empty sessionScope.login}">
			<form id="login-form" method="post" >			
				<label class="legend">���̵�</label>
				<input name="mid" type="text">
				<label class="legend">�н�����</label> 
				<input name="mpw" type="password"> 
				<input type="image" src="resources/login.png" formaction="loginCheck" name="login" value="login"  align="absmiddle">
				<input type="image" src="resources/signup.png" formaction="signup" name="signup" value="signup"  align="absmiddle">			
			</form>
		
		</c:when>
	</c:choose>

    
</body>
</html>