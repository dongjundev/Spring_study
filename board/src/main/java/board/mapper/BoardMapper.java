package board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.dto.BoardDto;

@Mapper		//마이바티스의 매퍼 인터페이스임을 선언
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;		//함수명은 sql id와 동일해야함.
	
	void insertBoard(BoardDto board) throws Exception;		//게시판 쓰기
	
	void updateHitCount(int boardIdx) throws Exception;		//조회수 증가
	BoardDto selectBoardDetail(int boardIdx) throws Exception;	//게시판 상세보기
	
}


