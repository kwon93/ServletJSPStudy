package com.kdh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc22")
public class Calculator2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("-UTF-8");
		resp.setContentType("text/html; charset=UTF-8; ");

		PrintWriter out = resp.getWriter();
		
		String[] num_ = req.getParameterValues("num");
		int result = 0;
		
		
		for (int i = 0; i < num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result += num;
		}
		out.print("합산값은 "+result + "입니다.");
	}
}
