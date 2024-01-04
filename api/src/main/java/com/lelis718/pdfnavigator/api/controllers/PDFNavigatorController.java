package com.lelis718.pdfnavigator.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lelis718.pdfnavigator.application.commands.CretatePDFNavigatorCommand;
import com.lelis718.pdfnavigator.application.dtos.PDFNavigatorDto;
import com.lelis718.pdfnavigator.application.exceptions.ValidationException;
import com.lelis718.pdfnavigator.application.features.CreatePDFNavigator;



@RestController
@RequestMapping("/PDFNavigator")
public class PDFNavigatorController {



    @ExceptionHandler(ValidationException.class)
    
    @PostMapping("/")
    public ResponseEntity<PDFNavigatorDto> createPdfNavigator(@RequestParam("file") MultipartFile file, @Autowired CreatePDFNavigator handler ) throws ValidationException, IOException {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());
            CretatePDFNavigatorCommand cmd = new CretatePDFNavigatorCommand(filename, file.getInputStream());
            PDFNavigatorDto result = handler.handle(cmd);
            return ResponseEntity.ok(result);
    }

}
