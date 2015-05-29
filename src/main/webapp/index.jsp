<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>系统说明</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
</head>
<body style="width: 900px; margin: 10px auto;">
<div class="panel panel-primary">
              <div class="panel-heading"><i class="fa fa-globe"></i> 系统相关说明</div>
              <div class="panel-body">
 <pre><b>关于系统安装</b>
	1.使用提供的whlg01.sql，在mysql数据库中创建数据库并还原
	2.使用提供的express.war文件，拷贝到tomcat的webapps中
	3.启动tomcat，并修改WEB-INF/classes/config.properties中关于数据库的设置
	4.重新启动tomcat，使用http://localhost:8080/express访问项目
<b>关于系统账户</b>
	超级管理员：admin 密码:admin
	其他测试账户：user01 - user99 密码:123
	为开发方便，系统默认为admin已经登陆，正式运行修改修改 MyInterceptor 70行左右的代码
<b>可以演示功能：</b>
	用户登陆系统，用户退出系统，修改个人密码，登陆用户的信息显示，不同角色的菜单控制
	后台管理：
		会员注册管理[分页列表 搜索 添加新用户 修改用户信息 删除用户 重置用户密码]
	只完成了基本界面的：
		修改个人资料，网上下单[订单录入，订单确认]
	
</pre>
              <div style="text-align: center; padding: 10px;"><a target="admin" href="login.html" class="btn btn-danger btn-lg"><i class="fa fa-sign-out"></i> 进入系统</a></div>
	</div>
</div>
<div class="panel panel-primary">
              <div class="panel-heading"><i class="fa fa-gear"></i> 系统基本信息</div>
              <div class="panel-body">
<pre>
站点物理路径:<%=request.getSession().getServletContext().getRealPath("/") %>
class存放路径:<%=this.getClass().getResource("/") %>
临时路径:<%=request.getSession().getServletContext().getAttribute("javax.servlet.context.tempdir") %>
</pre>
		<div style="text-align: center; padding: 10px;"><a href="druid" class="btn btn-default btn-lg"><i class="fa fa-cog"></i> 其他情况</a></div>
	</div>
</div>
</body>
</html>
