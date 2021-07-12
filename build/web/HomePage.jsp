<%-- 
    Document   : HomePage
    Created on : Mar 13, 2020, 8:25:40 AM
    Author     : phongnthe140289
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="image">
                        <img src="${shortContact.contactImage}" alt="First">
                    </div>
                    <div class="description">
                    </div>
                    <div class="content">
                            <ul>                             
                                <c:forEach items="${listGalleries}" var="i" >
                                    <li class="span4">
                                        <div class="image">
                                            <img src="${i.mainImage}">
                                        </div>
                                        <h4>
                                            <a href="gallery?galleryID=${i.id}">View ${i.name}</a>
                                        </h4>
                                        <p>${i.description}</p>
                                    </li>
                                </c:forEach>
                            </ul>
                   
                        <div class="paging">                        
                            <c:forEach begin="1" end="${totalGalleriesPage}" var="i">
                                <a class="${i == currentPage ? "active":""}" href="home?pageNumber=${i}">${i}</a>
                            </c:forEach>                       
                        </div>
                    </div>
                    <div class="about">
                        <h3>About me</h3>
                    </div>
                    <div class="about-detail">
                        ${shortContact.aboutMe}
                    </div>
                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>

    </body>
</html>
