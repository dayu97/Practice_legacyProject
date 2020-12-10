package com.dayu.legacy.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dayu.legacy.domain.ImageVO;
import com.dayu.legacy.domain.MemberVO;


@Repository("MemberDAO") 
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	
	@Override
	public MemberVO logincheck(MemberVO vo) {
		System.out.println("===> MemberMapper logincheck 호출");
		return mybatis.selectOne("MemberDAO.logincheck", vo);
	}
	
	@Override
	public void memberJoin(MemberVO vo) {
		System.out.println("===> MemberMapper memberJoin 호출");
		mybatis.insert("MemberDAO.memberJoin", vo);
		
	}
	

	@Override
	public int image_save(ImageVO vo) {
		System.out.println("===> MemberMapper image_save 호출");
		return mybatis.insert("MemberDAO.image_save",vo);
	}

	
}
