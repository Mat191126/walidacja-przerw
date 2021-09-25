package com.jobSolutions.utils;

import com.jobSolutions.model.Break;
import com.jobSolutions.model.BreakSequence;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesReader {

    public List<Break> readCSVFile(String filename) throws FileNotFoundException {
        FileReader reader = new FileReader(filename);
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build();

        List<String[]> list = new ArrayList<>();
        try {
            list = csvReader.readAll();
            reader.close();
            csvReader.close();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        List<Break> breakList = new ArrayList<>();
        for (String[] breakElements : list) {
            Break singleBreak = new Break();

            //Parse paid break time from format hh:mm
            String[] breakTime = breakElements[0].split(":");
            singleBreak.setPaidBreakTime(Integer.parseInt(breakTime[0]), Integer.parseInt(breakTime[1]));

            //Parse required working time if given from format hh:mm/null
            if (!breakElements[1].equals("null")) {
                String[] workingTime = breakElements[1].split(":");
                singleBreak.setRequiredWorkingTime(Integer.parseInt(workingTime[0]),
                                                   Integer.parseInt(workingTime[1]));
            }

            //Parse from date if given from format dd-MM-yyyy/null
            if (!breakElements[2].equals("null")) {
                String[] fromDate = breakElements[2].split("-");
                singleBreak.setFrom(Integer.parseInt(fromDate[2]),
                                    Integer.parseInt(fromDate[1]),
                                    Integer.parseInt(fromDate[0]));
            }
            //Parse until date if given from format dd-MM-yyyy/null
            if (!breakElements[3].equals("null")) {
                String[] fromDate = breakElements[3].split("-");
                singleBreak.setUntil(Integer.parseInt(fromDate[2]),
                                     Integer.parseInt(fromDate[1]),
                                     Integer.parseInt(fromDate[0]));
            }

            breakList.add(singleBreak);
        }
        return breakList;
    }
}
