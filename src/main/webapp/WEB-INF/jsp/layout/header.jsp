<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
 - Author   : Dynastymasra
 - Name     : Dimas Ragil T
 - Email    : dynastymasra@gmail.com
 - LinkedIn : http://www.linkedin.com/in/dynastymasra
 - Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
--%>

<div class="row">
    <div id="myCarousel" class="carousel slide">
        <!-- Carousel items -->
        <div class="carousel-inner">
            <div class="active item"><img src="<c:url value='/resources/img/home.jpg'/>" class="img-responsive" alt="Responsive image"/></div>
            <div class="item"><img src="<c:url value='/resources/img/jsc.png'/>" class="img-responsive" alt="Responsive image"/></div>
            <div class="item"><img src="<c:url value='/resources/img/idc.png'/>" class="img-responsive" alt="Responsive image"/></div>
            <div class="item"><img src="<c:url value='/resources/img/ksl.png'/>" class="img-responsive" alt="Responsive image"/></div>
            <div class="item"><img src="<c:url value='/resources/img/ksweb.png' />" class="img-responsive" alt="Responsive image"/></div>
        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </div>
</div>