<%-- 
    Document   : Error
    Created on : Mar 13, 2020, 9:28:48 PM
    Author     : DonOzOn
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <title>Error</title>
    </head>
    <body>
        
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <h1>${error}</h1>
                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
