
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
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
        .container {
            width:400px;
            padding: 16px;
            background-color:lightblue;
            margin: 0 auto;
            margin-top: 30px;
            border: 2px solid white;
            border-radius: 4px;
            text:white;
            
        }
        input[type=text], input[type=password], input[type=number] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius:5px ;
        }
        .warning{
        color:red;
        
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            border-radius:5px ;
            border-color:#4CAF50 ;
        }
        button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>

    <div class="container">
        <form:form action="register" method="post" modelAttribute="user">
            <label for="fullName"><b>Full Name</b></label>
            <form:input type="text" placeholder="Enter Full Name" name="fullName" path="fullName"  />
            <form:errors type="text" class="warning" path="fullName"></form:errors><br>

            <label for="age"><b>Age</b></label>
            <form:input type="number" placeholder="Enter Age" path="age" />
            <form:errors type="text"  class="warning" path="age"></form:errors><br>

            <label for="gender"><b>Gender</b></label>
            <form:input type="text" placeholder="Enter Gender" path="gender"  />
            <form:errors type="text" class="warning" path="gender"></form:errors><br>

            <label for="phone"><b>Phone Number</b></label>
            <form:input type="text" placeholder="Enter Phone Number" path="phoneNumber"  />
            <form:errors type="text" class="warning" path="phoneNumber"></form:errors><br>

            <label for="password"><b>Password</b></label>
            <form:input type="password" placeholder="Enter Password" path="password"  />
            <form:errors type="text" class="warning" path="password"></form:errors><br>

            <button type="submit">Register</button>
        </form:form>
        <div class="register">
            <p>Already have an account? <a href="login">Login Here</a></p>
        </div>
    </div>
</body>
</html>
