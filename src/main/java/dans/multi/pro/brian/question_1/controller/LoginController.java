package dans.multi.pro.brian.question_1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dans.multi.pro.brian.question_1.dao.LoginInput;
import dans.multi.pro.brian.question_1.dao.LoginOutput;
import dans.multi.pro.brian.question_1.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public @ResponseBody LoginOutput login(@Valid @RequestBody LoginInput loginInput) {
		LoginOutput output = loginService.login(loginInput);
		
		return output;
	}
}
