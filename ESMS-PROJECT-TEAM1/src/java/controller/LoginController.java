/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class LoginController extends HttpServlet {

    private static final String LOGIN_PAGE = "Login.jsp";

    private static final String STUDENT = "Student";
    private static final String STUDENT_PAGE = "StudentHome.jsp";

    private static final String TEARCHER = "Teacher";
    private static final String TEARCHER_PAGE = "TeacherHome.jsp";

    private static final String TESTING_STAFF = "TestingStaff";
    private static final String TESTING_STAFF_PAGE = "TestingStaff.jsp";

    private static final String TESTING_ADMIN = "TestingAdmin";
    private static final String TESTING_ADMIN_PAGE = "TestingAdmin.jsp";

    private static final String ADMIN = "Admin";
    private static final String ADMIN_PAGE = "Admin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            UserDTO user = null;
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UserDAO dao = new UserDAO();
            user = dao.Login(email, password);
            if (user == null) {
                url = LOGIN_PAGE;
                request.setAttribute("MESSAGE", "Incorect Email or Password");
            } else {
                String role = user.getRole();
                HttpSession session = request.getSession();
                session.setAttribute("USER", user);
                if (role.equals(STUDENT)) {
                    url = STUDENT_PAGE;
                } else if (role.equals(TEARCHER)) {
                    url = TEARCHER_PAGE;
                } else if (role.equals(TESTING_STAFF)) {
                    url = TESTING_STAFF_PAGE;
                } else if (role.equals(TESTING_ADMIN)) {
                    url = TESTING_ADMIN_PAGE;
                } else if (role.equals(ADMIN)) {
                    url = ADMIN_PAGE;
                }
            }
        } catch (Exception e) {
            log("Error at LoginController!" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
