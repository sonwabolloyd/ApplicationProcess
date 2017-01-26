/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogpost.javabrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lloyd
 */
public class XmlServlet extends HttpServlet {
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // doGet method is called when a get method is issued to the servlet
        // use Get when u want to get data from the application and u will pass parameters
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();
        if (userName != "" && userName != null){
        
        session.setAttribute("savedUserName", userName);
        }
        
        writer.println(" Request parameter has username as " + userName);
        writer.println(" Session parameter has username " + (String) session.getAttribute("savedUserName"));
        //out.println("Hello " + userName);
        
    }
     
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // the dopost methos is called when the post is issued to the servlet
       // the post method is used when u want post something to the server and the application has to do some write operator
       // get and post are standard http methods as per the protocol and each method has a particular function
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //String userName = request.getParameter("userName");
        //String fullName = request.getParameter("fullName");
        //out.println("Hello welcome to the web application " + userName + " We know your full name is " + fullName);
       // String prof = request.getParameter("prof");
        //out.println("you are a " + prof);
       // String location = request.getParameter("location");
        String [] location = request.getParameterValues("location");
        // length is a method 
        out.println("you are at " + location.length +  " places");
        
        for(int i=0; i<location.length; i++){
            out.println(location [i]);
        }
        
    }
    
}
    
