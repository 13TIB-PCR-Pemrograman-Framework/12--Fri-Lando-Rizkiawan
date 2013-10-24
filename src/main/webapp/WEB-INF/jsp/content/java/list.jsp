<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
 - Author   : Dynastymasra
 - Name     : Dimas Ragil T
 - Email    : dynastymasra@gmail.com
 - LinkedIn : http://www.linkedin.com/in/dynastymasra
 - Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
--%>

<br><br>
<div class="jumbotron">
    <div class="alert alert-info">
        <h4>
            Java Study Club List<a href="<c:url value='/jsc/form'/>" class="pull-right"><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span></button></a>
        </h4>
    </div>
    <table class="table table-striped">
        <thead>
            <td align="center">No</td>
            <td align="center">NIM</td>
            <td align="center">Name</td>
            <td align="center">Email</td>
            <td align="center">Gender</td>
            <td align="center">Phone</td>
            <td align="center">Action</td>
        </thead>
        <tbody>

            <c:forEach items="${javaList}" var="java">
                <c:set var="no" value="${no + 1}"/>
                <tr>
                    <td align="center">${no}</td>
                    <td align="center">${java.mahasiswa.nim}</td>
                    <td>${java.mahasiswa.name}</td>
                    <td align="center">${java.mahasiswa.email}</td>
                    <td align="center">${java.mahasiswa.sex}</td>
                    <td align="center">${java.mahasiswa.number}</td>
                    <td align="center">
                        <a href="<c:url value='/jsc?id=${mahasiswa.id}'/>">
                            <button class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"/></button>
                        </a>
                        <a href="<c:url value='/jsc/form?id=${mahasiswa.id}'/>">
                            <button class="btn btn-warning"><span class="glyphicon glyphicon-pencil"/></button>
                        </a>
                        <a href="<c:url value='/jsc/delete?id=${mahasiswa.id}'/>">
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

