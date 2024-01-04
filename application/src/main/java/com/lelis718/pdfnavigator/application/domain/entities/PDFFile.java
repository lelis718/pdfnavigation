package com.lelis718.pdfnavigator.application.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

@Embeddable
@AllArgsConstructor
public class PDFFile {
    
    private String filename;

    public String getPath(){
        return filename;
    }

}
