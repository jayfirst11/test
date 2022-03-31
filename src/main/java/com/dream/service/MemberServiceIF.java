package com.dream.service;

import com.dream.vo.MemberVO;

public interface MemberServiceIF {
	
	public MemberVO memberCheck(String id, String password);
	
}
