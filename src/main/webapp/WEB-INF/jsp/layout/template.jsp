<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--
- Author   : Dynastymasra
- Name     : Dimas Ragil T
- Email    : dynastymasra@gmail.com
- LinkedIn : http://www.linkedin.com/in/dynastymasra
- Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
--%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/dist/css/bootstrap.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/dist/css/bootstrap-theme.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>">
        <script type="text/javascript" src="<c:url value='/resources/jquery/jquery.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/bootstrap/dist/js/bootstrap.min.js'/>"></script>
        <title>Spring Tile Database</title>
    </head>
    <body>
        <div class="container">
            <div class="masthead">
                <tiles:insertAttribute name="menu-template"/>
                <tiles:insertAttribute name="head-template"/>
            </div>
            <div class="row">
                <tiles:insertAttribute name="main-template"/>
                <tiles:insertAttribute name="footer-template"/>
            </div>
        </div>
    </body>
</html>
