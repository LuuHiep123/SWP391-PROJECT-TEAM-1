/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class MainController extends HttpServlet {

    private static final String LOGINPAGE = "Login.jsp";

    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";

    private static final String GETSTUDENTEXAM = "GetStudentExam";
    private static final String GETSTUDENTEXAM_CONTROLLER = "StudentExamController";

    private static final String GET_TEACHER_EXAM = "GetTeacherExamSchedule";
    private static final String GET_TEACHER_EXAM_CONTROLLER = "TeacherExamScheduleController";

    private static final String SEARCH_KEY_SUBJECT = "SearchKeySubject";
    private static final String SEARCH_KEY_SUBJECT_CONTROLLLER = "SearchKeySubjectController";

    private static final String SEARCH_KEY_SUBJECT_TEACHER = "Search";
    private static final String SEARCH_KEY_SUBJECT_TEACHER_CONTROLLLER = "SearchKeySubjectTeacherController";

    private static final String SORT_BY_DATE = "SortByDate";
    private static final String SORT_BY_DATE_CONTROLLLER = "SortByDateController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGINPAGE;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOGINPAGE;
            } else if (action.equals(LOGIN)) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals(SEARCH_KEY_SUBJECT)) {
                url = SEARCH_KEY_SUBJECT_CONTROLLLER;
            } else if (action.equals(GETSTUDENTEXAM)) {
                url = GETSTUDENTEXAM_CONTROLLER;
            } else if (action.equals(GET_TEACHER_EXAM)) {
                url = GET_TEACHER_EXAM_CONTROLLER;
            } else if (action.equals(SEARCH_KEY_SUBJECT_TEACHER)) {
                url = SEARCH_KEY_SUBJECT_TEACHER_CONTROLLLER;
            } else if (action.equals(SORT_BY_DATE)) {
                url = SORT_BY_DATE_CONTROLLLER;
            }

        } catch (Exception e) {
            e.printStackTrace();
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
