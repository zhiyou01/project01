<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <meta name="author" content="张育伟">
    

    <link rel="stylesheet" href="http://localhost:8080/VideoProject/css/base.css">
    <link rel="stylesheet" href="http://localhost:8080/VideoProject/css/profile.css">
    <link rel="icon" href="http://localhost:8080/VideoProject/projectimg/favicon.png" type="image/png">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>

<body>


<header>
	<div class="container top_bar clearfix">
		<img src="http://localhost:8080/VideoProject/projectimg/logo.png">
		<div id="tele">
			<span>4006-371-555</span>
			<span>0371-88888598</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="http://localhost:8080/VideoProject/index.jsp">首页</a></li>
				<li class="menu_active">个人中心</a></li>
			</ul>
			
			<div id="user_bar">
				<!-- 点击头像跳到头像修改界面 -->
				
				<c:if test="${!empty user.imgurl }">
					<a href="updatephoto?id=${user.id}">
					<!-- 检查一下有没有头像，没有头像给默认的图片 -->
					<img id="avatar" src="${user.imgurl}" alt="${user.accounts}" width="30px;">
					</a>
				</c:if>
				
				<c:if test="${empty user.imgurl }">
					<a href="updatephoto?id=${user.id}">
					<!-- 检查一下有没有头像，没有头像给默认的图片 -->
					<img id="avatar" src="http://localhost:8080/VideoProject/projectimg/avatar_lg.png"  width="30px;">
					</a>
				</c:if>
				<!-- 退出当前界面到主界面 -->
				<a href="http://localhost:8080/VideoProject/index.jsp" id="lay_out">退出</a>
			</div>
		</div>
	</menu>
</header>
    <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                
                    <li><a href="updatedata?id=${user.id}">更改资料</a></li>
                    
                    <li class="profile_tab_line">|</li>
                    
                    <li><a href="updatephoto?id=${user.id}">更改头像</a></li>
                    
                    <li class="profile_tab_line">|</li>
                    
                    <li><a href="updatepwd?id=${user.id}">密码安全</a></li>
                    
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
		                  <c:if test="${!empty user.imgurl }">
								<img id="avatar" src="${user.imgurl}" alt="图片走丢了" width="150px;">
						  </c:if>
						  <c:if test="${empty user.imgurl }">
							 <img id="avatar" width="150px;" src="http://localhost:8080/VideoProject/projectimg/avatar_lg.png" alt="">
		                  </c:if>            
		                  <p>欢迎回来！</p>
                        </div>
                        <ul class="profile_ifo_area">
                            <li><span class="dd">昵　称：</span>${user.nickname}</li>
                            <li><span class="dd">性　别：</span>${user.sex}</li>
                            <li><span class="dd">生　日：</span>${user.birthday}</li>
                            <li><span class="dd">邮　箱：</span>${user.accounts}</li>
                            <li><span class="dd">所在地：</span>${user.address}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <div class="container">
            <ul>
                <li><img src="http://localhost:8080/VideoProject/projectimg/footer_logo.png" alt="" id="foot_logo"></li>
                <li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
                <li><img src="http://localhost:8080/VideoProject/projectimg/a.png" alt="" id="wxgzh"></li>
            </ul>
        </div>
    </footer>
</body>
</html>