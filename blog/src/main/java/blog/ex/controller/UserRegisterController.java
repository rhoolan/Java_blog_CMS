package blog.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.ex.model.entity.UserEntity;
import blog.ex.service.UserService;
import jakarta.servlet.http.HttpSession;



@Controller
public class UserRegisterController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	
	//ログイン画面の表示
		@GetMapping("/register")
		public String getLoginRegisterPage() {
			return "loginregister.html";
		}

    //ログイン処理
	@PostMapping("/register/process")
	public String register(@RequestParam String register_user_name, @RequestParam String register_user_email, @RequestParam String register_user_password) {
		userService.createAccount(register_user_name, register_user_email, register_user_password);
		return "redirect:/register";
	}
	

	//ログアウト処理
	@GetMapping("/logout")
	public String Logout() {
		
		session.invalidate();
		return "redirect:/login";
	}
}
