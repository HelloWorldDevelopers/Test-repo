package com.example.test.controller;

import java.io.IOException;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

	private static final Logger log = LogManager.getLogger(ImageController.class);
	
	@GetMapping("/image.png/{email}/{id}")
	public ResponseEntity<Object> getImage(@PathVariable("email") String email,@PathVariable("id") String id) throws IOException {
		log.info("+++++++++++++++++++++++++++++++++"+email+"+++++++++++++++++++++++++"+id);
		log.error("+++++++++++++++++++++++++++++++++"+email+"+++++++++++++++++++++++++"+id);
		System.out.print("+++++++++++++++++++++++++++++++++"+email+"+++++++++++++++++++++++++"+id);
		
		Resource resource = new ClassPathResource("static/images/oneKB.png");

         if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

         byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());

         MediaType mediaType = MediaType.IMAGE_JPEG;
 
         HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);

         return ResponseEntity.ok().headers(headers).body(imageBytes);
    }
 	
}
