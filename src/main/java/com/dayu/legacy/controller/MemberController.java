package com.dayu.legacy.controller;

import java.io.IOException;
import java.util.*;

import javax.activation.CommandMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.dayu.legacy.dao.MemberDAO;
import com.dayu.legacy.dao.MemberDAOImpl;
import com.dayu.legacy.domain.ImageVO;
import com.dayu.legacy.domain.MemberVO;

@Controller
public class MemberController {

	
	@Autowired	
	private MemberDAOImpl MemberDAO;
	
	
	
	@RequestMapping("/loginCheck")
	private String loginCheck(MemberVO vo, HttpSession session) { 
		
		MemberVO result = MemberDAO.logincheck(vo);		
		
		if(result == null) { 
			return "login";
		}else { 			
			session.setAttribute("login", result.getMid()); 			
		}						
		return "login";			
	}
	
	@RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
	
	@RequestMapping(value = "/memberjoin", method = RequestMethod.POST)
	public ModelAndView memberjoin(MemberVO vo) {
		ModelAndView mv = new ModelAndView("redirect:/");
		MemberDAO.memberJoin(vo);
		return mv;
	}
	
	
	@RequestMapping(value = "/image_save", method = RequestMethod.POST)
	public String image_save(ImageVO vo) {		
		MemberDAO.image_save(vo);		
		return "login";	
		
		/*
		 * System.currentTimeMillis()
		*/
		
	} 
	
	

		
}
