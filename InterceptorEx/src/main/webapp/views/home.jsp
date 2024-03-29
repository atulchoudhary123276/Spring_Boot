<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BloodBank.in</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: url('https://e1.pxfuel.com/desktop-wallpaper/655/28/desktop-wallpaper-blood-donation-misc-hq-blood-donation-blood-bank.jpg') no-repeat center center fixed;
            background-size : cover;
            font-family: 'Open Sans', sans-serif;
        }

        header {
            text-align: center;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            font-size: 36px;
            font-weight: bold;
            position: relative;
            color: #d4af7a; /* Text color */
        }

        .header-buttons {
            position: absolute; /* Remove relative positioning */
            top: 15px; /* Adjust top position for desired button placement */
            right: 20px;
        }

        .header-buttons button {
            margin-left: 10px;
            padding: 10px 20px;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease-in-out;
        }

        .header-buttons button:hover {
            background-color: #975e2b; /* Darker background color on hover */
        }

        a {
            text-decoration: none;
            font-weight: bold;
            color: #d4af7a; /* Link color */
        }

        a:hover {
            text-decoration: underline;
            color: #975e2b; /* Darker link color on hover */
        }
    </style>
</head>
<body>
   <header>
      BloodBank.in
      <div class="header-buttons">
         <button><a href="login">Login</a></button>
         <button><a href="signup">Sign Up</a></button>
      </div>
   </header>
</body>
</html>
