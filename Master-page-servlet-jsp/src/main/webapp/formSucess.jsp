<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration Success</title>
    <!-- Include SweetAlert library -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- Include custom CSS -->
    <link rel="stylesheet" href="styles.css">
    
   <style>
   
  .custom-swal-container {
    background-color: #f0f0f0;
}

.custom-swal-title {
    color: #007bff;
}

.custom-swal-content {
    color: #333;
}

.custom-swal-confirm {
    background-color: #007bff;
    color: #fff;
}

.custom-swal-footer {
    color: #007bff;
}
                      
   
   </style>
</head>
<body>
<script>
        // Simulate successful registration
        document.addEventListener('DOMContentLoaded', function () {
            Swal.fire({
                icon: 'success',
                title: 'User Registered Successful!',
                customClass: {
                    container: 'custom-swal-container',
                    title: 'custom-swal-title',
                    content: 'custom-swal-content',
                    confirmButton: 'custom-swal-confirm',
                    footer: 'custom-swal-footer'
                }
            });
        });
    </script>
</body>
</html>