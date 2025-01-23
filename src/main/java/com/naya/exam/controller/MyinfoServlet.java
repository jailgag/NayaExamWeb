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
 * Servlet implementation class MyinfoServlet
 */
@WebServlet("/member/myinfo")
public class MyinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		Member mInfo = (Member)session.getAttribute("member");
		if(mInfo != null) {
			String memberId = mInfo.getMemberId();
			MemberService mService = new MemberService();
			
			Member member = mService.selectOneById(memberId);
			if( member != null) {
				
				//request.setAttribute를 해야 이동한 page에서 해당데이터 사용가능!!
				request.setAttribute("member", member);
				request.getRequestDispatcher("/WEB-INF/views/member/Myinfo.jsp")
				.forward(request, response);
			}else {
				//에러페이지이동
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
				.forward(request, response);
			}
			
		}else {
			//에러 페이지 이동
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
		
	//	request.setAttribute("member", member);
	//	request.getRequestDispatcher("/WEB-inf/views/member/myinfo.jsp")
	//	.forward(request, response);
		
	}

}
