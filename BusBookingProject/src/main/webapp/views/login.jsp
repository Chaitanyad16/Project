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
            width: 500px;
            padding: 16px;
            background-color:lightblue;
            margin: 0 auto;
            margin-top:150px;
            border: 3px solid white;
            border-radius: 7px;
            
        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius:5px ;
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
        }
        button:hover {
            opacity: 0.8;
            color:red;
        }
    </style>
</head>
<body>
    <div class="container">
    <form action="login" method="post">
        <label for="phone"><b>Phone Number</b></label>
        <input type="text" placeholder="Enter Phone Number" name="phone" >

        <label for="pwd"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="pwd" >

        <button type="submit">Login</button>
      </form>
      <div class="register">
            <p>Don't have an account? <a href="register">Register Now</a></p>
        </div>
        
        <div>
        	<p>${ error }</p>
        </div>
    </div>
</body>
</html>
