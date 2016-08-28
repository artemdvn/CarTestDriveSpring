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
                    Car Info
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="carRegisterForm" cssClass="form-horizontal" modelAttribute="car" method="post" action="saveCar">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="carName" >Name</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="carId" value="${carObject.carId}"/>
                            <form:input cssClass="form-control" path="carName" value="${carObject.carName}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="modelName" cssClass="control-label col-xs-3">Model</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="modelName" value="${carObject.modelName}"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="yearOfIssue" cssClass="control-label col-xs-3">Year of issue</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="yearOfIssue" value="${carObject.yearOfIssue}"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="showroomId" cssClass="control-label col-xs-3">Showroom</form:label>
                        <div class="col-xs-6">
                            <select name="showroomId">
	                        <c:forEach var="showroom" items="${showrooms}">
	                            <c:choose>
	                                <c:when test="${showroom.showroomId==carObject.showroomId}">
	                                    <option value="${showroom.showroomId}" selected><c:out value="${showroom.nameShowroom}"/></option>
	                                </c:when>
	                                <c:otherwise>
	                                    <option value="${showroom.showroomId}"><c:out value="${showroom.nameShowroom}"/></option>
	                                </c:otherwise>
	                            </c:choose>
	                        </c:forEach>
	                        </select>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="mileage" cssClass="control-label col-xs-3">Mileage</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="mileage" value="${carObject.mileage}"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="reserved" cssClass="control-label col-xs-3">Reserved</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="reserved" value="${carObject.reserved}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                        	<div class="col-xs-2">
                                <input type="submit" id="saveCar" class="btn btn-primary" value="Save" onclick="return submitCarForm();"/>
                            </div>
                            <div class="col-xs-2">
                                <input type="button" id="cancelCar" class="btn btn-primary" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/main'"/>
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
        function submitCarForm() {             
            
            // getting the car form values
            var carName = $('#carName').val().trim();
            var modelName = $('#modelName').val().trim();
            var yearOfIssue = $('#yearOfIssue').val().trim();
            var mileage = $('#mileage').val().trim();
            var reserved = $('#reserved').val().trim();
            if(carName.length ==0) {
                alert('Please enter name');
                $('#carName').focus();
                return false;
            }
            
            if(modelName.length ==0) {
                alert('Please enter model');
                $('#modelName').focus();
                return false;
            }
            
            if(isNaN(+yearOfIssue)) {
                alert('Please enter correct year of issue');
                $('#yearOfIssue').focus();
                return false;
            }
            
            if(isNaN(+mileage)) {
                alert('Please enter correct mileage');
                $('#mileage').focus();
                return false;
            }
            
            if(reserved!='true' && reserved!='false') {
                alert('Please enter correct reserved (true/false)');
                $('#reserved').focus();
                return false;
            }
            return true;
        };  
    </script>
</body>
</html>