package edu.kosmo.ex.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.kosmo.ex.mapper.EmpMapper;
import edu.kosmo.ex.vo.EmpVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class EmpService {
	
	@Inject
	private EmpMapper empMapper;
	
	public EmpVO getUser(String empNo) {
		log.info("readUser..");
		return empMapper.readUser(empNo);
	}

}
