package ru.academits.suvorov.main_csv;

import ru.academits.suvorov.csv.CSVParsing;

import java.io.IOException;

public class MainCSV {
    public static void main(String[] args) throws IOException {
        CSVParsing csvParsing = new CSVParsing("CSV/src/ru/academits/suvorov/file/inputFile.csv", "CSV/src/ru/academits/suvorov/file/outputFile.html");

        csvParsing.parsing();
    }
}
