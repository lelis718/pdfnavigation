package com.lelis718.pdfnavigator.infrastructure;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;

import com.lelis718.pdfnavigator.application.domain.IPDFFileRepository;
import com.lelis718.pdfnavigator.application.domain.entities.PDFFile;

public class PDFFileRepository implements IPDFFileRepository {

    
    private final String vault;
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public PDFFileRepository(@Value("app.vault") String vault){
        this.vault = vault;
    }


    @Override
    public PDFFile saveFile(String filename, InputStream fileStream) {
        Path path = Paths.get(vault, filename);
        File file = path.toFile();
        // append = false
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = fileStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }catch(Exception excp){
            //Do nothing for now too tired to implement
        }

        return new PDFFile(filename);
    }
    
}
