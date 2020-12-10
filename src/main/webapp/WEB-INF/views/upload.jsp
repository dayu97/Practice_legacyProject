<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
</head>
<body>


<form method="post" action="image_save" enctype="multipart/form-data">

         <label>파일:</label>
         <input type="file" name="file">

         <br><br>
         
         

         <input type="submit" value="image_save">

</form>


</body>
</html>