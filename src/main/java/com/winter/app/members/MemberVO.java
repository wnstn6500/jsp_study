package com.winter.app.members;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.winter.app.members.validation.AddGroup;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO implements UserDetails{

	@NotBlank(message = "ID는 필수", groups = AddGroup.class)
	private String username;
	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	private String password;
	private String name;
	private String email;
	private String phone;
	private LocalDate birth;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private ProfileVO profileVO;
	
	private List<RoleVO> roleVOs;
	

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> list = new ArrayList<>();
		
		for(RoleVO roleVO:roleVOs) {
			list.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		return list;
	}
	
}
