
<%-- 
    Document   : index
    Created on : 30 Jul, 2018, 8:12:00 PM
    Author     : Dharmesh Mourya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #333;
	text-align: center;
}

form {
	margin-top: 10px;
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

input[type="button"] {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="button"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<div class="container">
		<form id="form">
			<h1>Party Details</h1>
			<label for="lrno">LR Number:</label><br> <input type="text"
				name="lrno" id="lrno"><br> <br> <label
				for="consigner">Consigner:</label><br> <input type="text"
				name="consigner" id="consigner"><br> <br> <label
				for="consignee">Consignee:</label><br> <input type="text"
				name="consignee" id="consignee"><br> <br> <label
				for="item">Item:</label><br> <input type="text" name="item"
				id="item"><br> <br> <label for="amount">Amount:</label><br>
			<input type="text" name="amount" id="amount"><br> <br>
			<input type="button" value="Submit" id="submit"><br>


		</form>

		<p id="result"></p>
	</div>

</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#submit")
								.click(
										function() {
											// get inputs
											var userlrno = $('#lrno').val();
											var userconsigner = $('#consigner ')
													.val();
											var userconsignee = $('#consignee ')
													.val();
											var useritem = $('#item').val();
											var useramount = $('#amount').val();

											if (userlrno === ""
													|| userconsigner === ""
													|| consignee === ""

													|| useritem === ""
													|| useramount === "") {
												alert("All Fields Are Mandatory.");
											} else {
												//var jsonData = {
												//name : name,
												//address:address
												//}; 
												var myVar = JSON.stringify({
													lrno : userlrno,
													consigner : userconsigner,
													consignee : userconsignee,
													item : useritem,
													amount : useramount
												});
												// or  var myJSON = JSON.stringify(jsonData);
												alert(myVar);
												
	$
														.ajax({
															url : 'JsonServlet',
															type : 'POST',
															data : 'para='
																	+ myVar,//sending json data
															dataType : 'json',
															//contentType: 'application/json',
															//mimeType: 'application/json',
															success : function(
																	data) {
																//just for printing purpose
																var json = JSON
																		.stringify(data);
																alert(json
																		+ " "
																		+ data.lrno
																		+ " "
																		+ data.consigner
																		+ " "
																		+ data.consignee
																		+ " "

																		+ data.item
																		+ " "
																		+ data.amount);
																$("#result")
																		.html(
																				data.lrno
																						+ " "
																						+ data.consigner
																						+ " "
																						+ data.item
																						+ " "
																						+ data.consignee
																						+ " "
																						+ data.amount);
															},
															error : function(
																	data) {
																alert("fail");
															}
														});
											}
										});
					});
</script>

</html>