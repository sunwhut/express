<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>用户登陆</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
<link href="css/login.css" rel="stylesheet" type="text/css"/>
<script language="javascript" src="js/jquery-1.8.0.min.js"></script>
<script language="javascript" src="js/bootstrap.min.js"></script>
<script language="javascript" src="js/bootbox.min.js"></script>
<script language="javascript" src="js/login.js"></script>
</head>

<body>
<div class="main-frame">
	<div>
		<div class="logo"></div>
    	<div class="fly"></div>
        <div class="text"></div>
        <div class="login-frame">
        	<div class="panel panel-default" style="margin:0;">
              <div class="panel-heading"><i class="fa fa-user"></i> 用户登陆</div>
              <div class="panel-body">
 <form action="login.action" method="post">
  <div class="form-group">
    <label for="userName">用户名</label>
    <input type="text" name="userName" class="form-control" required id="userName" placeholder="请输入登陆用户名">
  </div>
  <div class="form-group">
    <label for="userPwd">密码</label>
    <input type="password" class="form-control" id="userPwd" name="userPwd" placeholder="请输入登陆密码">
  </div>
    <div class="form-group">
    <label for="userName">验证码</label>
    <div class="row">
    	<div class="col-md-5"><input type="text" name="checkNumber" class="form-control" required id="userName" placeholder="验证码"></div>
    	<div class="col-md-5"><img src="check.action?a=" style="height:32px; cursor:pointer; border:solid 1px #333;" onClick="this.src=this.src+'0'"></div>
  </div>
  <button style="margin-top:10px;" type="submit" class="btn btn-primary btn-lg btn-block"><i class="fa fa-user"></i> &nbsp;登&nbsp;&nbsp;&nbsp;陆</button>
</form>
              </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
