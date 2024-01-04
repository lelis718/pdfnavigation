package com.lelis718.pdfnavigator.application.commands;

import java.io.InputStream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class CretatePDFNavigatorCommand{
    final String filename;
    final InputStream stream;
}