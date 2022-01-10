package edu.kosmo.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter 
@Setter						// 2. UserDetails를 상속해서 클래스 생성
public class CustomUserDetails implements UserDetails {
	
	@Setter(onMethod_ = @Autowired)
	private EmpVO emp;
	// principal.emp(= getEmp)로 사용가능하다.
	// 쇼핑몰 같은 사이트를 만들 때 로그인 정보와 같이 session 객체에 같이 공유되어야되는
	// 객체는 이곳에 선언 해준다... ex) private CartVO cart;
	
	// ================================================================================================
	private String password;
	private final String username;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean accountNonExpired;
	private final boolean accountNonLocked;
	private final boolean credentialsNonExpired;
	private final boolean enabled;

	// ~ Constructors
	// ===================================================================================================
	
	public CustomUserDetails(EmpVO empVO) {
		 //Integer.toString(empVO.getEmpno()),getAuth(empVO)
		
		this(empVO.getEname(), Integer.toString(empVO.getEmpno()), true, true, true, true, getAuth(empVO));
		this.emp = empVO;	
	}
	
	public CustomUserDetails(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {

		if (((username == null) || "".equals(username)) || (password == null)) {
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}

		this.username = username;
		this.password = password;
		this.enabled = enabled; // true로 설정
		this.accountNonExpired = accountNonExpired; // true로 설정
		this.credentialsNonExpired = credentialsNonExpired; // true로 설정
		this.accountNonLocked = accountNonLocked; // true로 설정
		this.authorities = authorities;
	}
	
	//유저가 갖고 있는 권한 목록
	public static Collection<? extends GrantedAuthority> getAuth(EmpVO empVO) { 

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (AuthVO auth: empVO.getAuthList()) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}
		
		return authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	

}