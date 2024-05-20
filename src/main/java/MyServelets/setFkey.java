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
public class setFkey extends HttpServlet {

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
        Connection con = null;
    Statement smt = null;
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet StudentDetailsWrite</title>");            
        out.println("</head>");
        out.println("<body>");
        String eno = request.getParameter("Facultyeno");
        String pass = request.getParameter("Password");
        String fname = request.getParameter("Faculty-Name");
        String cno = request.getParameter("Contact-no");
        String email = request.getParameter("Email-ID");
        String dob = request.getParameter("Dob");
        String department = request.getParameter("Department");
        String position = request.getParameter("Position");
        String jdate = request.getParameter("Join-Date");
        String salary = request.getParameter("Salary");
        String experience = request.getParameter("Experience");
        String gender = request.getParameter("Gender");
        String state = request.getParameter("State ");
        String city = request.getParameter("City ");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clgmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL", "root","root");
       
        
        String query = "UPDATE faculty SET " +
               "fname = '"+fname+"', "+
               "contact = '"+cno+"', "+
               "email = '"+email+"', "+
               "dob = '"+dob+"', "+
               "department = '"+department+"', "+
               "position = '"+position+"', "+
               "jdate = '"+jdate+"', "+
               "salary = '"+salary+"', "+
               "experience = '"+experience+"', "+
               "gender = '"+gender+"', "+
               "state = '"+state+"', "+
               "city = '"+city+"', "+
               "password = '"+pass+"' "+
               "WHERE fenroll = '"+eno+"';";

        smt = con.createStatement();
        int rowsInserted = smt.executeUpdate(query);
        
        if (rowsInserted > 0) {
            out.println(" <script> alert('Student Details Saved Successfully'); </script>");
            RequestDispatcher rd = request.getRequestDispatcher("searchFkey.jsp");
                rd.forward(request, response);
            
        } else {
            out.println(" <script> alert('Failed to save Student Details'); </script>");
        }
        
        out.println("</body>");
        out.println("</html>");
    } catch (SQLException ex) {
        Logger.getLogger(StudentDetailsWrite.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDetailsWrite.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
            
            if (smt != null) {
                smt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDetailsWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
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
