package com.winter.app.members;

import com.winter.app.commons.FileManager;
import com.winter.app.products.ProductVO;
import com.winter.app.transaction.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
public class MemberService {
	@Autowired
    private final FileManager fileManager;
    @Autowired
	private MemberDAO memberDAO;

    @Value("${app.upload}")
	private String upload;
	
	@Value("${board.member}")
	private String board;
    
	@Autowired
    private Transaction transaction;
	
    MemberService(FileManager fileManager) {
        this.fileManager = fileManager;
    }
	
	public int join(MemberVO memberVO, MultipartFile profile)throws Exception{
		
		int result = memberDAO.join(memberVO);
		
		ProfileVO profileVO = new ProfileVO();
		profileVO.setUsername(memberVO.getUsername());
		profileVO.setSaveName("default.jpg");
		profileVO.setOriName("default.jpg");
		if(profile != null && profile.isEmpty()) {
			String saveName = fileManager.fileSave(upload+board,profile);
			
			profileVO.setSaveName(saveName);
			profileVO.setOriName(profile.getOriginalFilename());
			
		}
		
		result = memberDAO.profileInsert(profileVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("username", memberVO.getUsername());
		map.put("roleNum", 3);
		result = memberDAO.addRole(map);
		return result;
	}

	public MemberVO login(MemberVO memberVO) throws Exception{
		MemberVO checkVO = memberDAO.login(memberVO);
		System.out.println(memberVO.getPassword());
		// System.out.println(checkVO);
		if(checkVO != null && memberVO.getPassword().equals(checkVO.getPassword())) {
			return checkVO;
		}
		return null;
	}

	public int cartAdd(Map<String, Object> map)throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.cartAdd(map);
	}
	
	public List<ProductVO> cartList(MemberVO memberVO) throws Exception{
		//페이징 처리 해야 함
		return memberDAO.cartList(memberVO);
	}

	public int cartDelete(Long[] productNum, MemberVO memberVO) throws Exception {
			Map<String, Object> map = new HashMap<>();
			map.put("username", memberVO.getUsername());
			map.put("list", Arrays.asList(productNum));
		
		return memberDAO.cartDelete(map);
	}
}
