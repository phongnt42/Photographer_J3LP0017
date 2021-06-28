<%-- 
    Document   : HomePage
    Created on : Mar 13, 2020, 8:25:40 AM
    Author     : DonOzOn
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <title>Gallery</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${gallery.name}</h3>
                    </div>

                    <div class="playbutton">
                        <c:forEach items="${listImages}" var="image">
                            <div class="imageGaler" id="slideshow">
                                <img src="${image.imageUrl}" alt=""> 
                            </div>                                
                        </c:forEach>
                        <button class="controls" id="pause">
                            <img class="controls">
                        </button>
                    </div>
                    <div class="contentGalery">                                
                        <ul>
                            <c:forEach items="${listImages}" var="image">
                                <li class="span4">
                                    <img src="${image.imageUrl}">
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="paging">
                            <c:forEach begin="1" end="${totalImagePage}" var="i">
                                <a class="${i == currentPage?"active":""}" href="gallery?pageNumber=${i}&galleryID=${gallery.id}">${i}</a>
                            </c:forEach>
                        </div>
                    </div>              

                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
        <script>
            var playing = true;
            var pauseButton = document.getElementById('pause');
            var myIndex = 0;

            function carousel() {
                var i;
                var x = document.getElementsByClassName("imageGaler");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                x[myIndex].style.display = "block";
                myIndex++;
                
                if (myIndex >= x.length) {
                    myIndex = 0;
                }
            }


            function pauseSlideshow() {
                pauseButton.innerHTML = '<img src=\'images/play1.png\'width=\'1200px\' height=\'1500px\'>';
                playing = false;
                clearInterval(slideInterval);
            }

            function playSlideshow() {
                pauseButton.innerHTML = '<img src=\'images/pause1.png\'width=\'1200px\' height=\'1500px\'>';
                playing = true;
                slideInterval = setInterval(carousel, 2000);
            }

            pauseButton.onclick = function () {
                if (playing) {
                    pauseSlideshow();
                } else {
                    playSlideshow();
                }
            };

            carousel();
            playSlideshow();
        </script>
    </body>
</html>
