package com.kdh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calculator extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("-UTF-8");
		resp.setContentType("text/html; charset=UTF-8; ");

		PrintWriter out = resp.getWriter();
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String op = req.getParameter("operator");
	
		
		if(!x_.equals("") && !y_.equals("")) {
			int x = Integer.parseInt(req.getParameter("x"));
			int y = Integer.parseInt(req.getParameter("y"));
			if(op.equals("덧셈")) { //html에서 input의 name의 value가 덧셈이라면 덧셈 실행 아니라면 뺄셈실행
				out.print(x+y);
			}else if(op.equals("뺄셈")) {
				out.print(x-y);
			}
			
		}else {
			out.print("입력을 해주세요.");
		}
		
		
		
	}
}
