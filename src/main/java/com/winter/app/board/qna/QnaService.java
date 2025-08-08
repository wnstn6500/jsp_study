package com.winter.app.board.qna;

import java.util.List;
import com.winter.app.board.notice.NoticeService;
import com.winter.app.commons.FileManager;
import com.winter.app.commons.Pager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardFileVO;
import com.winter.app.board.BoardService;
import com.winter.app.board.BoardVO;

@Service
public class QnaService implements BoardService{

    private final NoticeService noticeService;

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload}")
	private String upload;
	
	@Value("${board.qna}")
	private String board;

    QnaService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

	@Override
	public List<BoardVO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totalCount = qnaDAO.totalCount(pager);
		pager.makeNum(totalCount);
		
		return qnaDAO.list(pager);
	}

	@Override
	public BoardVO detail(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detail(boardVO);
	}
	
	public int reply(QnaVO qnaVO)throws Exception{
		QnaVO parent= (QnaVO)qnaDAO.detail(qnaVO);
		qnaVO.setBoardRef(parent.getBoardRef());
		qnaVO.setBoardStep(parent.getBoardStep()+1);
		qnaVO.setBoardDepth(parent.getBoardDepth()+1);
		int result = qnaDAO.replyUpdate(parent);
		
		result = qnaDAO.insert(qnaVO);
		
		return result;
	}

	@Override
	public int insert(BoardVO boardVO,MultipartFile[] attaches) throws Exception {
		// TODO Auto-generated method stub
		int result = qnaDAO.insert(boardVO);
		//ref값을 update
		result = qnaDAO.refUpdate(boardVO);
		return result;
	}

	@Override
	public int update(BoardVO boardVO, MultipartFile [] attaches) throws Exception {
		int result = qnaDAO.update(boardVO);
		
		if(attaches == null) {
			return result;
		}
		
		//1. 파일이 비어있는지 확인
		for(MultipartFile m:attaches) {
			if(m == null || m.isEmpty()) {
				continue;
			}
			//1. File을 HDD에 저장
			String fileName = fileManager.fileSave(upload+board, m);
			
			
		}
		
		
		return result;
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		int result = qnaDAO.delete(boardVO);
		return result;
	}

	@Override
	public int fileDelete(BoardFileVO boardFileVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}