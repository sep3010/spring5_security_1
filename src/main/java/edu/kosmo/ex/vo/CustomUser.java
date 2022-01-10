package edu.kosmo.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter					// 1. User를 상속해서 클래스 생성
public class CustomUser extends User {

	private EmpVO emp;
	
	// 기본적으로 부모의 생성자를 호출해야만 정상적으로 작동

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);

	}

	public CustomUser(EmpVO empVO) {
		// super(empVO.getEname(), Integer.toString(empVO.getEmpno()),
			//	Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
		
		super(empVO.getEname(), Integer.toString(empVO.getEmpno()),getAuth(empVO));
		
		this.emp = empVO;
	}
	
	//유저가 갖고 있는 권한 목록
	public static Collection<? extends GrantedAuthority> getAuth(EmpVO empVO) { 

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (AuthVO auth: empVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}
		
		return authorities;
	}	

}