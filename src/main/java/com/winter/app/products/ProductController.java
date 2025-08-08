package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public void list(Model model)throws Exception{
		List<ProductVO> list = productService.list();
		
		model.addAttribute("list",list);
		
	}
	
	@GetMapping("detail")
	public void detail(ProductVO productVO, Model model)throws Exception{
			model.addAttribute("vo",productService.detail(productVO));
	}
	
	@GetMapping("add")
	public String add() throws Exception{
		return "products/form";
	}
	
	@PostMapping("add")
	public String add(ProductVO productVO, Model model)throws Exception{
		int result=productService.insert(productVO);
		
		String msg="상품 등록 실패";
		if(result>0) {
			msg="상품등록 성공";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("url","./list");
		
		return "commons/result";
	}
	
	
	@GetMapping("update")
	public String update(ProductVO productVO,Model model)throws Exception{
		int result = productService.update(productVO);
		String msg="상품 수정 실패";
		if(result>0) {
			msg="상품 수정 성공";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("url", "./detail?productNum="+productVO.getProductNum());
		return "commons/result";
	}
}
