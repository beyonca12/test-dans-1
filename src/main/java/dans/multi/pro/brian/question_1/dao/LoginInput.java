package dans.multi.pro.brian.question_1.dao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginInput {
	@NotEmpty(message = "Username is required")
	@Size(min = 5, max = 30, message = "Username length must be between 5 to 30")
	private String username;
	
	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "password length must be at least 8")
	private String password;
	
	
}
