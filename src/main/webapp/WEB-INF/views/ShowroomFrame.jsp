<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Car Test Drive</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    New Showroom
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="showroomRegisterForm" cssClass="form-horizontal" modelAttribute="showroom" method="post" action="saveShowroom">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="nameShowroom" >Name</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="showroomId" value="${showroomObject.showroomId}"/>
                            <form:input cssClass="form-control" path="nameShowroom" value="${showroomObject.nameShowroom}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="address" cssClass="control-label col-xs-3">Address</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="address" value="${showroomObject.address}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                        	<div class="col-xs-1">
                            </div>
                            <div class="col-xs-2">
                                <input type="submit" id="saveShowroom" class="btn btn-primary" value="Save" onclick="return submitShowroomForm();"/>
                            </div>
                            <div class="col-xs-2">
                                <input type="button" id="cancelShowroom" class="btn btn-primary" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/showrooms'"/>
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
        function submitShowroomForm() {             
            
            // getting the showroom form values
            var nameShowroom = $('#nameShowroom').val().trim();
            var address = $('#address').val().trim();
            if(nameShowroom.length ==0) {
                alert('Please enter name');
                $('#nameShowroom').focus();
                return false;
            }
            
            if(address.length ==0) {
                alert('Please enter address');
                $('#address').focus();
                return false;
            }    
            return true;
        };  
    </script>
</body>
</html>