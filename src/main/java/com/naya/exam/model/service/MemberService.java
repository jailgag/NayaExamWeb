package com.naya.exam.model.service;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naya.exam.common.JDBCTemplate;
import com.naya.exam.model.dao.MemberDAO;
import com.naya.exam.model.vo.Member;

public class MemberService {

	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	
	public MemberService() {      //이거 안적었었음!!
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	public int registerMember(Member member) {
		// TODO Auto-generated method stub
		//다시작성!!
		Connection conn =null;
		int result=0;
		
		
		try {
			conn = JDBCTemplate.getConnection(); //Cannot make a static reference to the non-static method getConnection() from the type JDBCTemplate
			result =mDao.regiserMember(conn,member); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member selectOneByLogin(Member member) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Member result =null;
		
		try {
			conn= jdbcTemplate.getConnection();
			result = mDao.selectOneByLogin(conn,member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member selectOneById(String memberId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Member member =null;
		try {
			conn = jdbcTemplate.getConnection();
			member = mDao.selectOneById(conn, memberId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //캐치안됨!!
		}
		return member; //오키!!
	}
	//****고칠것!!!!******************다오에 쓸것을 여기다 적음....

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		Connection conn = null;
		int result =0;
		try {
			conn =jdbcTemplate.getConnection();
			result = mDao.updateMember(conn, member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
		}
		return result;
	}
	//remove 탈퇴? 삭제하기!!  위에꺼 복붙!해서 이름만바꾸기!!
	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		int result =0;
		try {
			conn =jdbcTemplate.getConnection();
			result = mDao.deleteMember(conn, memberId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //
		}
		return result;
	}
	
}
