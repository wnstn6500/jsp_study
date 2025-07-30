package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	void insertTest()throws Exception {
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setBoardTitle("title3");
//		noticeVO.setBoardContents("contents3");
//		noticeVO.setBoardWriter("writer3");
//		int result = noticeDAO.insert(noticeVO);
//		
//		//단정문
//		assertEquals(0, result);
//		
//		
//	}
//	@Test
//	void updateTest()throws Exception {
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setBoardTitle("title2");
//		noticeVO.setBoardContents("contents");
//		noticeVO.setBoardWriter("writer");
//		noticeVO.setBoardNum(Long.valueOf("1"));
//		int result = noticeDAO.update(noticeVO);
//		
//		//단정문
//		assertEquals(1, result);
//		
//		
//	}
	
	@Test
	void deleteTest()throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardNum(Long.valueOf("7"));
		int result = noticeDAO.delete(noticeVO);
		
		//단정문 지운 개수가 1이면 성공뜸
		assertEquals(1, result);
		
		
	}

}
