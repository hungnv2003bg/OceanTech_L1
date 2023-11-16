package com.example.baitapl1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
public class FileUploadController {

    @PostMapping("/MyFirstApi")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        if (filename == null || filename.isEmpty()) {
            return "No file selected for upload";
        }

        try {
            if (filename.endsWith(".txt")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else if (filename.endsWith(".xlsx") || filename.endsWith(".xls")) {
            } else {
                return "Unsupported file type: " + filename;
            }
            return "File uploaded and content printed successfully: " + filename;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during file upload: " + e.getMessage();
        }
    }
}
