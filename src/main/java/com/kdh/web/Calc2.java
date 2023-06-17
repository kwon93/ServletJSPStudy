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

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("-UTF-8");
		resp.setContentType("text/html; charset=UTF-8; ");
		ServletContext app = req.getServletContext(); //application 저장소 
		HttpSession session =  req.getSession(); //세션이란 현재 접속한 사용자 현재 접속자마다 그 공간이 달라진다.
		Cookie[] cookies = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
	
		int v = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		//계산
		if(op.equals("=")) {
//			int x = (Integer) app.getAttribute("value1");
//			int x = (Integer) session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());	
					break;
				}
			}
			int y = v;
//			String operator = (String) app.getAttribute("op");
//			String operator = (String) session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();	
					break;
				}
			}
			int result = 0;
			
			if(operator.equals("+")) {
				result = x+y;
			}else {
				result = x-y;
			}
			out.print(result);
		//값을 저장
		}else {
//		app.setAttribute("value", v); // map 컬렉션처럼 키 밸류값을 넣는다.
//		app.setAttribute("op", op);
//		session.setAttribute("value", v);
//		session.setAttribute("op", op);	
			
		Cookie valueCookie = new Cookie("value", String.valueOf(v));	
		Cookie opCookie = new Cookie("op", op);	
		valueCookie.setPath("/calc2");
		valueCookie.setMaxAge(24*60*60);//쿠키가 만료되는 시간 (브라우저가 꺼져도 쿠키는 외부파일에 만료시간만큼 존재한다)
		opCookie.setPath("/calc2"); //특정경로로만 쿠키를 전달할 때 
		resp.addCookie(valueCookie);
		resp.addCookie(opCookie);
		
		resp.sendRedirect("calc2.html"); 
		
		}
		
		
		
		
		
	}
}
