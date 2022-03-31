package com.dream.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.MemberMapper;
import com.dream.vo.MemberVO;

@Service
public class MemberService implements MemberServiceIF{
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public MemberVO memberCheck(String id, String password) {
		
		MemberVO memberVO = new MemberVO();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			memberVO = mapper.memberCheck(id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberVO;
	}
}
