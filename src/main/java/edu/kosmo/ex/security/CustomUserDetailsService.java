package edu.kosmo.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.CustomUserDetails;
import edu.kosmo.ex.vo.EmpVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

// UserDetailsService
// username을 가지고 사용자 정보를 조회하고, session에 저정될 사용자 주체 정보인
// UserDetails를 반환하는 interface.

@Log4j
@Service					// DB를 통해서 아이디, 패스워드, 권한 외에 더 가져오고 싶다면 UserDetailsService를 이용해 개발자가 알아서 만들어 줘야된다.
public class CustomUserDetailsService implements UserDetailsService {
										// 해당 인터페이스만 상속하면 커스터마이징 가능!
	@Setter(onMethod_ = @Autowired) // setter 함수 생성해서 넣어라?
	private EmpMapper empMapper;

	/*
	loadUserByUsername()에서 하는 일
	- username을 가지고 사용자 정보를 조회
	- 사용자의 Role과 권한(Privilege)을 조회하여, SimpleGrantedAuthority 목록을 authorities에 세팅한다.
	- Authentication 내부 principal 객체에 UserDetails 객체가 저장된다.
	- Authentication 내부 authorities 객체에 사용자의 Role과 권한(Privilege) 정보가 저장된다.
	- UserDetails에 authorities가 세팅되어 있어야, API별 role이나 권한 체크를 진행할 수 있다.
	*/
	
	@Override							// 로그인한 아이디가 파라미터값으로 들어간다.
	public UserDetails loadUserByUsername(String ename) throws UsernameNotFoundException {
		// principal..일종의 session 객체 같은 것	
		// principal = UserDetails...
		// 커스터마이징을 할 때 return값을 UserDetails로 해줘야 한다! 
		log.warn("Load User By Employee number: " + ename); 
		
		EmpVO vo = empMapper.readUser(ename);
		vo.setAuthList(empMapper.readAuthority(ename));
		
		log.warn("queried by EmpVO mapper: " + vo); 
		
		//return vo == null ? null : new CustomUser(vo);		
		return vo == null ? null : new CustomUserDetails(vo);
	}
   

}
