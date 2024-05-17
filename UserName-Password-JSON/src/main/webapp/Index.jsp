<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Json Example</title>
    <style>
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 200px;
            padding: 5px;
            margin-bottom: 10px;
        }
        #submit {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        #submit:hover {
            background-color: #45a049;
        }
    </style>
</head>
 <body>
        <form id="form">
            <input type="text" placeholder="Enter Name" name="name" id="name"><br><br>
            <input type="text" placeholder="Enter Address" name="address" id="address"><br><br>
            <input type="text" placeholder="Enter city" name="city" id="city"><br><br>
            
            <input type="button" value="Submit" id="submit"><br>
        </form>
        <p id="result"></p>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#submit").click(function() {
                // get inputs
                var userName = $('#name').val();
                var userAdd = $('#address').val();
                var userCity=  $('#city').val();

                if(userName==="" || userAdd==="" || userCity===""){
                    alert("All Fields Are Mandatory.");
                }
                else
                {
                              //var jsonData = {
  				//name : name,
                                //address:address
   				//}; 
                    var myVar = JSON.stringify({name: userName, address: userAdd, city:userCity });
                    // or  var myJSON = JSON.stringify(jsonData);
                    alert(myVar);
                    $.ajax({
                        url: 'JsonServlet',
                        type: 'POST',
                        data: 'para=' + myVar,//sending json data
                        dataType: 'json',
                        //contentType: 'application/json',
                        //mimeType: 'application/json',
                    success: function(data) {
                        //just for printing purpose
                        var json = JSON.stringify(data);
                        alert(json + " " + data.name + " " + data.address  + " " + data.city);
                        $("#result").html(data.name + " " + data.address  + " " + data.city);
                    },
                    error: function(data) {
                        alert("fail");
                    }
                });
            }
           });
        });
    </script>
</body>
</html>
