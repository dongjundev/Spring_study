package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.dto.MemberDto;
import board.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/board/login.do")
	public String login() throws Exception{
		return "/login";
	}
	
	@RequestMapping("/board/loginCheck.do")
	public String loginCheck(MemberDto member) throws Exception{
		
		  System.out.println("컨트롤러 들어옴"); 
		  String result = memberService.loginCheck(member); 
		  ModelAndView mv = new ModelAndView();
		  if(result == null) { 
			  //mv.setViewName(null);
			  System.out.println("로그인 실패"); 
		  }else { System.out.println("로그인 성공"); }
		  
	return "redirect:/board/openBoardList.do";
	}
}
