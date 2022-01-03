package edu.kosmo.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/security/*") // 컨텍스트 명 + /security/로 치고 들어오는 것은 여기서 처리해라
@Controller
public class SecurityController {
	
	@GetMapping("/all")
	public String all() {
		System.out.println("do all acess everybody");
		
		return "/security/all";
	}
	
	@GetMapping("/member")
	public String member() {
		System.out.println("logined member");
		
		return "/security/member";
	}	
	
}
