package board.service;

import board.dto.MemberDto;

public interface MemberService {
	public String loginCheck(MemberDto member) throws Exception;
}
