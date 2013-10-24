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
        <h4>Insert Java Study Club</h4>
    </div>
    <form:form modelAttribute="java" method="POST" action="${javaUrl}" class="form-horizontal" role="form">
        <div class="form-group">
            <form:label class="col-sm-2 control-label" path="nim">NIM</form:label>
            <div class="col-sm-5">
                <form:input type="text" class="form-control" placeholder="NIM" path="nim"></form:input>
            </div>
        </div>
        <div class="form-group">
            <form:label class="col-sm-2 control-label" path="name">Name</form:label>
            <div class="col-sm-5">
                <form:input type="text" class="form-control" placeholder="Name" path="name"></form:input>
            </div>
        </div>
        <div class="form-group">
            <form:label for="inputEmail1" class="col-sm-2 control-label" path="email">Email</form:label>
            <div class="col-sm-5">
                <form:input type="email" class="form-control" id="inputEmail1" placeholder="Email" path="email"></form:input>
            </div>
        </div>
        <div class="form-group">
            <form:label class="col-sm-2 control-label" path="sex">Gender</form:label>
            <div class="col-sm-5">
                <form:select type="text" class="form-control" path="sex">
                    <form:option value="MALE">Male</form:option>
                    <form:option value="FEMALE">Female</form:option>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <form:label class="col-sm-2 control-label" path="number">Phone</form:label>
            <div class="col-sm-5">
                <form:input type="text" class="form-control" placeholder="Phone" path="number"></form:input>
            </div>
        </div>
        <input class="btn btn-warning" type="reset" value="Reset"/>
        <input class="btn btn-primary" type="submit" value="Submit"/>
    </form:form>
</div>

