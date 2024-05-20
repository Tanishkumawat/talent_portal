/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package MyServelets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class getSkey extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enrollmentNumber = request.getParameter("enrollmentNumber");
        
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/clgmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "root";
        
        // SQL query to retrieve student details based on enrollment number
        String sql = "SELECT * FROM student WHERE enrollment = ?";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, enrollmentNumber);
            
            // Execute the query
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                // Forward the request to a JSP page
                request.setAttribute("enrollment", result.getString("enrollment"));
                request.setAttribute("fname", result.getString("fname"));
                request.setAttribute("lname", result.getString("lname"));
                request.setAttribute("faname", result.getString("faname"));
                request.setAttribute("mname", result.getString("mname"));
                request.setAttribute("program", result.getString("program"));
                request.setAttribute("branch", result.getString("branch"));
                request.setAttribute("classn", result.getString("class"));
                request.setAttribute("sem", result.getString("sem"));
                request.setAttribute("gender", result.getString("gender"));
                request.setAttribute("email", result.getString("email"));
                request.setAttribute("state", result.getString("state"));
                request.setAttribute("city", result.getString("city"));
                request.setAttribute("password", result.getString("password"));

                request.getRequestDispatcher("displayStudentDetails.jsp").forward(request, response);
            } else {
                response.getWriter().println("Student not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSkey.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
