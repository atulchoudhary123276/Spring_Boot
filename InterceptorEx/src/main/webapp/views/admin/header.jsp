<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        /* Reset styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;

        }

        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;

        }

        .container {
            display: flex;
            flex-direction: column;
            min-height: 100vh;

        }

        /* Header styles */
        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo a {
            color: #fff;
            text-decoration: none;
            font-size: 24px;
            font-weight: bold;
        }

        .user-info {
            display: flex;
            align-items: center;
        }

        .user-info span {
            margin-right: 10px;
        }

        .logout {
            color: #fff;
            text-decoration: none;
            padding: 5px 10px;
            background-color: #ff6347;
            border-radius: 4px;
        }

        /* Main content styles */
        .main {
            display: flex;
            flex: 1;
        }

        .sidebar {
            background-color: #f1f1f1;
            padding: 20px;
            width: 200px;
        }

        .sidebar ul {
            list-style-type: none;
        }

        .sidebar li {
            margin-bottom: 10px;
        }

        .sidebar a {
            color: #333;
            text-decoration: none;
            padding: 10px;
            display: block;
        }

        .sidebar a:hover,
        .sidebar a.active {
            background-color: #bab5b5;
        }

        .content {
            padding: 20px;
            flex: 1;
        }

        /* My Own CSS */

         h1 {
                  text-align: center;
                  margin-bottom: 5px;
                  color: #2c3e50;
              }
              .admin-profile {
                  margin: auto;
                  height: 80%;
                  width: 60%;
                  margin-bottom: 30px;
                  padding: 20px;
                  background-color: #34495e;
                  color: #ecf0f1;
                  border-radius: 10px;
              }

              .admin-profile h2 {
                  margin-bottom: 15px;
              }
              table {
                  width: 100%;
                  border-collapse: collapse;
              }
              th, td {
                  padding: 15px;
                  text-align: left;
                  border-bottom: 1px solid #bdc3c7;
              }
              th {
                  background-color: #2c3e50;
                  color: #ecf0f1;
                  font-weight: bold;
                  text-transform: uppercase;
              }
              td {
                  background-color: #ecf0f1;
              }

              .agent-form{
                width:50%;
                margin: auto;
                height: 70%
              }
              .enduser-list{
                width:90%;
                margin:auto;
              }
              form {
                      display: flex;
                      flex-direction: column;
                  }
                  .form-row {
                      display: flex;
                      justify-content: space-between;
                      margin-bottom: 15px;
                  }
                  .form-row label,
                  .form-row input,
                  .form-row textarea {
                      flex: 1;
                  }
                  label {
                      margin-bottom: 8px;
                      font-weight: bold;
                  }
                  input[type="text"],
                  input[type="email"],
                  input[type="date"],
                  input[type="number"],
                  textarea {
                      padding: 10px;
                      border: 1px solid #ccc;
                      border-radius: 5px;
                      font-size: 16px;
                  }
                  input[type="submit"] {
                      background-color: #007bff;
                      color: #fff;
                      border: none;
                      padding: 12px 20px;
                      border-radius: 5px;
                      font-size: 16px;
                      cursor: pointer;
                  }
                  input[type="submit"]:hover {
                      background-color: #0056b3;
                  }

            /* Request List Css */
           /* Button group container */
           .button-group {
               display: flex;
               gap: 10px; /* Add gap between buttons */
           }

           /* Button styling */
           .btn {
               padding: 10px 20px;
               font-size: 14px;
               font-weight: bold;
               text-decoration: none;
               text-align: center;
               border-radius: 4px;
               transition: background-color 0.3s ease;
               border: 1px solid transparent; /* Add border */
           }

           .accept-btn {
               background-color: #28a745; /* Green color for accept */
               color: #fff;
           }

           .reject-btn {
               background-color: #dc3545; /* Red color for reject */
               color: #fff;
           }

           .rejected-btn {
               background-color: #6c757d; /* Gray color for rejected */
               color: #fff;
           }

           .accepted-btn {
               background-color: #007bff; /* Blue color for accepted */
               color: #fff;
           }

           /* Hover effect */
           .btn:hover {
               opacity: 0.8;
           }

           /* Active effect */
           .btn:active {
               transform: translateY(1px);
           }

           /* Add border color on hover and focus */
           .btn:hover,
           .btn:focus {
               border-color: #adb5bd; /* Light gray */
           }

            /* CSS for filter & sorting */
            .action-buttons {
                margin-bottom: 20px;
                margin-left: 50px;
            }

            .action-buttons form {
                display: inline-block;
                margin-right: 20px;
            }

            .action-buttons select {
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .action-buttons input[type="text"] {
                padding: 8px;
                width: 150px;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin-right: 5px;
            }

            .action-buttons button {
                padding: 8px 15px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .action-buttons button:hover {
                background-color: #45a049;
            }




        /* Footer styles */
        footer {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

    </style>
</head>
<body>
    <div class="container">
        <header>
            <nav class="navbar">
                <div class="logo">
                    <a href="#">Blood Bank</a>
                </div>
                <div class="user-info">
                    <span>Welcome, ${data   .name} </span>
                    <a href="/logout" class="logout">Logout</a>
                </div>
            </nav>
        </header>