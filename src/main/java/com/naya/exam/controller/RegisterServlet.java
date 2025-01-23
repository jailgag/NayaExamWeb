package com.naya.exam.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.naya.exam.model.service.MemberService;
import com.naya.exam.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/register.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId= request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName") ;
		String gender= request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age")); //다시작성!!오키!!!
		Member member = new Member(memberId, memberPwd, memberName, gender, age);
		MemberService mService = new MemberService(); //이걸 new MemberService() null;로 설정 안적었었음!!! 
		int result = mService.registerMember(member);
		if(result > 0) {
			//성공
			response.sendRedirect("/");
		}else {
			//실패
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp") //경로 설정 common 할때 추가!!
			.forward(request, response);
			
		}
	}

}
