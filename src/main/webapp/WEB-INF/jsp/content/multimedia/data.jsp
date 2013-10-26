<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            Multimedia Study Club Data
            <a href="<c:url value='/ksm/form?id=${mulmed.id}'/>" class="pull-right">
                <button class="btn btn-warning"><span class="glyphicon glyphicon-pencil"/></button>
            </a>
            <a href="<c:url value='/ksm/delete?id=${mulmed.id}'/>" class="pull-right">
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></button>
            </a>
        </h4>
    </div>
    <table class="table-striped">
        <tr>
            <td>NIM</td>
            <td width="5px" align="center">:</td>
            <td>${mulmed.mahasiswa.nim}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td width="5px" align="center">:</td>
            <td>${mulmed.mahasiswa.name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td width="5px" align="center">:</td>
            <td>${mulmed.mahasiswa.email}</td>
        </tr>
        <tr>
            <td>Gender</td>
            <td width="5px" align="center">:</td>
            <td>${mulmed.mahasiswa.sex}</td>
        </tr>
        <tr>
            <td>Phone</td>
            <td width="5px" align="center">:</td>
            <td>${mulmed.mahasiswa.number}</td>
        </tr>
    </table>
</div>