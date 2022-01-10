package edu.kosmo.ex.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.kosmo.ex.service.UserService;
import edu.kosmo.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class UserController {

	@Inject
	private UserService userService;

	@GetMapping("/add/addForm")
	public void userForm() {
		log.info("Welcome userForm");
	}

	@PostMapping("/add/addUser")
	public String addUser(UserVO uservo) {
		log.info("post resister");
		userService.addUser(uservo);

		return "redirect:/";
	}
}
