package com.kdh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator1")
public class Calculator1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{	
		super.service(req, resp);	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		out.write("<form method=\"post\">");
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		
		String value = req.getParameter("value");
		String operator = req.getParameter("operator");
		String dot = req.getParameter("dot");
		
		String exp = "";
		if(cookies != null) 
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();	
					break;
				}
			}
		
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		else if(operator != null && operator.equals("C")) {
			exp = "";
		}
		else {
			exp += (value == null)? "":value;
			exp += (operator == null)? "":operator;
			exp += (dot == null)? "":dot;	
		}
		
		Cookie expCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C")) {
		expCookie .setMaxAge(0);
		}
		expCookie.setPath("/calculator1");
		resp.addCookie(expCookie);
		resp.sendRedirect("calculator1"); 
	
	}
	
	//get과 post형식을 같이 쓴다면 service함수에 조건문을 넣어 오버라이드하고 super는 지운다.
}


