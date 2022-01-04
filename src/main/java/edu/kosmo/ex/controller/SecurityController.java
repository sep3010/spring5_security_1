package edu.kosmo.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
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
	
	@GetMapping("/admin")
	public void admin() {
		log.info("/admin..");		
		// void를 사용하면 return "/security/admin" 하는 것과 같다.
	}
	
	@GetMapping("/accessError")
	public String accessError(Model model) {
		System.out.println("laccessError()..");
		
		model.addAttribute("msg", "ACCESS Denied(403 에러)");
		
		return "/security/accessError";
	}
	
}
