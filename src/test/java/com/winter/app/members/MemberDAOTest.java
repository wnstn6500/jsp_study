package com.winter.app.members;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MemberDAOTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void testPasswordUpdate() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("dosihide");
		memberVO.setPassword(passwordEncoder.encode("dkfktl882"));
		int result = memberDAO.passwordUpdate(memberVO);
	}

}
