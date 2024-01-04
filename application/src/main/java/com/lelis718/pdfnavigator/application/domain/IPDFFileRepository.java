package com.lelis718.pdfnavigator.application.domain;

import java.io.InputStream;

import com.lelis718.pdfnavigator.application.domain.entities.PDFFile;

public interface IPDFFileRepository {
    
    public PDFFile saveFile(String filename, InputStream fileStream);

}
