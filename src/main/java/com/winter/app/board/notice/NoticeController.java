package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.board.BoardVO;



@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {

	@Autowired
	private NoticeDAO noticeService;
	
	@Value("${board.notice}")
	private String name;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "name";
	}
	
	@GetMapping("detail")
	public String detail(NoticeVO noticeVO, Model model)throws Exception{
		
		BoardVO result = noticeService.detail(noticeVO);
		
		model.addAttribute("result",result);
		
		return "board/detail";
	}
	
	@GetMapping("list")
	public String list(Model model)throws Exception {
		// model => request랑 생명주기가 비슷함
		List<BoardVO> list = noticeService.list();
		
		
		
		return "board/list";
	}
	
	@GetMapping("add")
	public String insert()throws Exception{
		
		return "board/add";
	}
	
	@PostMapping("add")
	public String insert(NoticeVO noticeVO)throws Exception{
		int result = noticeService.insert(noticeVO);
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(BoardVO noticeVO, Model model)throws Exception{
		BoardVO boardVO = noticeService.detail(noticeVO);
		model.addAttribute("vo", boardVO);
		
		return "board/add";
	}
	
	@PostMapping("update")
	public String update(NoticeVO noticeVO, Model model)throws Exception{
		int result = noticeService.update(noticeVO);
		
		String msg = "수정 실패";
		
		if(result>0) {
			msg="수정 성공";
		}
		
		String url = "./detail?boardNum="+noticeVO.getBoardNum();
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "commons/result";//"redirect:./detail?boardNum="+noticeVO.getBoardNum();
	}
	
	@PostMapping("delete")
	public String delete(NoticeVO noticeVO, Model model)throws Exception{
		int result = noticeService.delete(noticeVO);
		String msg = "삭제 실패";
		
		if(result>0) {
			msg="삭제 성공";
		}
		
		String url="./list";
		
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		
		
		return "commons/result";
	}
}
