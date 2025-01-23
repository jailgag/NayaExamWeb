package com.naya.exam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.naya.exam.model.service.MemberService;
import com.naya.exam.model.vo.Member;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/member/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId =request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		Member member = new Member(memberId, memberPwd);
		MemberService mService = new MemberService();
		Member result = mService.selectOneByLogin(member);
		if(result != null) {
			//세센에 정보 저장후 메인페이지로 이동
			HttpSession session = request.getSession();
			session.setAttribute("member", result);
			response.sendRedirect("/");
		}else {
			//에러 페이지로 이동
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp") //
			.forward(request, response);
		}
	}

}
