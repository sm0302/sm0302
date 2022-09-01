package com.ksm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksm.domain.MemberVO;
import com.ksm.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper membermapper;
	//회원가입
	@Override
	public void memberJoin(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		membermapper.memberJoin(member);
	}
	//아이디 중복 검사
	@Override
	public int idCheck(String memberId) throws Exception {
		// TODO Auto-generated method stub
		return membermapper.idCheck(memberId);
	}
	//로그인
	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return membermapper.memberLogin(member);
	}

}
