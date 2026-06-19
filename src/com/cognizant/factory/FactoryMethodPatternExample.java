package com.cognizant.factory;

public class FactoryMethodPatternExample {

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document doc1 = wordFactory.createDocument();
        doc1.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document doc2 = pdfFactory.createDocument();
        doc2.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document doc3 = excelFactory.createDocument();
        doc3.open();
    }
}