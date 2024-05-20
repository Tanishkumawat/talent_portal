package MyServelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class FacultyDetailsWrite extends HttpServlet {

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
    PreparedStatement pstmt = null;
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet FacultyDetailsWrite</title>");            
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
        String query = "INSERT INTO faculty (fenroll, fname, contact, email, dob, department, position, jdate, salary, experience, gender, state, city, password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, eno);
        pstmt.setString(2, fname);
        pstmt.setString(3, cno);
        pstmt.setString(4, email);
        pstmt.setString(5, dob);
        pstmt.setString(6, department);
        pstmt.setString(7, position);
        pstmt.setString(8, jdate);
        pstmt.setString(9, salary);
        pstmt.setString(10, experience);
        pstmt.setString(11, gender);
        pstmt.setString(12, state);
        pstmt.setString(13, city);
        pstmt.setString(14, pass);

        int rowsInserted = pstmt.executeUpdate();
        
        if (rowsInserted > 0) {
            out.println("<script>alert('Faculty Details Saved Successfully');</script>");
            response.sendRedirect("add-faculty.html");
        } else {
            out.println("<script>alert('Failed to save Faculty Details');</script>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(FacultyDetailsWrite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDetailsWrite.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
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
