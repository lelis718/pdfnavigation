# Aplicattion Details

This application is a test application to gather some knowloedge in the java world

## Problem
Consider a LLM in python that reads a PDF file and can be queried in order to seek answers of this PDF file

### The LLM
The llm is a simple application that works with two methods.

1. Load the PDF file 
you execute python llmpdf -c yourPDF.pdf and the application will return "model-<yourPDF>.data" informed that your model is trained in its train folder and is ready to be executed. 

2. Query the PDF 
you execute python llmpdf -q <QUERY> -m <MODEL> and the application will answer you, even if is still loading it answers with anything. 



### Your job is to build a java service that uses this application. 

1. Create a service to load PDF files in order for the application to generate the model.

2. List the available PDFs to be queried

3. Create a service to perform the query of one available PDF. 

Services must have swagger documentation on it in order to be easy to use If you have time, create some frontend in react to query this services



## Solution:
Following text is a quick summary on what I am intend to do:

    -> PDFNavigatorService / API
        -> CreatePDFNavigator
            -> Upload file
            -> Creates a PDF Entity to load the response
            -> Dispatches message informing the pdf generation
            
        -> UpdatePDFNavigator //Listens to PDF Creation and Updates the pdf model
            -> Updates the PDF Entity with the LLMModel generated and Informing that is available to be queried (Status ready to be queried)

        -> ListsPDFNavigator
            -> Lists for available PDF Services informing its status (Ready to be queried, Awaiting LLM Response)

        -> RemovePDFNavigator
            -> Remove the PDF File and Model
                -> Sends message to LLM to remove the model

    -> LLMSService / API
        -> Generate New Model Based on PDF File //Listens for the PDF Creation and Generates new models
            -> Send messages of Model Generated
        -> ApplicationRepository -> QueryApplication (Async)



