package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")	//xml에서 직접 매핑할 수도 있지만 최근 추세는 어노테이션 이용해서 맵핑함
public class Nana extends HttpServlet
{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//int cnt = Integer.parseInt(request.getParameter("cnt"));	//get 요청과 쿼리스트링
		
		//기본값 사용하기(쿼리스트링 값이 ""이거나 null 일 때 처리방법)
		String cnt_ = request.getParameter("cnt");
		
		int cnt = 30;
		if(cnt_ != null && !cnt_.contentEquals(""))
			cnt = Integer.parseInt(cnt_);
		
		for(int i=0; i<cnt; i++) {
			out.println((i+1)+": 안녕 서블릿!!<br>");
		}
	}
		
}
