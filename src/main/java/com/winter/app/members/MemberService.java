package com.winter.app.members;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.winter.app.members.validation.AddGroup;
import com.winter.app.members.validation.UpdateGroup;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService implements UserDetailsService{
	@Autowired
    private final FileManager fileManager;
    @Autowired
	private MemberDAO memberDAO;

@Getter
@Setter
@ToString
public class MemberVO implements UserDetails, OAuth2User {
	
	@Value("${board.member}")
	private String board;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
    
	@Autowired
    private Transaction transaction;
	
	public int join(MemberVO memberVO, MultipartFile profile)throws Exception{
		
		
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		int result = memberDAO.join(memberVO);
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		try {
			memberVO = memberDAO.login(memberVO);
			return memberVO;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}
}
