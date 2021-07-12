<%-- 
    Document   : Footer
    Created on : Mar 13, 2020, 9:22:11 PM
    Author     : phongnthe140289
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/footer.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="footer">
            <div class="link">
                <a href="#">Created with SimpleSite </a>
                <div class="flex">
                    <c:forEach var="i" items="${sessionScope.websiteView}">
                        <span class="footer-page-counter-item">${i}</span>
                    </c:forEach>
                </div>
            </div>

        </div>
    </body>
</html>
