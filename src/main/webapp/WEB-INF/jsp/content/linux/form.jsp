<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <h4>Insert Linux Study Club</h4>
    </div>
    <form:form modelAttribute="linux" method="POST" action="${linuxUrl}" class="form-horizontal" role="form">
        <div class="form-group">
            <form:label class="col-sm-2 control-label" path="mahasiswa.id">NIM</form:label>
            <div class="col-sm-5">
                <form:select type="text" path="mahasiswa.id">
                    <c:forEach items="${mahasiswaList}" var="mahasiswa">
                        <form:option value="${mahasiswa.id}">${mahasiswa.nim}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <form:label class="col-sm-2 control-label" path="year">Year</form:label>
            <div class="col-sm-5">
                <form:input type="text" class="form-control" placeholder="Year" path="year"></form:input>
            </div>
        </div>
        <input class="btn btn-warning" type="reset" value="Reset"/>
        <input class="btn btn-primary" type="submit" value="Submit"/>
    </form:form>
</div>

