package edu.kosmo.ex.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kosmo.ex.mapper.UserMapper;
import edu.kosmo.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class UserService {

	@Inject
	private BCryptPasswordEncoder passEncoder; // 암호화 모듈 객체

	@Inject
	private UserMapper userMapper;

	// @Transactional(rollbackFor = Exception.class)
	public void addUser(UserVO userVO) {
		String password = userVO.getPassword();
		String encode = passEncoder.encode(password);
		// 암호화 시키는 모듈
		// 회원가입하면 콘솔 창에
		// INFO : jdbc.sqlonly - insert into users(username,password,enabled) values('user1','$2a$10$/K7DAk6TiqsCTxRGwYlWpe7UmcRpuEKkbrofStxb0fGe8uVHgIOUe',0)
		// 로 표시된다! 입력한 비밀번호가 암호화 되서 값이 넘어갔다!

		userVO.setPassword(encode);

		userMapper.insertUser(userVO);
		userMapper.insertAuthorities(userVO);
	}
}
