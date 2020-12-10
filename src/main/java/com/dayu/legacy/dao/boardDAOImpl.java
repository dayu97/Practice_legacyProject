package com.dayu.legacy.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dayu.legacy.domain.boardVO;


@Repository("boardDAO") 
public class boardDAOImpl implements boardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<boardVO> getBoardList() {
		System.out.println("===> Mybatis getBoardList() 호출");
		List<boardVO> v = mybatis.selectList("BoardDAO.getBoardList");
		return v;
	}	

	@Override
	public void insertBoard(boardVO vo) {
		System.out.println("===> Mybatis insertBoard() 호출");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	@Override
	public void updateBoard(boardVO vo) {
		System.out.println("===> Mybatis updateBoard() 호출");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	@Override
	public void deleteBoard(boardVO vo) {
		System.out.println("===> Mybatis deleteBoard() 호출");
			mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	@Override
	public boardVO getBoard(boardVO vo) {
		System.out.println("===> Mybatis getBoard() 호출");
		return mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	@Override
	public List<boardVO> boardWriterSearch(String search_keyword) {
		System.out.println("===> Mybatis boardWriterSearch() 호출");
		List<boardVO> v = mybatis.selectList("BoardDAO.boardWriterSearch",search_keyword);
		return v;		
	}
	@Override
	public List<boardVO> boardSubjectSearch(String search_keyword) {
		System.out.println("===> Mybatis boardSubjectSearch() 호출");
		List<boardVO> v = mybatis.selectList("BoardDAO.boardSubjectSearch",search_keyword);
		return v;		
	}
	@Override
	public List<boardVO> boardContentSearch(String search_keyword) {
		System.out.println("===> Mybatis boardContentSearch() 호출");
		List<boardVO> v = mybatis.selectList("BoardDAO.boardContentSearch",search_keyword);
		return v;		
	}
	
	
	
}
