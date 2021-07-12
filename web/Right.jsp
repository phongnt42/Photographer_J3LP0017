<%-- 
    Document   : Right
    Created on : Mar 13, 2020, 9:28:36 PM
    Author     : phongnthe140289
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/right.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="header-right">
            <h4>Share this page</h4>
        </div>
        <div class="social">
            <div>
                <ul>
                    <li><img src="${socialSharingPage.iconFacebook}"><a href="${socialSharingPage.facebookUrl}"><span>Share on Facebook</span></a></li>
                    <li><img src="${socialSharingPage.iconTwitter}"><a href="${socialSharingPage.twitterUrl}"><span>Share on Twitter</span></a></li>
                    <li><img src="${socialSharingPage.iconGoogle}"><a href="${socialSharingPage.googleUrl}"><span>Share on Google</span></a></li>
                </ul>
            </div>

        </div>
    </body>
</html>
