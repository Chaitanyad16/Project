<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
	<head>
		<title>REGISTER</title>
		<style>
		body {
            font-family: Arial, sans-serif;
             margin: 0;
                padding: 0;
                height: 100vh;
                background-image: url("bus10.jpg");
                background-size:cover;
                animation: bg 8s linear infinite;
                background-position: center;
        }
        </style>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	</head>
	
	<body>
		<div class="d-flex justify-content-center align-items-center" style="height:100%;">
			<form:form action="" method="post" modelAttribute="bookingDetail" class="border rounded border-secondary p-3" style=" background-color:white;">
				<h3 class="mb-3 fst-italic text-primary">${bookingDetail.bus.name}(${bookingDetail.bus.busNumber})</h3>
				<hr>
				<div class="row">
					<p class="col text-center fw-bold">TYPE</p>
					<p class="col">${ bookingDetail.type }</p>
				</div>
				<div class="row">
					<p class="col text-center fw-bold"> DOJ  </p>
					<p class="col">${ bookingDetail.DOJ }</p>
				</div>
				<div class="row">
					<p class="col text-center fw-bold"> No. of Passengers   </p>
					<p class="col"><form:input type="number" path="noOfSeats"/></p>
				</div>
				
				
   				<form:input type="hidden" path="DOJ" value="${ doj }" />
				<from:input type="hidden" path="type" value="${ type }" />
				
				<div class="d-flex justify-content-center">
					<input type="submit" value="OK" style="width:120px"/>
				</div>
				
			</form:form>
		</div>
		
		
	</body>
</html>