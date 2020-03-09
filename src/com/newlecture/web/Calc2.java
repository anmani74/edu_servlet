package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿컨텍스트 만들기
		ServletContext application = request.getServletContext();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.parseInt(v_);
		
		if(op.equals("=")) {
			// 입력된 op 값이 = 이면 입력된 값 계산하기
			int x = (Integer)application.getAttribute("value");
			int y = v;
			String operator = (String)application.getAttribute("op");
			
			int result = 0;
			
			if(operator.equals("+"))
				result = x + y;
			else
				result = x - y;
			
			response.getWriter().printf("result is %d\n", result);
		}
		else {//저장하기
			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}
		
	}

	
	

}
