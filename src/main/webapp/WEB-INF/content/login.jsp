<%@ page language="java" contentType="text/html; charset=UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<title>登陆的结果</title>
</head>
<body style="margin-top: 150px; font-size:36px; text-align: center;">
登陆成功<br/>
${LOGIN_USER_SESSION_KEY.userName }<br/>
${LOGIN_USER_SESSION_KEY.userRealName }<br/>
${LOGIN_USER_SESSION_KEY.userTypeName }<br/>
</body>
</html>