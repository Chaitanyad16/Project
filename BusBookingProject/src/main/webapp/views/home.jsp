

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
    <head>
        <style>
            body{
               
                margin: 0;
                padding: 0;
                height: 100vh;
                background-image: url("BUS1.png");
                background-size:cover;
                animation: bg 8s linear infinite;
                background-position: center;
            }
           
            .bar{
                width:100%;
                position: relative;
                top: 60%;
                display:flex;
                justify-content:space-around;
               
            }
            .bar > a{
                border:2px solid #60daef;
                border-radius:10px;
                padding:15px 25px;
                text-decoration:none;
                background-color:#9de4f8;
                font-weight:bold;
                color:black;
               
            }
            .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            background-color: #008CBA; /* Blue */
            border: none;
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            transition-duration: 0.4s;
            cursor: pointer;
            border-radius: 5px; /* Rounded corners */
            box-shadow: 0 4px 8px 0 rgba(20, 36, 215, 0.2); /* Shadow effect */
        }
        .button:hover {
            background-color: #4CAF50; /* Green */
            color: white;
        }
       .card-link{
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 20px 0;
            border: none;
            cursor: pointer;
            width: 40%;
            border-radius:10px ;
            background-color: blue;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 70%;
            border-radius:5px ;
        }
        .card {
    background-color: #fff;
    border-radius: 4px;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    margin: 20px;
    padding: 20px;
    width: 300px;
    text-align: center;
}

.card h2 {
    margin-bottom: 10px;
    
}

.card-content {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.card-content a{
 text-decoration:none;
}
        </style>
        <title>HOME</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
       
        <div>
            <c:if test="${ !loggedIn }">
                <a href="/register" class="text-decoration-none fw-bold btn btn-light float-end px-4 m-3">Register</a>
            </c:if>
           
            <c:if test="${ !loggedIn }">
                <a href="/login" class="text-decoration-none fw-bold btn btn-light float-end px-4 m-3">Login</a><br>
            </c:if>
           
            
        </div>
       
    
           
            <div class="container">
			<div class="home">
			    <div class="card">
			        <h6>Your Booking Options</h6>
			        <div class="card-content">
			            <a href="/booking" class="card-link" style="margin-left:16px;">Booking</a>
			            <a href="/cancellation" class="card-link">Cancellation</a>
			            <a href="/mybookings" class="card-link">My Bookings</a>
			        </div>
			    </div>
			</div>
          
       
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"  integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>  
    </body>
</html>
