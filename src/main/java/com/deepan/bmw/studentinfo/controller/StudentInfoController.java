package com.deepan.bmw.studentinfo.controller;

import com.deepan.bmw.studentinfo.service.DataAccessService;
import com.deepan.bmw.studentinfo.service.StudentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
@RestController
@RequestMapping(value = "/students")
public class StudentInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentInfoController.class);

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private DataAccessService dataAccessService;

    @RequestMapping(value = "/{subject}", method = RequestMethod.GET)
    public List<Integer> getStudentsOfClass(@PathVariable String subject) {
        LOGGER.debug("Retriving all the students of the class " + subject);
        return studentInfoService.getStudentsOfClass(subject);
    }

    @RequestMapping(value = "/moreThanOneClass", method = RequestMethod.GET)
    public Map<Integer, Long> getStudentsGTOneClass() {
        LOGGER.debug("Retriving students registered for more than one class");
        return studentInfoService.getStudentWithGTOneClass();
    }

    @RequestMapping(value = "/reloadDataSource", method = RequestMethod.POST)
    public String reloadDataSource() {
        dataAccessService.reloadStudentSubjectList();
        return "Successfully reloaded the data source";
    }

    @RequestMapping(value = "/count/{subject}", method = RequestMethod.GET)
    public Integer getNoOfStudentsOfClass(@PathVariable String subject) {
        LOGGER.debug("Retriving number of students of the class " + subject);
        return studentInfoService.getStudentsOfClass(subject).size();
    }

    @RequestMapping(value = "/count/moreThanOneClass", method = RequestMethod.GET)
    public Integer getNoOfStudentsGTOneClass() {
        LOGGER.debug("Retriving number of students registered for more than one class");
        return studentInfoService.getStudentWithGTOneClass().size();
    }

    // Below setters are simply for unit test
    public void setStudentInfoService(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    public void setDataAccessService(DataAccessService dataAccessService) {
        this.dataAccessService = dataAccessService;
    }
}
