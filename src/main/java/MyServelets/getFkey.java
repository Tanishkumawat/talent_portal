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

/**
 *
 * @author ASUS
 */
public class getFkey extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String enrollmentNumber = request.getParameter("enrollmentNumber");
        
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/clgmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "root";
        
        // SQL query to retrieve student details based on enrollment number
        String sql = "SELECT * FROM faculty WHERE fenroll = ?";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, enrollmentNumber);
            
            // Execute the query
            ResultSet result = statement.executeQuery();
            
            if (result.next()) {
                // Forward the request to a JSP page
                request.setAttribute("enrollment", result.getString("fenroll"));
                request.setAttribute("fname", result.getString("fname"));
                request.setAttribute("contact", result.getString("contact"));
                request.setAttribute("email", result.getString("email"));
                request.setAttribute("dob", result.getString("dob"));
                request.setAttribute("department", result.getString("department"));
                request.setAttribute("position", result.getString("position"));
                request.setAttribute("jdate", result.getString("jdate"));
                request.setAttribute("salary", result.getString("salary"));
                request.setAttribute("experience", result.getString("experience"));
                request.setAttribute("gender", result.getString("gender"));
                request.setAttribute("state", result.getString("state"));
                request.setAttribute("city", result.getString("city"));
                request.setAttribute("password", result.getString("password"));

                request.getRequestDispatcher("displayFacultyDetails.jsp").forward(request, response);
            } else {
                response.getWriter().println("Faculty not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getSkey.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
