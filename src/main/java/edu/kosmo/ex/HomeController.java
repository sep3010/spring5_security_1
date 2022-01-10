package edu.kosmo.ex;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kosmo.ex.vo.CustomUserDetails;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	
		return "home";
	}
	
	@GetMapping("/user/userHome")
	public void userHome() {
		log.info("userHome..");
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {
		log.info("adminHome..");
	}
		
	@GetMapping("/login/loginForm")
	public String loginForm() {
		log.info("Welcome Login Form");
		return "login/loginForm2";				
	}
	
	@RequestMapping(value = "/loginInfo", method = RequestMethod.GET)
	public String loginInfo(Principal principal, Model model) {
		// 유저 아이디를 가져오는 방법
		
		//1.Controller를 통하여 Principal객체로 가져오는 방법
		String user_id = principal.getName();
		System.out.println("유저 아이디:" + user_id);
		
		//2.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음) : 최고 부모..
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user_id = auth.getName();
        System.out.println("유저 아이디:" + user_id);
        
        //3.
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        System.out.println(userDetails.getUsername());

        //4.
        CustomUserDetails couCustomUserDetails = (CustomUserDetails) auth.getPrincipal();
        System.out.println(couCustomUserDetails.getEmp());
        
    	//5.User 클래스로 변환 하여 가져오는 방법
        couCustomUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user_id = couCustomUserDetails.getUsername();
        System.out.println("유저 아이디:" + user_id);
        
        return "home";
	}
	
}