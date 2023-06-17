package com.kdh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calcpage")
public class Calcpage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("-UTF-8");
		resp.setContentType("text/html; charset=UTF-8; ");
		PrintWriter out =  resp.getWriter();
		Cookie[] cookies = req.getCookies();
		String exp = "0";
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();	
					break;
				}
			}
			
		}
		
		
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<style>");
		out.write("input{");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("}");	
		out.write(".output{");
		out.write("height:50px;");
		out.write("background: #e9e9e9;");
		out.write("font-size: 24px;");
		out.write("font-weight: bold;");
		out.write("text-align: right;");
		out.write("padding-right: 10px;");
		out.write("width: 100px;");
		out.write("}");
		out.write("</style>");	
		out.write("<body>");
		out.write("<form action=\"calc3\" method=\"post\">");
		out.write("<table>");
		out.write("<tr>");
		out.printf("<td colspan=\"4\" class=\"output\">%s</td>", exp);
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" value=\"CE\" name=\"operator\"></td>");
		out.write("<td><input type=\"submit\" value=\"C\" name=\"operator\"></td>");
		out.write("<td><input type=\"submit\" value=\"BS\" name=\"operator\"></td>");
		out.write("<td><input type=\"submit\" value=\"/\" name=\"operator\"></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" value=\"7\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"8\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"9\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"*\" name=\"operator\"></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" value=\"4\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"5\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"6\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"-\" name=\"operator\"></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td><input type=\"submit\" value=\"1\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"2\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"3\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\"+\" name=\"operator\"></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td></td>");
		out.write("<td><input type=\"submit\" value=\"0\" name=\"value\"></td>");
		out.write("<td><input type=\"submit\" value=\".\" name=\"dot\"></td>");
		out.write("<td><input type=\"submit\" value=\"=\" name=\"operator\"></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
		
		
		
		
	}
}
