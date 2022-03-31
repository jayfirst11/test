package com.dream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.service.MemberService;
import com.dream.vo.MemberVO;
import com.dream.vo.ResultVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@CrossOrigin(origins = "*")
@RequestMapping("login/")

public class MemberController {
	
	@Autowired
	MemberService service;
	
	@ResponseBody
	@RequestMapping(value = "get-login.do", method = RequestMethod.POST)
	public ResultVO memberCheck(@RequestBody MemberVO userData) {
		
		String id = userData.getId();
		String password = userData.getPassword();
		
		log.info("[POST] Login");
		
		ResultVO result = new ResultVO(false, null);
		
		if(service.memberCheck(id, password) == null) {
			log.info("로그인 실패");

		} else {
			try {
				result.setResult(service.memberCheck(id, password));
				result.setSuccess(true);
				log.info("로그인 성공");
			} catch (Exception e) {
				log.error("[Member] LoginFailed : " + e.getMessage(), e);
			}
		}

		

		return result;

	}
}
