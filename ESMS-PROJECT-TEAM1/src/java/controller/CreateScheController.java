///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.Map;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import dao.*;
//import dto.*;
//import dao.UserDAO;
//
//import java.time.LocalTime;
//import java.util.Date;
//import java.text.SimpleDateFormat;
//import dto.UserDTO;
//
///**
// *
// * @author Admin
// */
//public class CreateScheController extends HttpServlet {
//private static final String ERROR = "create.jsp";
//    private static final String SUCCESS = "TestingStaff.jsp";
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        String url = ERROR;
//        StudentExamDTO StudentExam = new StudentExamDTO();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try  {
//              StudentExamDAO dao = new StudentExamDAO();
//            boolean checkValidation = true;
//            String SubjectID = request.getParameter("Subject_ID");
//            String StartTime = request.getParameter("StartTime");
//            String EndTime = request.getParameter("EndTime");
//            String DateString = request.getParameter("Date");
//            Date dob = null;
//            dob = dateFormat.parse("DateString");
//            int Room =Integer.parseInt(request.getParameter("Room"));
//            String Campus = request.getParameter("Campus");
//            String Form = request.getParameter("Form");
//            
//            
//            
// 
//            
//            if(SubjectID.length() < 2 || SubjectID.length() > 10){
//                StudentExam.setSubjectID("SubjectID must be in [2,10]");
//                checkValidation = false;
//            }
//           
//           
//           
//           
//           
//                   
//           if(checkValidation){
//               StudentExamDTO StuExam = new StudentExamDTO(SubjectID, StartTime, EndTime, Date, Room,Campus,Form);
//               boolean checkInsert = dao.insert(StuExam);
//               if(checkInsert){
//                   url = SUCCESS;
//                   request.setAttribute("ERROR", "Account "+ userID +" has been created succesfully!");
//                   
//               }else{
//                   userError.setError("Unknown error");
//                   request.setAttribute("USER_ERROR", userError);
//               }
//           } else{
//               request.setAttribute("USER_ERROR", userError);
//           }
//           
//           
//            
//            
//        } catch (Exception e) {
//            log("ERROR at Create Controller " + e.toString());
//        }finally{
//            request.getRequestDispatcher(url).forward(request, response);
//        }
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
