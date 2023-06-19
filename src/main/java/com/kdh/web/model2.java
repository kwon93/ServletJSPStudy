package com.kdh.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// model2는 Controller,model과 view 물리적으로 분리한다. 이쪽에서 model과 controller
@WebServlet("/model2")
public class model2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals("")){
			num = Integer.parseInt(num_);
		}
		
		String result;
		
		if(num % 2 != 0)
			result = "홀수";
		else
			result = "짝수";
		
		request.setAttribute("result", result);
		
		String[] names = {"expression", "language"};
		
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<>();
		notice.put("id", 1);
		notice.put("title", "EL is awsome");
		
		request.setAttribute("notice", notice);
		
		
		
		//redirect : 기존에 작업하고있던것을 새로운 요청
		//forward : 현재 작업하던것을 이어가도록 도와줌.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("model2.jsp"); // 이 경로로 요청이감.
		dispatcher.forward(request, response); // 현재 작업했던 내용들이 매개변수에 담겨져 있다면 
	}
}
