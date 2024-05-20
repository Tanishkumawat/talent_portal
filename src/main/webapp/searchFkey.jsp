<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
    <link rel="icon" href="img/teacher.png" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
    margin: 0;
    border: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
    background-color: #333333;
background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100%25' height='100%25' viewBox='0 0 800 400'%3E%3Cdefs%3E%3CradialGradient id='a' cx='396' cy='281' r='514' gradientUnits='userSpaceOnUse'%3E%3Cstop offset='0' stop-color='%23006AB0'/%3E%3Cstop offset='1' stop-color='%23333333'/%3E%3C/radialGradient%3E%3ClinearGradient id='b' gradientUnits='userSpaceOnUse' x1='400' y1='148' x2='400' y2='333'%3E%3Cstop offset='0' stop-color='%23C7C7C7' stop-opacity='0'/%3E%3Cstop offset='1' stop-color='%23C7C7C7' stop-opacity='0.5'/%3E%3C/linearGradient%3E%3C/defs%3E%3Crect fill='url(%23a)' width='800' height='400'/%3E%3Cg fill-opacity='0.36'%3E%3Ccircle fill='url(%23b)' cx='267.5' cy='61' r='300'/%3E%3Ccircle fill='url(%23b)' cx='532.5' cy='61' r='300'/%3E%3Ccircle fill='url(%23b)' cx='400' cy='30' r='300'/%3E%3C/g%3E%3C/svg%3E");
background-attachment: fixed;
background-size: cover;
}
 
form{
    background: rgba( 255, 255, 255, 0.25 );
box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
backdrop-filter: blur( 4px );
-webkit-backdrop-filter: blur( 4px );
border-radius: 10px;
border: 1px solid rgba( 255, 255, 255, 0.18 );
width: 30rem;
height: 30rem;
margin-left: 28%;
margin-top: 5rem;
}
.form-txt{
    display: block;
    width: 80%;
    background: white;
    border: none;
    padding: 15px 15px;
    border-radius: 20px;
    margin-top: 20px;
    box-shadow: #cff0ff 0px 10px 10px -5px;
}
.btn-form{
    display: block;
    width: 50%;
    font-weight: bold;
    background: linear-gradient(45deg, rgb(16, 137, 211) 0%, rgb(18, 177, 209) 100%);
    color: white;
    padding-block: 15px;
    border-radius: 20px;
    margin-top: 30px;
    margin-left: 25%;
    margin-bottom: 5rem;
    box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 20px 10px -15px;
    border: none
}
img{
    margin-left: 30%;
    width: 11rem;
    height: 10rem;
    padding: 10px;
}
    </style>
</head>

<body>
    <div class="container">
    <h1 class="custom-head text-white" style="margin-top: 1rem; margin-left: 12%;">Welcome to Acropolis College Management System <button type="button" class="btn btn-outline-primary back-btn" onclick="redirectToPage()">Back</button></h1>
    <form action="/CollegeManagement/getFkey" method="post">
        <img src="img/teacher.png" alt="" class="img-fluid">
        <h2 style="font-weight: bolder; margin-left: 9%;">Enter Enrollment Number</h2><br> 
        <input type="text" name="enrollmentNumber" style="margin-left: 10%; " class="form-txt" placeholder="Enter Enrollment Number"><br>
        <input type="submit" value="Submit" class="btn-form">
    </form>
    </div>

    <script>
        function redirectToPage() {
          // Redirect to the desired page
            window.location.href = "home.html"; // Change the URL to the desired destination
        }
    </script>
</body>
</html>