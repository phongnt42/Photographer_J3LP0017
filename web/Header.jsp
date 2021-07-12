<%-- 
    Document   : header
    Created on : Mar 13, 2020, 9:18:13 PM
    Author     : phongnthe140289
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/header.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="nav">
            <div class= "nav-inner">
                <ul>
                    <li> <a class="${active=="0"?"activeMenu":""}" href="./home">My front page</a></li>
                        <c:forEach items="${topGalleries}" var="i" >
                        <li> <a class="${active==i.id?"activeMenu":""}" href="gallery?galleryID=${i.id}">${i.name}</a> </li>
                        </c:forEach>
                    <li> <a class="${active=="4"?"activeMenu":""}" href="./contact">Contact</a> </li>
                </ul>
            </div>

        </div>
        <div class="header">
            <div class="header-inner">
                <div class="img"> </div>
                <!--<img rel="nofollow" src="./images/logo.png"/>-->
                <div class="title ">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>
    </body>
</html>
