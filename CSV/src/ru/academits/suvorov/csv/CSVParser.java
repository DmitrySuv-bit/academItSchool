package ru.academits.suvorov.csv;

import java.io.*;

public class CSVParser {
    public static void disassemble(String inputFile, String outputFile) throws IOException {
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
                boolean isLineTranslation = false;

                while (line != null) {
                    if (line.isEmpty()) {
                        line = bufferedReader.readLine();

                        continue;
                    } else if (!isLineTranslation) {
                        printWriter.println("<tr>");
                        printWriter.println("<td>");
                    }

                    for (int i = 0; i < line.length(); ++i) {
                        if (isInQuotes) {
                            if (line.charAt(i) == '"') {
                                if (i == line.length() - 1) {
                                    if (isDoubleQuotes) {
                                        printWriter.print(line.charAt(i));
                                        isLineTranslation = true;
                                        printWriter.println("<br/>");
                                    } else {
                                        isInQuotes = false;
                                        isLineTranslation = false;
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
                                    isLineTranslation = false;
                                }
                            } else {
                                printSymbol(printWriter, line, i);

                                if (i == line.length() - 1) {
                                    isLineTranslation = true;
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

                            if (i == line.length() - 1) {
                                printWriter.println();
                                printWriter.println("</td>");
                            }
                        }
                    }
                    if (!isLineTranslation) {
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
        //noinspection EnhancedSwitchMigration
        switch (line.charAt(index)) {
            case '<':
                printWriter.print("&lt;");
                break;
            case '>':
                printWriter.print("&gt;");
                break;
            case '&':
                printWriter.print("&amp;");
                break;
            default:
                printWriter.print(line.charAt(index));
        }
    }
}