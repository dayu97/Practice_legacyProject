package com.dayu.legacy.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.Dr_Link.mvc.dto.DrLinkDTO;
import kr.co.Dr_Link.mvc.dto.PrescriptionDTO;

@Repository("PrescriptionDaoInter")
public class PrescriptionDaoImp implements PrescriptionDaoInter {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	/* 리스트 처리 해야 함 ... */
	@Override
	public void insertPrescription(PrescriptionDTO vo) {
		System.out.println("===> Mybatis addPrescription() 실행");
		mybatis.insert("prescription.addPrescription",vo);
	}

	@Override
	public List<PrescriptionDTO> detail_prescription(PrescriptionDTO vo) {
		System.out.println("===> Mybatis detail_prescription() 실행");
		return mybatis.selectList("prescription.detail_prescription",vo);
	}

	@Override
	public DrLinkDTO drLink_info(DrLinkDTO vo) {
		System.out.println("===> Mybatis drLink_info() 실행");
		return mybatis.selectOne("prescription.drLink_info",vo);
	}


}
