
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
                padding: 0;
                height: 100vh;
                background-image: url("bus10.jpg");
                background-size:cover;
                animation: bg 8s linear infinite;
                background-position: center;
        }
        .form-container {
            width: 600px;
            margin: 0 auto;
            padding: 10px;
            margin-top:10%;
            background-color:lightblue;
            border: 3px solid black;
            border-radius: 5px;
        }
        .form-field {
            margin-bottom: 20px;
        }
        .form-field label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        .form-field input {
            width: 90%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
            background-color:white;
           
        }
       input[type=submit]
        {
       background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border-radius:5px ;
            cursor: pointer;
            width: 93%;
          border-radius:5px ;
          border-color:#4CAF50;
            
        }
    </style>
</head>
<body>

    <div class="form-container">
        <form method="post">
            <div class="form-field">
                <label for="source">Source:</label>
              <input name="source" list="stops1">
              <datalist id="stops1">
              <c:forEach items="${ stops }" var="stop">
			<option value="${ stop }">${ stop}</option>
		  </c:forEach>
           </datalist>

            </div>
            <div class="form-field">
                <label for="destination">Destination:</label>
                   <input name="destination" list="stops1">
                          
            </div>
            <div class="form-field">
                <label for="dateofjourney">Date of Journey:</label>
                <input type="date" id="dateofjourney" name="dateofjourney">
            </div>
            <div >
            	<input type="submit" value="Show Buses" >
            </div>
            
        </form>
    </div>
</body>
</html>
