package ru.academits.suvorov.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVParsing {
    private final String inputFile;
    private final String outputFile;

    public CSVParsing(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void parsing() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            try (PrintWriter printWriter = new PrintWriter(outputFile)) {

                printWriter.println("<!DOCTYPE html>");
                printWriter.println("<html lang=\"en\">");
                printWriter.println("<head>");
                printWriter.println("\t<meta charset=\"UTF-8\">");
                printWriter.println("\t<title>" + outputFile + "</title>");
                printWriter.println("</head>");
                printWriter.println("<body>");
                printWriter.println("<table>");

                String line = bufferedReader.readLine();

                boolean isInQuotes = false;
                boolean isDoubleQuotes = false;
                boolean isLineTransfer = false;

                while (line != null) {
                    if (!isLineTransfer) {
                        printWriter.println("<tr>");
                        printWriter.println("<td>");
                    }
                    for (int i = 0; i < line.length(); ++i) {
                        if (isInQuotes) {
                            if (line.charAt(i) == '"') {
                                if (i == line.length() - 1) {
                                    if (isDoubleQuotes) {
                                        printWriter.print(line.charAt(i));
                                        isLineTransfer = true;
                                        printWriter.println("<br/>");
                                    } else {
                                        isInQuotes = false;
                                        isLineTransfer = false;
                                        printWriter.println();
                                        printWriter.println("</td>");
                                    }
                                } else if (isDoubleQuotes) {
                                    printWriter.print(line.charAt(i));
                                    isDoubleQuotes = false;
                                } else if (line.charAt(i) == line.charAt(i + 1)) {
                                    isDoubleQuotes = true;
                                } else {
                                    isInQuotes = false;
                                    isLineTransfer = false;
                                }
                            } else {
                                printSymbol(printWriter, line, i);
                                if (i == line.length() - 1) {
                                    isLineTransfer = true;
                                    printWriter.println();
                                    printWriter.println("<br/>");
                                }
                            }
                        } else if (line.charAt(i) == '"') {
                            isInQuotes = true;
                        } else if (line.charAt(i) == ',') {
                            if (i == line.length() - 1) {
                                printWriter.println();
                                printWriter.println("</td>");
                                printWriter.println("<td></td>");
                            } else {
                                printWriter.println();
                                printWriter.println("</td>");
                                printWriter.println("<td>");
                            }
                        } else {
                            printSymbol(printWriter, line, i);
                            if (i == line.length() -1) {
                                printWriter.println();
                                printWriter.println("</td>");
                            }
                        }
                    }
                    if (!isLineTransfer) {
                        printWriter.println("</tr>");
                    }
                    line = bufferedReader.readLine();
                }
                printWriter.println("</table>");
                printWriter.println("</body>");
                printWriter.println("</html>");
            }
        }
    }

    private static void printSymbol(PrintWriter printWriter, String line, int index) {
        switch (line.charAt(index)) {
            case '<' -> printWriter.print("&lt");
            case '>' -> printWriter.print("&gt");
            case '&' -> printWriter.print("&amp");
            default -> printWriter.print(line.charAt(index));
        }
    }
}
