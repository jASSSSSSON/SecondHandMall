<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/3/23
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset=UTF-8">
    <title>Chat</title>
    <c:set var="basePath" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/statics/css/comm/chat.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/statics/bootstrap-3.3.0/css/bootstrap.min.css"/>
</head>
<body>
<!-- 导航栏 -->
<div>
    <jsp:include page="../home/header.jsp" />
</div>

<div>
    <!-- 会话列表 -->
    <div class="col-xs-3 row my-1" style="margin-left: 20px;">
        <div class="list-group sessionGroup">
            <a id="recentSession" class="list-group-item">最近会话</a>
            <%--@elvariable id="userMsg" type="java.util.Map"--%>
            <c:forEach items="${userMsg}" var="userM" varStatus="status">
                <c:set var="sessionUser" value="${userM.key}" />
                <a class="list-group-item session" onclick="startSession(${sessionUser.id})">
                    <img id="chatUserIcon${sessionUser.id}" src="${basePath}/${sessionUser.photoUrl}" class="img-circle sessionIcon" alt="icon"/>
                    <span id="unreadNum${sessionUser.id}" class="badge" style="background-color: #FF0000;"><c:if test="${userM.value>0}">${userM.value}</c:if></span>
                    <b id="chatUserName${sessionUser.id}">${sessionUser.name}</b><br>
                    <div id="sessionTime${sessionUser.id}" class="sessionTime">
                        <fmt:formatDate value="${requestScope.sessions[status.index].time}" pattern="MM-dd HH:mm:ss"/>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
    <!-- 会话区块 -->
    <div class="col-sm-8 col-xs-9 row my-1">
        <ul class="list-group my-1">
            <li id="chatUserName" class="list-group-item text-center">[${requestScope.chatUser.name}]</li>
            <li class="list-group-item">
                <!-- 消息容器 -->
                <div class="messageBox" id="messageBox">
                    <div class="text-center">
                        <c:if test="${requestScope.chatUser != null}">
                            <a onclick="queryMsgEx()">
                                <span class="glyphicon glyphicon-time"></span>
                                查看更多消息
                            </a>
                        </c:if>
                    </div>
                </div>
            </li>
            <li class="list-group-item">
                <div class="inputBox">
                    <!-- 表情图片输入区 -->
                    <a id="emoji" class="emojiTrigger" type="a" title="EMOJI <div class='glyphicon glyphicon-remove emojiRemove' onclick='popover()'></div>"
                       data-container="body" data-toggle="popover" data-placement="top"
                       data-content="<div class='emojiContainer'>
                                              <a onclick='addEmoji(this)'>😀</a><a onclick='addEmoji(this)'>😁</a><a onclick='addEmoji(this)'>😂</a><a onclick='addEmoji(this)'>😃</a><a onclick='addEmoji(this)'>😄</a><a onclick='addEmoji(this)'>😅</a><a onclick='addEmoji(this)'>😆</a><a onclick='addEmoji(this)'>😉</a><a onclick='addEmoji(this)'>😊</a><a onclick='addEmoji(this)'>😋</a><a onclick='addEmoji(this)'>😎</a><a onclick='addEmoji(this)'>😍</a><a onclick='addEmoji(this)'>😘</a><a onclick='addEmoji(this)'>😗</a><a onclick='addEmoji(this)'>😙</a><a onclick='addEmoji(this)'>😚</a><a onclick='addEmoji(this)'>😇</a><a onclick='addEmoji(this)'>😐</a><a onclick='addEmoji(this)'>😑</a><a onclick='addEmoji(this)'>😶</a><a onclick='addEmoji(this)'>😏</a><a onclick='addEmoji(this)'>😣</a><a onclick='addEmoji(this)'>😥</a><a onclick='addEmoji(this)'>😮</a><a onclick='addEmoji(this)'>😯</a><a onclick='addEmoji(this)'>😪</a><a onclick='addEmoji(this)'>😫</a><a onclick='addEmoji(this)'>😴</a><a onclick='addEmoji(this)'>😌</a><a onclick='addEmoji(this)'>😛</a><a onclick='addEmoji(this)'>😜</a><a onclick='addEmoji(this)'>😝</a><a onclick='addEmoji(this)'>😒</a><a onclick='addEmoji(this)'>😓</a><a onclick='addEmoji(this)'>😔</a><a onclick='addEmoji(this)'>😕</a><a onclick='addEmoji(this)'>😲</a><a onclick='addEmoji(this)'>😷</a><a onclick='addEmoji(this)'>😖</a><a onclick='addEmoji(this)'>😞</a><a onclick='addEmoji(this)'>😟</a><a onclick='addEmoji(this)'>😤</a><a onclick='addEmoji(this)'>😢</a><a onclick='addEmoji(this)'>😭</a><a onclick='addEmoji(this)'>😦</a><a onclick='addEmoji(this)'>😧</a><a onclick='addEmoji(this)'>😨</a><a onclick='addEmoji(this)'>😬</a><a onclick='addEmoji(this)'>😰</a><a onclick='addEmoji(this)'>😱</a><a onclick='addEmoji(this)'>😳</a><a onclick='addEmoji(this)'>😵</a><a onclick='addEmoji(this)'>😡</a><a onclick='addEmoji(this)'>😠</a><a onclick='addEmoji(this)'>😈</a><a onclick='addEmoji(this)'>👿</a><a onclick='addEmoji(this)'>👹</a><a onclick='addEmoji(this)'>👺</a><a onclick='addEmoji(this)'>💀</a><a onclick='addEmoji(this)'>👻</a><a onclick='addEmoji(this)'>👽</a><a onclick='addEmoji(this)'>👦</a><a onclick='addEmoji(this)'>👧</a><a onclick='addEmoji(this)'>👨</a><a onclick='addEmoji(this)'>👩</a><a onclick='addEmoji(this)'>👴</a><a onclick='addEmoji(this)'>👵</a><a onclick='addEmoji(this)'>👶</a><a onclick='addEmoji(this)'>👱</a><a onclick='addEmoji(this)'>👮</a><a onclick='addEmoji(this)'>👲</a><a onclick='addEmoji(this)'>👳</a><a onclick='addEmoji(this)'>👷</a><a onclick='addEmoji(this)'>👸</a><a onclick='addEmoji(this)'>💂</a><a onclick='addEmoji(this)'>🎅</a><a onclick='addEmoji(this)'>👰</a><a onclick='addEmoji(this)'>👼</a><a onclick='addEmoji(this)'>💆</a><a onclick='addEmoji(this)'>💇</a><a onclick='addEmoji(this)'>🙍</a><a onclick='addEmoji(this)'>🙎</a><a onclick='addEmoji(this)'>🙅</a><a onclick='addEmoji(this)'>🙆</a><a onclick='addEmoji(this)'>💁</a><a onclick='addEmoji(this)'>🙋</a><a onclick='addEmoji(this)'>🙇</a><a onclick='addEmoji(this)'>🙌</a><a onclick='addEmoji(this)'>🙏</a>
                                          </div>">
                        😀
                    </a>
                    <a id="emojiTrigger" class="emojiTrigger" onclick="imageUp()">🖼️</a>
                    <input id="imageLoader" type="file" style="display: none;" onchange="loadImage()" />
                    <br id="messageInput">
                    <!-- 消息输入框 -->
                    <c:if test="${requestScope.chatUser != null}">
                        <div id="textMsg"  class="col-xs-11 msgInput" contenteditable="true">
                        </div>
                        <button class="btn btn-default col-md-1 sendButton" onclick="send()">发送</button>
                    </c:if>
                    <input type="hidden" id="userId" value="${sessionScope.user.id}">
                    <input type="hidden" id="userIcon" value="${sessionScope.user.photoUrl}">
                    <input type="hidden" id="chatUserId" value="${requestScope.chatUser.id}">
                    <input type="hidden" id="chatUserIcon" value="${basePath}/${requestScope.chatUser.photoUrl}">
                </div>
            </li>
        </ul>
    </div>
</div>
</body>

<script type="text/javascript" src="${basePath}/statics/js/comm/sockjs.min.js"></script>
<script src="${basePath}/statics/js/jquery-3.4.1.min.js"></script>
<script src="${basePath}/statics/js/bootstrap.min.js"></script>
<script src="${basePath}/statics/js/comm/chat/chat.js"></script>
<script src="${basePath}/statics/js/comm/bootstrap.viewer.min.js"></script>
</html>