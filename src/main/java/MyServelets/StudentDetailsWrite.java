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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class StudentDetailsWrite extends HttpServlet {

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
        String eno = request.getParameter("Enrollment-No.");
        String pass = request.getParameter("Password");
        String fname = request.getParameter("First-name");
        String lname = request.getParameter("Last-name");
        String faname = request.getParameter("Father-name");
        String mname = request.getParameter("Mother-name");
        String program = request.getParameter("Program");
        String branch = request.getParameter("Branch");
        String classn = request.getParameter("Class");
        String sem = request.getParameter("Sem");
        String gender = request.getParameter("Gender");
        String email = request.getParameter("Email-ID");
        String state = request.getParameter("State ");
        String city = request.getParameter("City ");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clgmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL", "root","root");
        String query = "INSERT INTO student (enrollment, fname, lname, faname, mname, program, branch, class, sem, gender, email, state, city, password) "
                + "VALUES ('"+eno+"', '"+fname+"', '"+lname+"', '"+faname+"', '"+mname+"', '"+program+"', '"+branch+"', '"+classn+"', '"+sem+"', '"+gender+"', '"+email+"', '"+state+"', '"+city+"', '"+pass+"')";
        
        smt = con.createStatement();
        int rowsInserted = smt.executeUpdate(query);
        
        if (rowsInserted > 0) {
            out.println(" <script> alert('Student Details Saved Successfully'); </script>");
            RequestDispatcher rd = request.getRequestDispatcher("add-student.html");
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
