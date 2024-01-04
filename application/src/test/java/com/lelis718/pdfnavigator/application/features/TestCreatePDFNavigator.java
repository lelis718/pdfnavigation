package com.lelis718.pdfnavigator.application.features;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import com.lelis718.pdfnavigator.application.commands.CretatePDFNavigatorCommand;
import com.lelis718.pdfnavigator.application.domain.IPDFFileRepository;
import com.lelis718.pdfnavigator.application.domain.IPDFNavigatorRepository;
import com.lelis718.pdfnavigator.application.dtos.PDFNavigatorDto;
import com.lelis718.pdfnavigator.application.exceptions.ValidationException;

public class TestCreatePDFNavigator {


    private IPDFFileRepository fileRepository;
    private IPDFNavigatorRepository navigatorRepository;
    private ModelMapper modelMapper;
    private CreatePDFNavigator featureHandler;


    @BeforeEach
    public void Setup(){
        fileRepository = mock(IPDFFileRepository.class);
        navigatorRepository = mock(IPDFNavigatorRepository.class);
        modelMapper = new ModelMapper();
        fileRepository = mock(IPDFFileRepository.class);
        featureHandler = new CreatePDFNavigator(fileRepository, navigatorRepository, modelMapper);
    }


    @Test
    public void AssertThatUserCanCreatePDFNavigators() throws ValidationException{
        InputStream mock = Mockito.mock(InputStream.class);
        CretatePDFNavigatorCommand command = new CretatePDFNavigatorCommand("Testfile", mock );
        PDFNavigatorDto result = featureHandler.handle(command);
        assertNotNull(result);
    }


    @Test
    public void AssertThatCreatePDFNavigatorFeatureHandlesValidation() throws ValidationException{
        CretatePDFNavigatorCommand command = new CretatePDFNavigatorCommand(null, null );

        ValidationException exception = assertThrows(ValidationException.class, ()->{
            featureHandler.handle(command);
        });
        assertNotNull(exception);
        assertNotNull(exception.getMessage());
    }
        
}
