package dans.multi.pro.brian.question_1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dans.multi.pro.brian.question_1.dao.LoginInput;
import dans.multi.pro.brian.question_1.dao.LoginOutput;
import dans.multi.pro.brian.question_1.entity.UserEntity;
import dans.multi.pro.brian.question_1.repo.UserRepo;
import dans.multi.pro.brian.question_1.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserRepo userRepo;

	// to make it simpler, i assume user will get registered if the user is not in DB
	// since the goal of this question is to show validation, and DB Query from spring.
	// ideally, the login should have integrated into spring security
	public LoginOutput login(LoginInput loginInput) {
		LoginOutput output = new LoginOutput();
		UserEntity user = userRepo.findByUsername(loginInput.getUsername());
		
		if (user == null) {
			user = new UserEntity();
			user.setUsername(loginInput.getUsername());
			user.setPassword(loginInput.getPassword());
			userRepo.save(user);
			output.setMessage("new registered user");
		} else {
			if (user.getPassword() == loginInput.getPassword()) {
				output.setMessage("valid user");
			} else {
				output.setMessage("invalid user");
			}
		}
		
		return output;
	}
}
