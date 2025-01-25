package com.naya.exam.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naya.exam.model.vo.Member;

public class MemberDAO {

	public int regiserMember(Connection conn, Member member) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result =0;
		String query ="INSERT INTO MEMBER_TBL(MEMBER_ID,MEMBER_PWD,MEMBER_NAME,GENDER,AGE, ENROLL_DATE) VALUES(?,?,?,?,?,DEFAULT)";
		pstmt = conn.prepareStatement(query); //던짐!!
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, member.getGender()); ///Cannot invoke getGender() on the primitive type double //점오타!!
		pstmt.setInt(5, member.getAge());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

	public Member selectOneByLogin(Connection conn, Member member) throws SQLException {
		// TODO Auto-generated method stub
		//
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member result = null;
		String query ="SELECT * FROM MEMBER_TBL WHERE MEMBER_ID= ? AND MEMBER_PWD =? "; //쿼리문작성!
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		rset = pstmt.executeQuery(); //rset cannot be resolved to a variable
		if(rset.next()) {
			String memberId = rset.getString("MEMBER_ID");
			String memberName =rset.getString("MEMBER_NAME");
			String email = rset.getString("EMAIL");
			result = new Member(memberId, memberName, email);
		}
		pstmt.close();
		rset.close();
		return result;
	}

	public Member selectOneById(Connection conn, String memberId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query ="SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?"; //쿼리문작성!
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			member = this.rsetToMember(rset);
		}
		pstmt.close();
		rset.close();
		return member;
	}

	private Member rsetToMember(ResultSet rset) throws SQLException {
		// TODO Auto-generated method stub
		String memberId = rset.getString("MEMBER_ID");
		String memberPwd = rset.getString("MEMBER_PWD");
		String memberName = rset.getString("MEMBER_NAME");
		String gender = rset.getString("GENDER");  // 퀵인드클릭!!
		int age = rset.getInt("AGE");
		String email = rset.getString("EMAIL");
		String phone = rset.getString("PHONE");
		String address = rset.getString("ADDRESS");
		String hobby = rset.getString("HOBBY");
		Date enroll = rset.getDate("ENROLL_DATE");
		//생성자 만들기!!어제 다 지웠었음...9개???? 10개 다시 생성!! address에 s 빠짐..생성자도 확인!!
		Member member = new Member(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby, enroll); //생생자만들기!
		// TODO Auto-generated method stub
		return member;
	
	}

	public int updateMember(Connection conn, Member member) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="UPDATE MEMBER_TBL SET EMAIL= ?, PHONE= ?, ADDRESS= ?, HOBBY=? WHERE MEMBER_ID=?";
		pstmt = conn.prepareStatement(query); //conn cannot be resolved
		pstmt.setString(1, member.getEmail());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getHobby());
		pstmt.setString(5, member.getMemberId());
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
		
	}
	//remove 삭제 Service에서 넘어옴! 재평가에 나옴!!위에 updatemember랑 비슷하다!!
	public int deleteMember(Connection conn, String memberId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query); //애드스로우!!
		pstmt.setString(1, memberId); 
		result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

}
