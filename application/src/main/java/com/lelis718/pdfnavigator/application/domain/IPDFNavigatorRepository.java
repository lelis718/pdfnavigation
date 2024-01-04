package com.lelis718.pdfnavigator.application.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lelis718.pdfnavigator.application.domain.entities.PDFNavigator;

public interface IPDFNavigatorRepository extends JpaRepository<PDFNavigator,Long>{

}
