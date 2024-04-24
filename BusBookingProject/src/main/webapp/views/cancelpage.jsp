<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
	<head>
		<title>REGISTER</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/56e2779d6d.js" crossorigin="anonymous"></script>
	</head>
	<body class="px-5">
		<c:forEach items="${ myBookings }" var="booking">
			<div class="border rounded m-3 p-3 px-5 shadow">
				<div class="d-inline-block" style="width:100px;height:100px;position:relative;top:-50px">
					<img src="logo.jpg" width=100% height=100% >
				</div>
				<div class="float-left d-inline-block m-3" style="width:70%">
					<div class="d-flex justify-content-between">
						<div>
							<span class="h3">${ booking.bus.name }<span>
							<span class=text-secondary>(${ booking.bus.busNumber })</span>
						</div>
						<div>
							<span class="h4">BOOKING ID : </span>
							<span class="text-danger h3">${ booking.bookingId }</span>
						</div>
					</div>
					
					<div class="my-2" style="font-size:20px">
						<span class="text-uppercase">${ booking.bus.source } </span>
						<i class="fa-solid fa-arrow-right-long mx-4"  style="font-size:25px;position:relative;top:5px"></i>
					
						<span class="text-uppercase">${ booking.bus.destination }</span>
					</div>
					
					
					<div class="my-2">
						<span class="h5">Date of Journey :<span>
						<span class=text-secondary>${ booking.DOJ }</span>
					</div>
					<div class="d-flex justify-content-between">
						<div class="my-2">
							<span class="h5 ">Type :<span>
							<span class="text-secondary text-uppercase">${ booking.type }</span>
						</div>
						<div>
							<a href="cancel?bookingId=${ booking.bookingId }" class="btn btn-danger px-4">Cancel</a>
						</div>
					</div>
					
				</div>
				
			</div>
		</c:forEach>
	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>
