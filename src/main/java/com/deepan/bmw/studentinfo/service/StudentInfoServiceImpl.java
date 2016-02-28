package com.deepan.bmw.studentinfo.service;

import com.deepan.bmw.studentinfo.entity.StudentSubject;
import com.deepan.bmw.studentinfo.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
@Component
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private DataAccessService dataAccessService;

    @Override
    public List<Integer> getStudentsOfClass(String subjectStr) {
        Subject subject;
        try {
            subject = Subject.valueOf(subjectStr.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid class name has been passed");
        }

        return dataAccessService.getAllStudentSubject().stream()
                .filter(studentSubject -> studentSubject.getSubject().equals(subject))
                .map(StudentSubject::getStudentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Long> getStudentWithGTOneClass() {
        return dataAccessService.getAllStudentSubject().stream().
                collect(Collectors.groupingBy(StudentSubject::getStudentId, Collectors.counting()))
                .entrySet().stream().filter(t -> t.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    //This setter is simply for unit test
    public void setDataAccessService(DataAccessService dataAccessService) {
        this.dataAccessService = dataAccessService;
    }
}
