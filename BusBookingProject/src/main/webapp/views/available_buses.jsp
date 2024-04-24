<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>REGISTER</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<style>
			body {
				background-color: #f8f9fa;
			}
			.bus-card {
				border: 1px solid #ced4da;
				border-radius: 0.50rem;
				background-color: skyblue;
				margin:5px;
			}
			.bus-card h3 {
				font-size: 2rem;
				font-weight: 400;
				
			}
			.bus-card div {
				display: flex;
				padding: 5px;
			}
			.bus-card button {
				display: flex;
				flex-direction: column;
				align-items: center;
				border: 1px solid #ced4da;
				border-radius: 0.25rem;
				padding: 1rem;
				margin-right:10px;
				width: 20%;
				text-align: center;
			}
		</style>
	</head>
	<body>
	<c:if test="${ availableBuses.isEmpty() }">
			<div class="d-flex flex-column justify-content-center align-items-center" style="height:100%">
				<h3 class="text-danger">No Buses Found !</h3>
				<a class="btn btn-outline-success" href="/booking">Back</a>
			</div>
		</c:if>
	

		<c:forEach items="${availableBuses}" var="availableBus">
			<div class="bus-card">
				<h3 class="text-center"> ${availableBus.availabilityKey.bus.name} (${availableBus.availabilityKey.bus.busNumber}) </h3>
				<hr />
				<div>
					<div style="font-size:20px" ;>${availableBus.availabilityKey.bus.source}</div>
					<div style="font-size:20px" >${availableBus.availabilityKey.bus.destination}</div>
				</div>
				<div>
					<c:if test="${ availableBus.sleeperSeats>=0 }">
						<button onclick="location.href='/passenger_details?bus=${availableBus.availabilityKey.bus.busNumber}&type=sleeper&doj=${availableBus.availabilityKey.DOJ}'">
							<div class="fw-bold">Sleeper</div>
							<div class="text-danger">AVL. ${availableBus.sleeperSeats}</div>
							<div class="text-success">Rs. ${availableBus.availabilityKey.bus.sleeperPrice}</div>
						</button>
					</c:if>
					
					<c:if test="${ availableBus.seaterSeats>=0 }">
					<button onclick="location.href='/passenger_details?bus=${availableBus.availabilityKey.bus.busNumber}&type=seater&doj=${availableBus.availabilityKey.DOJ}'">
							<div class="fw-bold">Seater</div>
							<div class="text-danger">AVL. ${availableBus.seaterSeats}</div>
							<div class="text-success">Rs. ${availableBus.availabilityKey.bus.seaterPrice}</div>
						</button>
					
					</c:if>
					
				</div>
			</div>
		</c:forEach>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>
