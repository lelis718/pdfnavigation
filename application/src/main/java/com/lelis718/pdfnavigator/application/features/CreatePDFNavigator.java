package com.lelis718.pdfnavigator.application.features;

import org.modelmapper.ModelMapper;

import com.lelis718.pdfnavigator.application.commands.CretatePDFNavigatorCommand;
import com.lelis718.pdfnavigator.application.domain.IPDFFileRepository;
import com.lelis718.pdfnavigator.application.domain.IPDFNavigatorRepository;
import com.lelis718.pdfnavigator.application.domain.entities.PDFFile;
import com.lelis718.pdfnavigator.application.domain.entities.PDFNavigator;
import com.lelis718.pdfnavigator.application.dtos.PDFNavigatorDto;
import com.lelis718.pdfnavigator.application.exceptions.ValidationException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePDFNavigator {

    private final IPDFFileRepository fileRepository;
    private final IPDFNavigatorRepository pdfRepository;
    private final ModelMapper mapper;

    public PDFNavigatorDto handle(CretatePDFNavigatorCommand command) throws ValidationException {

        if (command.getFilename() == null || command.getStream() == null) {
            throw new ValidationException("Messages");
        }

        PDFFile file = fileRepository.saveFile(command.getFilename(), command.getStream());
        PDFNavigator navigator = PDFNavigator.Create(file);
        pdfRepository.save(navigator);
        return mapper.map(navigator, PDFNavigatorDto.class);

    }

}
