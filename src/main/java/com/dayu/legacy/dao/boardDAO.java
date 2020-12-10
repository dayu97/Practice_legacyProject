package com.dayu.legacy.dao;


import java.util.List;

import com.dayu.legacy.domain.boardVO;


public interface boardDAO {


	public List<boardVO> getBoardList() ;
	
	public void insertBoard(boardVO vo);

	public void updateBoard(boardVO vo) ;

	public void deleteBoard(boardVO vo);

	public boardVO getBoard(boardVO vo) ;

	public List<boardVO> boardWriterSearch(String search_keyword) ;
	
	public List<boardVO> boardSubjectSearch(String search_keyword) ;
	
	public List<boardVO> boardContentSearch(String search_keyword) ;
	
	
	
	
}
