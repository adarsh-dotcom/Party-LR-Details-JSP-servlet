<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            width: 80%;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #666;
        }
        input[type="text"] {
            width: calc(100% - 20px);
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
  <h1>LR Details</h1>
    <form action="lrDetails" method="post">
        <label for="lrNo">LR No:</label>
        <input type="text" id="lrNo" name="lrNo" required><br><br>
        
        <label for="consigner">Consigner:</label>
        <input type="text" id="consigner" name="consigner" required><br><br>
        
        <label for="consignee">Consignee:</label>
        <input type="text" id="consignee" name="consignee" required><br><br>
        
        <label for="item">Item:</label>
        <input type="text" id="item" name="item" required><br><br>
        
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" required><br><br>
        
        <input type="submit" value="Save">
    </form>
    
 
</body>
</html>