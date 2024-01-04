package com.lelis718.pdfnavigator.application.domain.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class PDFNavigator {

    public enum PDFNavigatorStatus{
        NotReady,
        Ready
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Embedded
    private PDFFile pdfFile;
    private String modelName;
    private PDFNavigatorStatus status;


    public static PDFNavigator Create(PDFFile filename){
        return new PDFNavigator(0, filename, "", PDFNavigatorStatus.NotReady);
    }
}
