package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.service.BoardService;

@Controller //①
public class BoardController {

    @Autowired
    private BoardService boardService;  //boardService는 비즈니스로직을 처리하는 서비스 빈을 연결한다. 이는 아래 서비스 영역에서 다시 설명한다.

    @RequestMapping("/board/openBoardList.do")  //@RequestMapping("/board/openBoardList.do")은 어노테이션의 값으로 주소를 지정한다. 여기서는 웹브라우저에서 /board/openBoardList.do라는 주소를 호출하면 스프링 디스패처는 호출된 주소와 @RequestMapping 어노테이션의 값이 동일한 메서드를 찾아서 실행한다.
    public ModelAndView openBoardList() throws Exception{
        ModelAndView mv = new ModelAndView("/boardList"); //ModelAndView는 호출된 요청의 결과를 보여줄 뷰를 지정한다. 여기서는 /board/boardList로 지정했는데 이는 templates 폴더 아래있는 /board/boardList.html을 의미한다. Thymeleaf와 같은 템플릿을 사용할 경우 스프링 부트의 자동 설정 기능으로 .html과 같은 접미사를 생략할 수 있다.

        List<BoardDto> list = boardService.selectBoardList();   //List<BoardDto> list에서는 게시글 목록을 조회한다. “게시글 목록을 조회한다.”는 비즈니스 로직을 수행하기 위해서 BoardService 클래스의 selectBoardList 메서드를 호출한다. 게시글 목록을 저장하기 위해서 List 인터페이스를 사용했다.
        mv.addObject("list", list); //실행된 비즈니스 로직의 결과 값을 뷰에 list라는 이름으로 저장한다. 이 부분은 추후 뷰 영역 설명에서 다시 확인해보자.

        return mv;
    }
}
