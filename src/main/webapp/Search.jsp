<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Faculty</title>
    <link rel="icon" href="img/teacher.png" type="image/x-icon">
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
 table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        td{
            color:#ffffff;
        }
.search-box{
    font-size: 20px;
    border-radius:15px;    
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="custom-head text-white" style="margin-top: 1rem; margin-left: 12%;">Welcome to Acropolis College Management System <button type="button" class="btn btn-outline-primary back-btn" onclick="redirectToPage()">Back</button></h1>
    <p class="text-white fs-4" style="margin-top: 1rem; margin-bottom: 1rem;">Faculty Search <input type="text" id="searchInput" onkeyup="searchTable()" placeholder="Search for Faculty.." class="search-box"></p> 
    
    <table border="1" id="facultyTable">
        <tr>
            <th>Faculty Enrollment No.</th>
            <th>Faculty Name</th>
            <th>Contact</th>
            <th>Email</th>
            <th>DOB</th>
            <th>Department</th>
            <th>Position</th>
            <th>Join Date</th>
            <th>Salary</th>
            <th>Experience</th>
            <th>Gender</th>
            <th>State</th>
            <th>City</th>
            <th>Password</th>
        </tr>
        <% try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clgmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL", "root","root");
            Statement smt = con.createStatement();
            String str = "select * from faculty";
            ResultSet rs = smt.executeQuery(str);
            while(rs.next()){ %>
                <tr>
                    <td><%= rs.getString("fenroll") %></td>
                    <td><%= rs.getString("fname") %></td>
                    <td><%= rs.getString("contact") %></td>
                    <td><%= rs.getString("email") %></td>
                    <td><%= rs.getString("dob") %></td>
                    <td><%= rs.getString("department") %></td>
                    <td><%= rs.getString("position") %></td>
                    <td><%= rs.getString("jdate") %></td>
                    <td><%= rs.getString("salary") %></td>
                    <td><%= rs.getString("experience") %></td>
                    <td><%= rs.getString("gender") %></td>
                    <td><%= rs.getString("state") %></td>
                    <td><%= rs.getString("city") %></td>
                    <td><%= rs.getString("password") %></td>
                </tr>
        <%   }
            } catch(Exception e){ }
        %>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script>
    function searchTable() {
        // Declare variables
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("searchInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("facultyTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td");
            for (var j = 0; j < td.length; j++) {
                if (td[j]) {
                    txtValue = td[j].textContent || td[j].innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                        break;
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    }

    function redirectToPage() {
        // Redirect to the desired page
        window.location.href = "home.html"; // Change the URL to the desired destination
    }
</script>
</body>
</html>
