package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.winter.app.board.BoardVO;
import com.winter.app.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	void listTest(Pager pager)throws Exception{
		List<BoardVO> result = noticeDAO.list(pager);
		int testResult = result.size();
		assertEquals(10, testResult);
	}
	
	@Test
	void detailTest()throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardNum(9L);
		BoardVO boardVO = noticeDAO.detail(noticeVO);
		log.info("result : {}", boardVO);
		
		//단정문
		assertNotNull(boardVO);
	}
	
	
	
	@Test
	void insertTest()throws Exception {
		for(int i=0;i<105;i++) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardTitle("title"+i);
		noticeVO.setBoardContents("contents"+i);
		noticeVO.setBoardWriter("writer"+i);
		int result = noticeDAO.insert(noticeVO);
		if(i%10==0) {
			Thread.sleep(500);
		}
		//단정문
		assertEquals(1, result);
		
		}
	}
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
	
//	@Test
//	void deleteTest()throws Exception {
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setBoardNum(Long.valueOf("8"));
//		int result = noticeDAO.delete(noticeVO);
//		
//		//단정문 지운 개수가 1이면 성공뜸
//		assertEquals(1, result);
//		
//		
//	}

}
