package com.application.healthProtector.common;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
	
	@Value("${file.repo.path}")
    private String fileRepositoryPath;
	
	@GetMapping("/thumbnails")
    @ResponseBody
    public Resource thumbnails(@RequestParam("fileName") String fileName) throws IOException{
        return new UrlResource("file:" + fileRepositoryPath + "product/" + fileName);
    }
	
}
