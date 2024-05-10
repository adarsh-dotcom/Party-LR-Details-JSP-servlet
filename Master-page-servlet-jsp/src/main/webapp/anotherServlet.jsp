 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="lrjson.js" type="text/javascript"></script>
<meta charset="UTF-8">

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
}

.container {
	max-width: 400px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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

input #consigner {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="text"] {
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

select {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
</style>


</head>
<body>
	<div class="container">
		<h1>LR Details Form</h1>
		<form action="anotherServlet" method="post" id="myForm">


			<label for="lrNo">Lr No:</label> <input type="text" id="lrNo"
				name="lrNo" required><br> <label for="consigner">Consigner:</label>
			<%
			if ("dropdown".equals(request.getParameter("consigner"))) {
			%>
			<select name="consigner" id="consigner" required>
				<option value="">Select</option>
				<%
				List<String> partyCodes = (List<String>) request.getAttribute("partyCodes");
				for (int i = 0; i < partyCodes.size(); i++) {
				%>
				<option value="<%=partyCodes.get(i)%>"><%=partyCodes.get(i)%></option>
				<%
				}
				%>
			</select>
			<%
			} else {
			%>

			<%
			}
			%>
			<label for="consignee">Consignee:</label>
			<%
			if ("dropdown".equals(request.getParameter("consignee"))) {
			%>
			<select name="consignee" id="consignee" required>
				<option value="">Select</option>
				<%
				List<String> partyCodes = (List<String>) request.getAttribute("partyCodes");

				for (int i = 0; i < partyCodes.size(); i++) {
				%>
				<option value="<%=partyCodes.get(i)%>"><%=partyCodes.get(i)%></option>
				<%
				}
				%>
			</select>
			<%
			} else {
			%>


			<%
			}
			%>

			<label for="item">Item:</label> <input type="text" id="item"
				name="item" required><br> 
				<label for="amount">Amount:</label>
			<input type="text" id="amount" name="amount" required><br>

			<input type="submit" value="Save" onclick="showAlert">
		</form>
		<p id="result"></p>
	</div>
	
	
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
	$(document).ready (function(){
	$("submit").click(function() {
		var userlrno = $('#lrNo').val();
		var userconsigner = $('#consigner').val();
		var userconsignee = $('#consignee').val();
		var useritem = $('#item').val();
		var useramount = $('#amount').val();
		if(userlrno==="" || userconsigner==="" || userconsignee===""|| useritem===""||useramount==="")
		{
			alert("All field are mandatory");
			
		}
		else{
			
			var myVar = JSON.stringify({lrno:userlrno, consigner:userconsigner, consignee : userconsignee,item : useritem,amount :useramount });
			alert(myVar);
			$.ajax({
				url :'',
				type: 'POST',
				data: 'para='+myVar,
				dataType: 'json',
				
				success : function(data){
					//Print data
					var json = JSON.stringify(data);
					alert(json+" "+data.lrno+" "+data.consigner+" "+data.consignee+" "+data.item+" "+amount);
					
					$("result").html(data.lrno+" "+data.consigner+" "+data.consignee+" "+data.item+" "+amount);
					},
					error :function(data) {
						alert("fail");
						}
					});
					
				 }
			});
		});
				 







</body>










</html>
























