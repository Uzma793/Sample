package com.example.springbootpoc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springbootpoc.model.UploadFileResponse;
import com.example.springbootpoc.service.FileStorageService;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    	try {
			byte[] bts=file.getBytes();
			String fname=file.getName();
			String value=new String(bts);
			System.out.println(value);
			long size=file.getSize();
			
		} catch (IOException e) {				
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      /*  String fileName = fileStorageService.storeFile(file);
          String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());*/
    	return null;
    }
	
	/*@PostMapping("/uploadFile2")
	public List uploadFile2(@RequestParam("file") MultipartFile file) {
		List data = new ArrayList<>();
		String fileName = fileStorageService.storeFile(file);
		try {
			File myObj = new File();
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				data.add(line);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return data;
	}*/

   
}
