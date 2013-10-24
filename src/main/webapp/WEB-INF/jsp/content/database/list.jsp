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
            Informatic Database Club List<a href="<c:url value='/idc/form'/>" class="pull-right"><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span></button></a>
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

            <c:forEach items="${databaseList}" var="database">
                <c:set var="no" value="${no + 1}"/>
                <tr>
                    <td align="center">${no}</td>
                    <td align="center">${database.mahasiswa.nim}</td>
                    <td>${database.mahasiswa.name}</td>
                    <td align="center">${database.mahasiswa.email}</td>
                    <td align="center">${database.mahasiswa.sex}</td>
                    <td align="center">${database.mahasiswa.number}</td>
                    <td align="center">
                        <a href="<c:url value='/idc?id=${mahasiswa.id}'/>">
                            <button class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"/></button>
                        </a>
                        <a href="<c:url value='/idc/form?id=${mahasiswa.id}'/>">
                            <button class="btn btn-warning"><span class="glyphicon glyphicon-pencil"/></button>
                        </a>
                        <a href="<c:url value='/idc/delete?id=${mahasiswa.id}'/>">
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

