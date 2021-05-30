package board.mapper;

import org.apache.ibatis.annotations.Mapper;

import board.dto.MemberDto;

@Mapper
public interface MemberMapper {
	public String loginCheck(MemberDto member) throws Exception;
}
