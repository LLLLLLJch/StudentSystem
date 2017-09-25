package com.situ.student.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/getUpload")
	@ResponseBody
	public Map<String, Object> getUpload(MultipartFile picUpload) {
		String name = UUID.randomUUID().toString().replace("-", "");
		String ext = FilenameUtils.getExtension(picUpload.getOriginalFilename());
		String fileName = name + "." + ext;
		System.out.println("--------------------"+fileName);
		String filePath = "E:\\picture\\" + fileName;
		try {
			picUpload.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("fileName", fileName);
		return map;
		
	}
}
