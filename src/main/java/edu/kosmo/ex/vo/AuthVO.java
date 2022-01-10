package edu.kosmo.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AuthVO { // 권한을 가져오기 위한 클래스
	private String username;
	private String authority;	
}
