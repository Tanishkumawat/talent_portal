<%-- 
    Document   : displayStudentDetails
    Created on : Feb 18, 2024, 4:48:35 PM
    Author     : ASUS
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
    <link rel="icon" href="img/student-100.png" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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

.custom-card{
    background: rgba( 255, 255, 255, 0.2 );
box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
backdrop-filter: blur( 6.5px );
-webkit-backdrop-filter: blur( 6.5px );
border-radius: 10px;
border: 1px solid rgba( 255, 255, 255, 0.18 );
width: 15rem;
}

.custom-card > img{
    width: 11rem;
    height: 10rem;
    padding: 10px;
}

.cust-link{
    text-decoration: none;
    color: black;
}

.cust-link:hover{
    color: #fff;
}

.custom-img > img{
    display: none;
    margin-right: auto;
    margin-top: 2.8rem;
}

.form-txt{
    display: block;
    width: 80%;
    background: white;
    border: none;
    padding: 15px 15px;
    border-radius: 20px;
    margin-top: 25px;
    box-shadow: #cff0ff 0px 10px 10px -5px;
    border-inline: 2px solid transparent;
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
    margin-left: 20%;
    margin-bottom: 5rem;
    box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 20px 10px -15px;
    border: none;
}

.back-btn{
    margin-left: 6rem;
}
    </style>
</head>
<body>
    <div class="container">

            <h1 class="custom-head text-white" style="margin-top: 1rem; margin-left: 12%;">Welcome to Acropolis College Management System <button type="button" class="btn btn-outline-primary back-btn" onclick="redirectToPage()">Back</button></h1>

        <div class="row">

            <div class="row">

                <div class="">
                    <h1 class="custom-head text-white" style=" margin-left: 45%;">Add Student</h1>
                </div>

                <div class="row ">
                    <form action="/CollegeManagement/setSkey" method="post"style="margin-left: 10%;" >

                        <div class="row">
                            <div class="col-6">
                                <input type="text" name="Enroll" placeholder="Enter Enrollment Number" required class="form-txt" value="${requestScope.enrollment}" >
                            </div>
                            <div class="col-6">
                                <input type="text" name="Password" placeholder="Enter Password" required class="form-txt" value="${requestScope.password}" >
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <input type="text" name="First-name" placeholder="Enter First Name" required class="form-txt" value="${requestScope.fname}">
                            </div>
                            <div class="col-6">
                                <input type="text" name="Last-name" placeholder="Enter Last Name" required class="form-txt" value="${requestScope.lname}">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <input type="text" name="Father-name" placeholder="Enter Father Name" required class="form-txt" value="${requestScope.faname}">
                            </div>
                            <div class="col-6">
                                <input type="text" name="Mother-name" placeholder="Enter Mother Name" required class="form-txt" value="${requestScope.mname}">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <input type="text" name="Program" placeholder="Enter Program Enrolled" required class="form-txt" value="${requestScope.program}">
                            </div>
                            <div class="col-6">
                                <input type="text" name="Branch" placeholder="Enter Branch" required class="form-txt" value="${requestScope.branch}">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <input type="text" name="Class" placeholder="Enter Class" required class="form-txt" value="${requestScope.classn}">
                            </div>
                            <div class="col-6">
                                <input type="text" name="Sem" placeholder="Enter Sem" required class="form-txt" value="${requestScope.sem}">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <input type="text" name="Gender" placeholder="Enter Gender" required class="form-txt" value="${requestScope.gender}">
                            </div>
                            <div class="col-6">
                                <input type="text" name="Email-ID" placeholder="Enter Email ID" required class="form-txt" value="${requestScope.email}">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-6">
                                <input type="text" name="State " placeholder="Enter State" required class="form-txt" value="${requestScope.state}">
                            </div>
                            <div class="col-6">
                                <input type="text" name="City " placeholder="Enter City" required class="form-txt" value="${requestScope.city}">
                            </div>
                        </div>
                        <button type="submit" class=" fs-5 form-btn  btn-resume-4 btn-form">Submit</button>
                    </form>
                </div>

            </div>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    
    <script>
    
        function redirectToPage() {
            // Redirect to the desired page
            window.location.href = "home.html"; // Change the URL to the desired destination
        }
    </script>
</body>
</html>
