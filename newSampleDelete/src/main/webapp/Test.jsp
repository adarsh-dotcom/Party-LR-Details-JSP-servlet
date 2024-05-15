<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css"> body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
}

.result-container {
    max-width: 400px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
}

h2 {
    text-align: center;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 5px;
}

input {
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
}

button {
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
  <div class="container">
        <h2>eWay Bill </h2>
        <form action="SubmitFormData" method="post">
            <label for="clientId">Client ID:</label>
            <input type="text" id="clientId" name="clientId" required>

            <label for="clientSecret">Client Secret:</label>
            <input type="password" id="clientSecret" name="clientSecret" required>

            <label for="gstin">GSTIN:</label>
            <input type="text" id="gstin" name="gstin" required>

            <button type="submit">Submit</button>
        </form>
    </div>

</body>
</html>