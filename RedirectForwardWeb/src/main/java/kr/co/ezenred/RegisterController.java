package kr.co.ezenred;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ezenred.User;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm";		//views 폴더 안에 registerForm 파일이 있어야함
	}
	
	@RequestMapping(value="/save", method = {RequestMethod.GET, RequestMethod.POST})
	public String save(User user, Model m) throws Exception {
		//유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");	//직접 입력한 한글이 깨지지 않게 설정
			m.addAttribute("msg", msg);
			//return "redirect:/register/add?msg=" + msg;		//URL 재작성
			return "forward:/register/add";
		}
		return "registerinfo";
	}
	
	private boolean isValid(User user) {
		return false;
	}
}
