<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>REGISTER</title>
		<style>
			.mycol > div {
				display:inline-block;
				min-width:130px;
			}
			td {
				padding:5px 10px;
			}
			table {
				margin-left:70px;
			}
			.container {
				display: flex;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
			body{
			
			margin: 0;
                padding: 0;
                height: 100vh;
                background-image: url("bus10.jpg");
                background-size:cover;
                animation: bg 8s linear infinite;
                background-position: center;
                color:black;
        }
			.form {
				border: 1px solid #000;
				border-radius: 5px;
				padding: 15px;
				width: 60%;
				background-color:white;
			}
			.btn {
				display: inline-block;
				border: 1px solid green;
				padding: 5px 10px;
				text-align: center;
			}
			.btn-danger {
				border-color: red;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<form:form action="/BookingStatus" method="post" class="form" >
				<div class="mb-4">
					<h4 class="text-center">Booking Confirmation</h4>
				</div>
				
				<hr>
				
				<div class="gap-2 mx-auto" style="width:90%">
					<div class="row p-1">
						<div class="col mycol">
							<div class="fw-bold text-primary" >BUS NUMBER </div>
							<div>${ bookingDetail.bus.busNumber }</div>
						</div>
						<div class="col mycol">
							<div class="fw-bold text-primary">BUS NAME </div>
							<div>${ bookingDetail.bus.name }</div>
						</div>
					</div>
					
					<div class="row p-1">
						<div class="col mycol">
							<div class="fw-bold text-primary">SOURCE </div>
							<div>${  bookingDetail.bus.source }</div>
						</div>
						<div class="col mycol">
							<div class="fw-bold text-primary">DESTINATION </div>
							<div>${ bookingDetail.bus.destination }</div>
						</div>
					</div>
					
					<div class="row p-1">
						<div class="col mycol">
							<div class="fw-bold text-primary">DOJ </div>
							<div>${  bookingDetail.DOJ }</div>
						</div>
						<div class="col mycol">
							<div class="fw-bold text-primary">TYPE </div>
							<div>${ bookingDetail.type }</div>
						</div>
					</div>
				</div>
				
				<h5 class="mx-5 mt-4 text-primary text-decoration-underline">Passenger List</h5>
				
				<table>
					<c:forEach var="count" begin="0" end="${ bookingDetail.passengers.size()-1 }">		
						<tr><td>${ count+1 }.</td><td>${ bookingDetail.passengers[count].passengerName }</td></tr>
					</c:forEach>
				</table>					
				<hr>
				
				<div class="d-flex justify-content-around mt-3">
					<div><span class="h5 text-primary">Total Fare :</span> <span class="h5 text-success">Rs.${ bookingDetail.totalFare }/-</span></div>
					<div>
						<input type="submit" value="Confirm Booking" class=" btn btn-success"/>
						<a href="home" class="btn btn-danger">Cancel</a>
					</div>
				</div>
								
			</form:form>
		</div>
	</body>
</html>
