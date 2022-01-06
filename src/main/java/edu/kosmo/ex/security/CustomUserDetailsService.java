package edu.kosmo.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.CustomUser;
import edu.kosmo.ex.vo.EmpVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service					// DB를 통해서 아이디, 패스워드, 권한 외에 더 가져오고 싶다면 UserDetailsService를 이용해 개발자가 알아서 만들어 줘야된다.
public class CustomUserDetailsService implements UserDetailsService {
	
	@Setter(onMethod_ = @Autowired) // setter 함수 생성해서 넣어라?
	private EmpMapper empMapper;

	@Override
	public UserDetails loadUserByUsername(String ename) throws UsernameNotFoundException {
		
		log.warn("Load User By Employee number: " + ename); 
		
		EmpVO vo = empMapper.readUser(ename);
		
		log.warn("queried by EmpVO mapper: " + vo); 
		
		return vo == null ? null : new CustomUser(vo);
	}
   

}

