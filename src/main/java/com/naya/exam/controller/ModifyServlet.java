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
 * Servlet implementation class ModifyServlet
 */

// Cannot invoke "com.naya.exam.model.vo.Member.getMemberId()" because the return value of "jakarta.servlet.http.HttpSession.getAttribute(String)" is null

@WebServlet("/member/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService mService = new MemberService();
		HttpSession session = request.getSession();
		String memberId =((Member)session.getAttribute("member")).getMemberId();  //더적을거있음!!!
		Member member = mService.selectOneById(memberId);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/member/modify.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hooby = request.getParameter("hobby");
		Member member = new Member(memberId, email, phone, address, hooby);
		MemberService mService = new MemberService();
		int result = mService.updateMember(member);
		if(result >0) {
			//성공
			response.sendRedirect("/");
		}else {
			//실패
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	}

}
