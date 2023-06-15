package com.kdh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		PrintWriter out = resp.getWriter();
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
	
		int v = 0;
		
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		//계산
		if(op.equals("=")) {
//			int x = (Integer) app.getAttribute("value1");
			int x = (Integer) session.getAttribute("value");
			int y = v;
//			String operator = (String) app.getAttribute("op");
			String operator = (String) session.getAttribute("op");
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
		session.setAttribute("value", v);
		session.setAttribute("op", op);	
		}
		
		
		
		
		
	}
}
