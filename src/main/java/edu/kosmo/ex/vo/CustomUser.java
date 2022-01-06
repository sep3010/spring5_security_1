package edu.kosmo.ex.vo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
public class CustomUser extends User {

	private EmpVO emp;
	
	// 기본적으로 부모의 생성자를 호출해야만 정상적으로 작동

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);

	}

	public CustomUser(EmpVO empVO) {
		super(empVO.getEname(), Integer.toString(empVO.getEmpno()),
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

		this.emp = empVO;
	}

}
