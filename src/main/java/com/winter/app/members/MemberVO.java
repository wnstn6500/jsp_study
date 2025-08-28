package com.winter.app.members;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.winter.app.members.validation.AddGroup;
import com.winter.app.members.validation.UpdateGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO implements UserDetails, OAuth2User {
	
	@NotBlank(message = "ID는 필수", groups = AddGroup.class)
	private String username;
	@NotBlank
	@Size(min =6, max = 8, groups = AddGroup.class)
	private String password;
	
	
	private String passwordCheck;
	@NotBlank(groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	@Email(groups = {AddGroup.class, UpdateGroup.class})
	private String email;
	//@Pattern(regexp = "")
	private String phone;
	
	@NotNull(groups = {AddGroup.class, UpdateGroup.class})
	@Past(groups = {AddGroup.class, UpdateGroup.class})
	private LocalDate birth;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private ProfileVO profileVO;
	
	private List<RoleVO> roleVOs;
	
	//----------------------- Social
	
	private Map<String, Object> attributes;
	
	private String accessToken;
	
	private String sns;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method s
		List<GrantedAuthority> list = new ArrayList<>();
		
		for(RoleVO roleVO:roleVOs) {
			list.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return list;
	}
	
	
	
}