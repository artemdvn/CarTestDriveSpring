<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Car Test Drive</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
	<div class="container myrow-container">
    	<div class="panel panel-success">
        	<div class="panel-heading">
	            <h3 class="panel-title">
	            	<form:form id="showroomSelectedForm" cssClass="form-horizontal" method="post" action="getAllCars">
	            		<div class="row">
	            			<div class="col-xs-6">
	            				<div align="left"><b>Select showroom:</b> </div>
	            			</div>
	            		</div>
	            		<p/>	            		
	            		<div class="row">
	            			<div class="col-xs-6">
			                    <select name="showroomSelectedId">
				                <c:forEach var="showroom" items="${showrooms}">
				                    <c:choose>
				                        <c:when test="${showroom.showroomId==showroomSelectedId}">
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
			            <p/>
			            <div class="row">
			                <div class="col-xs-3">
		                       <input type="submit" id="getAllCars" class="btn btn-primary" value="Get all cars"/>
		                    </div>
		                    <div class="col-xs-3">
		                       <input type="submit" id="getOnlyFreeCars" class="btn btn-primary" value="Get only free cars" onclick="form.action='getOnlyFreeCars';"/>
		                    </div>
		                    <div class="col-xs-3">
		                       <input type="submit" id="moveCarsToShowroom" class="btn btn-primary" value="Move all cars to showroom" onclick="form.action='moveCarsToShowroom';"/>
		                    </div>
		                </div>
		            </form:form>
		        </h3>
        	</div>
        </div>
        <div class="panel-body">
        	<div align="right"><a href="addCar">Add New Car</a></div>
	        <div align="left"><b>Car list for chosen parameters:</b> </div>
            <c:if test="${empty carList}">
                No Cars
            </c:if>
            <c:if test="${not empty carList}">   
            
                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
	                    <th>Name</th>
	                    <th>Model</th>
	                    <th>Year of issue</th>
	                    <th>Mileage</th>
	                    <th>Reserved</th>
	                    <th>Edit</th>
                        <th>Delete</th>
                        <th>Reserve</th>
                        <th>Release</th>
	                </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${carList}" var="car">
                        <tr>
                            <th><c:out value="${car.carName}"/></th>
                            <th><c:out value="${car.modelName}"/></th>
                            <th><c:out value="${car.yearOfIssue}"/></th>
                            <th><c:out value="${car.mileage}"/></th>
                            <th><c:out value="${car.reserved}"/></th>
                            <th><a href="editCar?id=<c:out value='${car.carId}'/>">Edit</a></th>
                            <th><a href="deleteCar?id=<c:out value='${car.carId}'/>">Delete</a></th>
                            <th><a href="reserveCar?id=<c:out value='${car.carId}'/>">Reserve</a></th>
                            <th><a href="releaseCar?id=<c:out value='${car.carId}'/>">Release</a></th>                          
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    
    <a href="${pageContext.request.contextPath}/showrooms">Edit showroom list</a>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>