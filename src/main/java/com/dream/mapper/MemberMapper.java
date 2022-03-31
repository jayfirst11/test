package com.dream.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dream.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public MemberVO memberCheck(@Param("id")String id, @Param("password") String password);

}
