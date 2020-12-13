package com.dayu.legacy.controller;

import java.lang.reflect.Array;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.Dr_Link.mvc.dao.DoctorDaoImp;
import kr.co.Dr_Link.mvc.dao.PrescriptionDaoImp;
import kr.co.Dr_Link.mvc.dto.DrLinkDTO;
import kr.co.Dr_Link.mvc.dto.PrescriptionDTO;


@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {
	

	@Autowired	
	private PrescriptionDaoImp pre_dao;
	
	/* 배열 붙이는 메소드 */
	public static String arrayJoin(String glue, String array[]) {
	    String result = "";

	    for (int i = 0; i < array.length; i++) {
	      result += array[i];
	      if (i < array.length - 1) result += glue;
	    }
	    return result;
	  }

	@RequestMapping(value = "/login")
	public String login() {
		System.out.println("로그인");
		return "login";
	}

	@RequestMapping(value = "{step}")
	public String accessAnyFiles(@PathVariable String step) {
		System.out.println("doctor 컨트롤러 실행");
		return "/doctor/"+step;
	}


	@RequestMapping(value = "/add_prescription") 
	public String add_prescription(DrLinkDTO vo,Model model) {
		DrLinkDTO info = pre_dao.drLink_info(vo); 
		System.out.println("처방입력 페이지로 이동");
		model.addAttribute("info",info);
		System.out.println("controller drLink_info 실행 완료");	    
		return "/doctor/add_prescription";
	}
	
	@RequestMapping(value = "/end_prescription", method = RequestMethod.POST) 
	public String end_prescription(PrescriptionDTO vo,HttpServletRequest request) {
		String [] qty = request.getParameterValues("quantity");
		String [] dsg = request.getParameterValues("dosage");
		String [] dys = request.getParameterValues("days");
	
		for(int i = 0 ; i<Array.getLength(qty) ; i++) {
			System.out.println(qty[i]);
			System.out.println(dsg[i]);
			System.out.println(dys[i]);
		}

		String quantity = arrayJoin(",", qty);
		String dosage = arrayJoin(",", dsg);
		String days = arrayJoin(",", dys);
		
		System.out.println("붙였다! " + quantity);
		System.out.println("붙였다! " + dosage);
		System.out.println("붙였다! " + days);

		vo.setQuantity(quantity);
		vo.setDosage(dosage);
		vo.setDays(days);
		
		System.out.println("처방입력 완료");
		pre_dao.insertPrescription(vo);
		System.out.println(" controller insertPrescription 실행 완료");	    
		return "/doctor/end_prescription";
	}
	

}
