package edu.kosmo.ex.service;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.EmpVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class EmpService {
	
	@Inject
	private EmpMapper empMapper;
	
	/*
	public EmpVO getUser(String empNo) {
		log.info("readUser..");
		return empMapper.readUser(empNo);
	}
	*/
	
	public EmpVO getUser(String ename){
		log.info("readUser .. ");
		
		// Service의 경우 Controller와 다르게 Principal이 제공되지 않기 때문에(알아서 객체 생성해주지 않음)
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// 이런식으로 SpringContextHolder를 통하여 가져와야한다.
		
		EmpVO empVO = empMapper.readUser(ename);
		empVO.setAuthList(empMapper.readAuthority(ename));
		
		return empVO;
	}

}