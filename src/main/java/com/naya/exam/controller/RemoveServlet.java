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
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/member/remove")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member"); //session cannot be resolved 대문자를 소문자로 바꿈..
		if(member != null) {
			MemberService mService = new MemberService();
			String memberId = member.getMemberId();
			int result = mService.deleteMember(memberId);
			if(result > 0) {
				// 삭제성공!! 후 메인페이지로 이동하는데 세션 정보 파괴!!
				//근데 로그아웃에 이미 아래코드를 쓰고있기 때문에 지우고!(주석처리함!!)
				//아래 /member/signout을쓴다!
				//session.invalidate();
				//response.sendRedirect("/");
				response.sendRedirect("/member/signout");
			}else {
				// 삭제 실패시 에러페이지로 이동!!
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
				.forward(request, response);
			}
		}
	}

}
