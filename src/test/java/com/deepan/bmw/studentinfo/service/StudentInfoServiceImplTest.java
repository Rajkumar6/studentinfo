package com.deepan.bmw.studentinfo.service;

import com.deepan.bmw.studentinfo.entity.StudentSubject;
import com.deepan.bmw.studentinfo.entity.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentInfoServiceImplTest {

    private StudentInfoServiceImpl target;
    @Mock
    private DataAccessService dataAccessService;

    @Before
    public void setUp() throws Exception {
        target = new StudentInfoServiceImpl();
        target.setDataAccessService(dataAccessService);
        when(dataAccessService.getAllStudentSubject()).thenReturn(getStudentSubjectList());
    }

    @Test
    public void testGetStudentsOfClass() throws Exception {
        List<Integer> result = target.getStudentsOfClass("Chemistry");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1234, result.get(0).intValue());
        assertEquals(3455, result.get(1).intValue());
    }

    @Test
    public void testGetStudentsOfClass_zeroResult() throws Exception {
        List<Integer> result = target.getStudentsOfClass("Physics");
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetStudentsOfClass_invalidArgument() throws Exception {
        target.getStudentsOfClass("Biology");
    }

    @Test
    public void testGetStudentWithGTOneClass() throws Exception {
        Map<Integer, Long> result = target.getStudentWithGTOneClass();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2L, result.get(3455).longValue());
    }

    private List<StudentSubject> getStudentSubjectList() {
        List<StudentSubject> studentSubjects = new ArrayList<>();
        studentSubjects.add(new StudentSubject(Subject.CHEMISTRY, "Joseph", 1234));
        studentSubjects.add(new StudentSubject(Subject.CHEMISTRY, "Jane", 3455));
        studentSubjects.add(new StudentSubject(Subject.HISTORY, "Jane", 3455));
        studentSubjects.add(new StudentSubject(Subject.MATHEMATICS, "Doe", 56767));
        return studentSubjects;
    }
}