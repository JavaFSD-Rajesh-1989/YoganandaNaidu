package com.case_study_practise.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.case_study_practise.model.User;
import com.case_study_practise.service.UserServiceInterface;
import com.case_study_practise.util.ServiceFactory;


public class UserServlet extends HttpServlet{
	
	
	public UserServlet() {
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String taskType = request.getParameter("taskType");
		
		  if ("login".equals(taskType)) {
		        String email = request.getParameter("email");
		        String password = request.getParameter("password");

		        // Creating object of the buyer
		        User user = new User();
		        user.setEmail(email);
		        user.setPassword(password);


		        UserServiceInterface userService = ServiceFactory.UserObject("buyer");


		        User loggedUser = userService.LoginUser(user);

		        if (loggedUser != null) {
		            HttpSession session = request.getSession(true);
		            session.setAttribute("userId", loggedUser.getUserId()); 
		            session.setAttribute("email", loggedUser.getEmail());
		            session.setAttribute("password", loggedUser.getPassword());
		            session.setAttribute("name", loggedUser.getUsername());

		            RequestDispatcher rd = getServletContext().getRequestDispatcher("/buyerHomepage.jsp");
		            rd.forward(request, response);
		        } else {
		            request.setAttribute("error", "Invalid email or password");
		            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
		            rd.forward(request, response);
		        }
		    }

		
		if(taskType.equals("register")) {
//			Long userId = request.getParameter("userId"); 
			String name = request.getParameter("name");
			String email = request.getParameter("email"); 
			String password = request.getParameter("password"); 

			User user = new User(); 
//			user.setUserId(userId);
			user.setUsername(name); 
			user.setEmail(email); 
			user.setPassword(password); 
 
			
			try {
			UserServiceInterface userService = ServiceFactory.UserObject("buyer"); 
			
			User registeredUser = userService.LoginUser(user);
			
			if (registeredUser != null) {
				
				response.setContentType("text/html");
				response.getWriter().println("<script type='text/javascript'>");
				response.getWriter().println("alert('Registration successful! Please log in.');");
				response.getWriter().println("window.location.href = 'login.jsp';");
				response.getWriter().println("</script>");
			} else {
				
				response.setContentType("text/html");
               response.getWriter().println("<script type='text/javascript'>");
               response.getWriter().println("alert('Email already exists in the database.\\n Click OK to Login now :)');");
               response.getWriter().println("window.location.href = 'login.jsp';");
               response.getWriter().println("</script>");
				}
			}catch(Exception e) {
				
				e.printStackTrace(); // Log the error for debugging purposes
       	    response.setContentType("text/html");
       	    response.getWriter().println("<script type='text/javascript'>");
       	    response.getWriter().println("alert('An unexpected error occurred during registration. Please try again later.');");
       	    response.getWriter().println("window.location.href = 'retailerRegister.jsp';");
       	    response.getWriter().println("</script>");
			}
		}
			

	        
	        if("logout".equals(taskType)) {
	        	
	        	 HttpSession session = request.getSession(false);
	             if (session != null) {
	                 session.invalidate();
	             }
	             response.sendRedirect("login.jsp"); 
	        }
	        
	        
	}
	

}
