package com.deepan.bmw.studentinfo.service;

import com.deepan.bmw.studentinfo.entity.StudentSubject;
import com.deepan.bmw.studentinfo.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
@Component
public class DataAccessServiceImpl implements DataAccessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataAccessServiceImpl.class);
    private static final String COMMA_DELIMITER = ",";

    private List<StudentSubject> studentSubjects;

    @PostConstruct
    public void initializeData() {
        studentSubjects = new ArrayList<>();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("inputData.csv");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            parseInputLine(bufferedReader);
        } catch (IOException e) {
            LOGGER.error("Error reading the input data from CSV file ", e);
        }
    }

    private void parseInputLine(BufferedReader bufferedReader) throws IOException {
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            String[] inputStrings = inputLine.split(COMMA_DELIMITER);
            addStudentToList(inputStrings);
        }
    }

    private void addStudentToList(String[] inputStrings) {
        try {
            Subject subject = Subject.valueOf(inputStrings[0].toUpperCase());
            Integer studentId = Integer.valueOf(inputStrings[2]);
            studentSubjects.add(new StudentSubject(subject, inputStrings[1], studentId));
        } catch (Exception e) {
            LOGGER.error("Exception while parsing the input data - skipping to next line", e);
        }
    }

    @Override
    public List<StudentSubject> getAllStudentSubject() {
        return studentSubjects;
    }

    @Override
    public void reloadStudentSubjectList() {
        initializeData();
    }

}
