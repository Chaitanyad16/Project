<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>REGISTER</title>
		<style>
			body {
				display: flex;
				justify-content: center;
				align-items: center;
				height: 100%;
				margin: 0;
                padding: 0;
                height: 100vh;
                background-image: url("bus10.jpg");
                background-size:cover;
                animation: bg 8s linear infinite;
                background-position: center;
        }
			}
			.row {
				display: flex;
				padding: 10px;
			}
			.col {
				flex: 1;
			}
			.m-3 {
				margin: 15px;
			}
			.btn {
				display: inline-block;
				border: 1px solid green;
				padding: 5px 10px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<form:form action="/confirm" method="post" modelAttribute="bookingDetail">
			<form:input type="hidden" path="type" value="${ type }"/>
			<form:input type="hidden" path="DOJ" value="${ DOJ }"/>
			<form:input type="hidden" path="noOfSeats" value="${ noOfSeats }"/>
			
			<c:forEach var="count" begin="1" end="${ bookingDetail.noOfSeats }" >
				<div class="row">
					<div class="col"><span class="m-3">Passenger ${count}</span></div>
					<div class="col"><form:input type="text" path="passengers[${count - 1}].passengerName"/></div>
				</div>
			</c:forEach>
			
			<div style="display: flex; justify-content: center; align-items: center;">
				<input type="submit" value="next" class="btn" style="width:90px"/>
			</div>
		</form:form>
	</body>
</html>
