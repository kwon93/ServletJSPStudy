package com.kdh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

@WebServlet("/hihi")
public class Nana extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8"); //브라우저에게 서버의 응답은 html형식이며 utf-8로 언어를 읽으라고 응답해줌.
		//쿼리스트링이 없을경우 /hihi 접속시 nullPointException이 뜬다. 요청값이 없기때문. 
		//그렇기 때문에 조건문을 넣어서 매개변수가 있을경우에 요청에 따른 응답을 할수있도록 프로그램을 작성
		String temp = req.getParameter("cnt");
		int cnt = 0;
		
		
		
		PrintWriter out = resp.getWriter();
//		int cnt = Integer.parseInt(req.getParameter("cnt")); 쿼리스트링이 문자열이기때문에 인트형으로 변환
		if(temp != null) {
			cnt = Integer.parseInt(temp);
			
			for (int i = 0; i < cnt; i++) {
				out.println((i+1)+" 안녕하세요. Servlet <br/>");
			}
		}else {
			for (int i = 0; i < 100; i++) {
				out.println((i+1)+" 안녕 Servlet <br/>");
			}	
		}
		
	}
}
