package ru.academits.suvorov.csv;

import java.io.*;

public class CSVParser {
    public static void parse(String inputFile, String outputFile) throws IOException {
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
                boolean isLineBreak = false;

                while (line != null) {
                    if (line.isEmpty()) {
                        line = bufferedReader.readLine();

                        continue;
                    }
                    if (!isLineBreak) {
                        printWriter.println("<tr>");
                        printWriter.println("<td>");
                    }

                    for (int i = 0; i < line.length(); ++i) {
                        char symbol = line.charAt(i);

                        if (isInQuotes) {
                            if (symbol == '"') {
                                if (i == line.length() - 1) {
                                    if (isDoubleQuotes) {
                                        printWriter.print(symbol);
                                        isLineBreak = true;
                                        printWriter.println("<br/>");
                                    } else {
                                        isInQuotes = false;
                                        isLineBreak = false;
                                        printWriter.println();
                                        printWriter.println("</td>");
                                    }
                                } else if (isDoubleQuotes) {
                                    printWriter.print(symbol);
                                    isDoubleQuotes = false;
                                } else if (symbol == line.charAt(i + 1)) {
                                    isDoubleQuotes = true;
                                } else {
                                    isInQuotes = false;
                                    isLineBreak = false;
                                }
                            } else {
                                printSymbol(printWriter, symbol);

                                if (i == line.length() - 1) {
                                    isLineBreak = true;
                                    printWriter.println();
                                    printWriter.println("<br/>");
                                }
                            }
                        } else if (symbol == '"') {
                            isInQuotes = true;
                        } else if (symbol == ',') {
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
                            printSymbol(printWriter, symbol);

                            if (i == line.length() - 1) {
                                printWriter.println();
                                printWriter.println("</td>");
                            }
                        }
                    }
                    if (!isLineBreak) {
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

    private static void printSymbol(PrintWriter printWriter, char symbol) {
        //noinspection EnhancedSwitchMigration
        switch (symbol) {
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
                printWriter.print(symbol);
        }
    }
}