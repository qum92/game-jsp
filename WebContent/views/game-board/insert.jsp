<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/gboard/insert" enctype="multipart-form-data">
	<table border="1">
		<tr>
			<th>게임 이름</th>
			<td><input type="text" name="game_title"></td>
		</tr>
		<tr>
			<th>게임 종류</th>
			<td><input type="text" name="game_type"></td>
		</tr>
		<tr>
			<th>게임 스토리</th>
			<td><input type="text" name="game_story"></td>
		</tr>
		<tr>
			<th>게임 정보</th>
			<td><input type="text" name="game_info"></td>
		</tr>
		<tr>
			<th>게임 사진</th>
			<td><input type="file" name="pb_file_path"></td>
		</tr>
		<tr>
			<td colspan="2"><button>등록하기</button></td>
		</tr>
	</table>
</form>
</body>
</html>