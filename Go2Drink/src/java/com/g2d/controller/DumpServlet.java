/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g2d.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.font.EAttribute;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "DumpServlet", urlPatterns = {"/DumpServlet"})
public class DumpServlet extends HttpServlet {

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
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DumpServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DumpServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>URL Path:"+ request.getRequestURL()+"</p>");
            out.println("<table boder='1'>");
            out.println("<caption>Header List</caption>");
            out.println("<tr><td>Name</td><td>Value</td></tr>");
            Enumeration<String> headerNames= request.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String name = headerNames.nextElement();
                String value = request.getHeader(name);
                out.println("<tr><td>"+ name+"</td><td>"+value+"</td></tr>");
            }
            out.println("</table><br><br>");
                //
            out.println("</table border='1'>");
            out.println("<caption>表格</caption>");
            out.println("<tr><td>Name</td><td>Value</td></tr>");
            Enumeration<String> paraNames= request.getParameterNames();
            while(headerNames.hasMoreElements()){
                String name = paraNames.nextElement();
                String value = request.getParameter(name);
                out.println("<tr><td>"+ name+"</td><td>"+value+"</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
