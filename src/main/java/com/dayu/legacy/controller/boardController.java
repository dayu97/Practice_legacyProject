package com.dayu.legacy.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dayu.legacy.dao.MemberDAOImpl;
import com.dayu.legacy.dao.boardDAOImpl;
import com.dayu.legacy.domain.boardVO;

@Controller
public class boardController {

	private List<boardVO> page_list ;
	
	@Autowired	
	private boardDAOImpl dao;
	@Autowired	
	private MemberDAOImpl MemberDAO;
	

		
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) {
		return step;
	}

	
	@RequestMapping("/BoardList")
	public String getBoardList(HttpSession session, RedirectAttributes redirectAttribute) throws Exception {
		session.removeAttribute("search_keyword");
		session.removeAttribute("search_key");
		
		List<boardVO> ss = dao.getBoardList();
		System.out.println("받았음 보드에서");
		redirectAttribute.addFlashAttribute("list",ss);
		//redirectAttribute.addFlashAttribute("list", ss);  
		page_list=ss; //모든 글의 목록을 갖고 있는 변수					
		return"redirect:/paging";
	}
	
	
	
	
	//페이징
	@RequestMapping("/paging")
	public String paging(HttpServletRequest request, Model model, String page) {

		List<boardVO> qq = (List)model.asMap().get("list");
		if(qq != null) {
			System.out.println(qq.get(0).getNo());
		}
		
		List<boardVO> setPage = new ArrayList<boardVO>();		
		int page_size = 10; 		
		//System.out.println("리다이렉트로 받은 값 : " + oo.get(0).getNo());
		System.out.println("검색 글 갯수 : "+page_list.size());
		//System.out.println("BoardList 메소드에서 날아온 데이터 : " + qw.get(0).getNo());
		try {
			
			if(page==null) {
				for(int i=0; i<page_size ; i++) {
					boardVO vo = page_list.get(i);
					setPage.add(vo);
				}
			}else {
				
				int paramPage = Integer.parseInt(page);
				if(page_list.size() > page_size*paramPage) {
					for(int i=(page_size*paramPage-page_size) ; i<page_size*paramPage ; i++) {
						boardVO vo = page_list.get(i);
						setPage.add(vo);
					}
				} else {
					for(int i=(page_size*paramPage-page_size) ; i<page_list.size() ; i++) {
						boardVO vo = page_list.get(i);
						setPage.add(vo);
					}
				}
			}	
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("에러에러 : "+e);
		}
				
		//페이징할 파라미터 값을 -> dao -> mapper 
		//시작 번호, 끝 번호를 변수처리 해서 -> mapper
		
		
		int page_num = 0; //글 갯수를 세서 페이지 번호를 담는 변수
		
		if (page_list.size()%page_size==0) {
			page_num = page_list.size()/page_size;
			
		}else {
			page_num = (int)Math.floor(page_list.size()/page_size)+1;
		}
		
		int [] p_num = new int[page_num];		

		for(int i=0; i < p_num.length; i++) {
			p_num[i] = i+1;
		}		

		model.addAttribute("boardList",setPage);
		model.addAttribute("p_num", p_num);
		
		return "boardList";
	}
	
	
	
	//글 검색
	@RequestMapping("/boardSearch")
	public String boardSearch(HttpServletRequest request, HttpSession session) {
		
		String search_key = request.getParameter("search_key");
		String search_keyword = request.getParameter("search_keyword");
		
				
		if (search_key.equals("writer")) {			
			page_list=dao.boardWriterSearch(search_keyword);			
		}else if (search_key.equals("content")) {			
			page_list=dao.boardContentSearch(search_keyword);			
		}else {			
			page_list=dao.boardSubjectSearch(search_keyword);
		}
		
		session.setAttribute("search_keyword", search_keyword); // 세션에 검색어 값 저장
		session.setAttribute("search_key",search_key);
		
		
		return"redirect:/paging";
		
		
	}

	
	
	
	//글 작성
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST) // POST방식으로 내용 전송
	  public String insertBoard(boardVO vo) throws Exception { // 인자값으로 REDIRECT 사용 	   
		  dao.insertBoard(vo); // 글작성 서비스 호출	    	    
	    return "redirect:/BoardList"; // 작성이 완료된 후, 목록페이지로 리턴
	}
	
	
	//글 상세
	@RequestMapping("/getBoard")
	public void getProduct(boardVO vo, Model model) {
		model.addAttribute("board", dao.getBoard(vo)); 		
	}
	
	//글 수정	
	@RequestMapping("/updateBoard")
	public String updateBoard(boardVO vo) {
		dao.updateBoard(vo);
		return "redirect:/BoardList";
	}

	
	
	//글 삭제
	@RequestMapping(value="/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(HttpServletRequest request) {
		
		String [] b_no = request.getParameterValues("no");
		
		for (int i=0; i<b_no.length; i++) {
			boardVO vo = new boardVO();
			vo.setNo(Integer.parseInt(b_no[i]));
			dao.deleteBoard(vo);
		}
		
		return "redirect:/BoardList";
	}
	
	
	

		
}
