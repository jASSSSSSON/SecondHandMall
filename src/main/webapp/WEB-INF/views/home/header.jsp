<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#" style="font-size: 25px">校园二手交易平台</a>
		</div>
		
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<c:choose>
					<c:when test="${sessionScope.user != null}">
						<li><a href="<c:url value="/"/>">首页</a></li>
						<li><a target="_blank"
							href="<c:url value="/user/userProfile"/>">我的</a></li>
						<li><a target="_blank"
							href="<c:url value="/goods/publishGood" />">发布</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<c:url value="/"/>">首页</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${sessionScope.user != null}">
						<li >
							<a href="<c:url value="/user/userProfile"/>" style="padding: 0; margin:0;">
								<img id="userIcon" style="width: 40px;  margin-top: 5px; margin-right: 10px;" src="${basePath}/${sessionScope.user.photoUrl}" class="img-circle" alt="icon" >
							</a>
						</li>
						<li><a href="${basePath}/comm/chat"><span class="glyphicon glyphicon-envelope visible-lg"></span></a></li>
						<li><a href="<c:url value="/logout?logout=true"/>">退出</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<c:url value="/login" />">登录</a></li>
						<li><a href="<c:url value="/register" />">注册</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>

<div class="col-md-12" style="height: 70px">
</div>