<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src ="lrjson.js" type="text/javascript"></script>
 <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
        <h1>Party Details</h1>
        <form action="partyDet" method="post">
            <label for="partyCode">Party Code:</label>
            <input type="text" id="partyCode" name="Party_code" required>
           
            <label for="partyName">Party Name:</label>
            <input type="text" id="partyName" name="Party_Name" required>

            <label for="address">Address:</label>
            <input type="text" id="address" name="Address" required>

            <label for="GSTn">GSTn:</label>
            <input type="text" id="GSTn" name="GsTn" required >

            <label for="state">State:</label>
            <input type="text" id="state" name="State" required>
            
            
            <label for="pincode">Pincode:</label>
            <input type="number" id="pincode" name="Pincode" required>

          <input type="submit" value="Save" onclick="showAlert()">

           
        </form>
    </div>
    
    
    
   
    

</body>
</html>