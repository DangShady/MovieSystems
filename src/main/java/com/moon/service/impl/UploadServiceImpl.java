package com.moon.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.moon.service.UploadService;


@Repository
public class UploadServiceImpl implements UploadService{

	@Autowired
	ServletContext app;
	
	
	@Override
	public File save(MultipartFile file, String folder) {
		
		File dir = new File(app.getRealPath("/images/" + folder));
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		
		try {
			File savedFile = new File(dir,name);
			file.transferTo(savedFile);
			System.out.println(savedFile.getAbsolutePath());
			
			return savedFile;	
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
