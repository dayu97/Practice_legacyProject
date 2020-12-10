package com.dayu.legacy.dao;


import java.util.List;

import com.dayu.legacy.domain.ImageVO;
import com.dayu.legacy.domain.MemberVO;
import com.dayu.legacy.domain.boardVO;


public interface MemberDAO {


	public MemberVO logincheck(MemberVO vo); 
	public void memberJoin(MemberVO vo);
	public int image_save(ImageVO vo);

	
}
