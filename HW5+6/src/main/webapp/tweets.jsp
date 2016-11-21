<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vietto
  Date: 07.11.16
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter</title>
</head>
<body>

<h1>Tweeter</h1>

<form action="/twitter" method="post">
    <label>Ваше сообщение: </label>
    <input type="text" name="message">
    <input type="submit">
</form>
<br>
<c:if test="${tweets.isEmpty()}">
    <p>Ничего пока нету :(</p>
</c:if>


<c:forEach items="${tweets}" var="tweet">
        <p>${tweet.message}</p>
        <p>${tweet.createdAt}</p>
        <form action="/deleteTweet" method="post">
            <input type="hidden" name="id" value=${tweet.id}>
            <input type="submit" value="Delete">
        </form>
        <c:forEach items="${tweet.comments}" var="comment">
            <p style="text-indent:50px">${comment.message}</p>
            <p style="text-indent:50px">${comment.createdAt}</p>
        </c:forEach>
        <form action="/commentTweet" method="post">
            <input type="hidden" name="id" value=${tweet.id}>
            <input type="text" name="message">
            <input type="submit" value="Comment">
        </form>
        <hr>
</c:forEach>

</body>
</html>
