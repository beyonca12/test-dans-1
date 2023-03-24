package dans.multi.pro.brian.question_1.service;

import dans.multi.pro.brian.question_1.dao.LoginInput;
import dans.multi.pro.brian.question_1.dao.LoginOutput;

public interface LoginService {
	public LoginOutput login(LoginInput loginInput);
}
