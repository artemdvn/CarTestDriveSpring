<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Test Drive</title>
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
	        		<h1>Welcome to Car Test Drive!</h1>
	        	</div>
	        	<div class="panel-body">
	        		<a href="${pageContext.request.contextPath}/main">Go to main page</a>
	        	</div>
	        </div>
        </div>
    </body>
</html>
