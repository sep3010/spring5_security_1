package edu.kosmo.ex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.kosmo.ex.vo.EmpVO;

@Mapper
public interface EmpMapper {
	
	// xml 파일 안만들고 하기 위한 방식
	@Select("select * from emp where ename = #{ename}")
	public EmpVO readUser(String name);
	
}
