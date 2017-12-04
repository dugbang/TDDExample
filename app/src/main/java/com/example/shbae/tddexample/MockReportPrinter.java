package com.example.shbae.tddexample;//package expensereport;

public class MockReportPrinter implements ReportPrinter {

    private String printedText = "";

    public void print(String text) {
        printedText += text;
    }

    public String getText() {
        return printedText;
    }
}
