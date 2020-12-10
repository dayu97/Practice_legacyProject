package com.dayu.legacy.domain;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ImageVO {
	

	private MultipartFile file;
	private String img;
	
	
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
		
		// 업로드 파일 접근
		if(! file.isEmpty()){
			this.img = file.getOriginalFilename();
			//this.b_fsize = file.getSize();
			
			//***********************************************
			// 해당 경로로 변경
			File f = new File("E:\\2020.12.28_수료생_김다유\\workspace_01\\dy_lgc_practice\\src\\main\\webapp\\resources\\img\\"+img);
			
			try {
				file.transferTo(f);
				
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	

	
	
}
