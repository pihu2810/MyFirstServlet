package com.login;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(

	description="Login Servlet Testing",
	urlPatterns={"/LoginServlet"},
	initParams= {
			@WebInitParam(name="user",value="Vish"),
			@WebInitParam(name="password",value="pihu@143"),
	}
	)

  public class LoginServlet extends HttpServlet {
			@Override
			protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
				//get request for user id n pwd
				String user=request.getParameter("username");
				String pwd=request.getParameter("password");
				//get servlet config init params
				String userID=getServletConfig().getInitParameter("user");
				String password=getServletConfig().getInitParameter("password");
				if(userID.equals(user)&&password.equals(password)) {
					request.setAttribute("user",user);
					request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
				}
				else {
					RequestDispatcher rd =getServletContext().getRequestDispatcher("/login.html");
					PrintWriter out =response.getWriter();
					out.println("<font color=red>Either user name or password is wrong.</font>");
					rd.include(request, response);
				}
			}

}
