package com.winter.app.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
@Slf4j
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@Value("${board.qna}")
	private String name;
	
	@ModelAttribute("board")
	public String getBoard() {
		return name;
	}
	
	@GetMapping("list")
	public String list(Model model,Pager pager)throws Exception{
		model.addAttribute("pager",pager);
		model.addAttribute("list", qnaService.list(pager));
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String detail(QnaVO qnaVO, Model model)throws Exception{
		
		model.addAttribute("vo", qnaService.detail(qnaVO));
		return "board/detail";
	}
	
	@GetMapping("reply")
	public String reply(QnaVO qnaVO, Model model)throws Exception{
		model.addAttribute("vo", qnaVO);
		
		return "board/add";
	}
	
	@PostMapping("reply")
	public String reply(QnaVO qnaVO)throws Exception{
		
		int result = qnaService.reply(qnaVO);
		
		return "redirect:./list";
	}
	
	@GetMapping("add")
	public String insert(QnaVO qnaVO, MultipartFile [] attaches)throws Exception{
		
		int result = qnaService.insert(qnaVO, attaches);
		return "board/add";
	}
	
	@PostMapping("add")
	public String insert(QnaVO qnaVO, MultipartFile attaches)throws Exception{
		log.info("{}", attaches);
		//int result = qnaService.insert(qnaVO);
		return "redirect:./list";
	}
	
	

}