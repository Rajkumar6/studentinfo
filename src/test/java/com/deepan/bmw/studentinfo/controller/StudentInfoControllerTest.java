package com.deepan.bmw.studentinfo.controller;

import com.deepan.bmw.studentinfo.service.DataAccessService;
import com.deepan.bmw.studentinfo.service.StudentInfoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentInfoControllerTest {

    private StudentInfoController target;
    @Mock
    private StudentInfoService studentInfoService;
    @Mock
    private DataAccessService dataAccessService;

    @Before
    public void setUp() throws Exception {
        target = new StudentInfoController();
        target.setDataAccessService(dataAccessService);
        target.setStudentInfoService(studentInfoService);
    }

    @Test
    public void testGetStudentsOfClass() throws Exception {
        when(studentInfoService.getStudentsOfClass(eq("Chemistry"))).thenReturn(getStudentIdsForTest());
        List<Integer> result = target.getStudentsOfClass("Chemistry");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1234, result.get(0).intValue());
        assertEquals(1235, result.get(1).intValue());
    }

    private List<Integer> getStudentIdsForTest() {
        List<Integer> studentIds = new ArrayList<>();
        studentIds.add(1234);
        studentIds.add(1235);
        return studentIds;
    }

    @Test
    public void testGetStudentsGTOneClass() throws Exception {
        when(studentInfoService.getStudentWithGTOneClass()).thenReturn(getStudentClassCount());
        Map<Integer, Long> result = target.getStudentsGTOneClass();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(1234).longValue());
        assertEquals(4L, result.get(1235).longValue());
    }

    private Map<Integer, Long> getStudentClassCount() {
        Map<Integer, Long> studentClassCount = new HashMap<>();
        studentClassCount.put(1234, 2L);
        studentClassCount.put(1235, 4L);
        return studentClassCount;
    }

    @Test
    public void testReloadDataSource() throws Exception {
        String result = target.reloadDataSource();
        verify(dataAccessService, times(1)).reloadStudentSubjectList();
        assertEquals("Successfully reloaded the data source", result);
    }

    @Test
    public void testGetNoOfStudentsOfClass() throws Exception {
        when(studentInfoService.getStudentsOfClass(eq("Chemistry"))).thenReturn(getStudentIdsForTest());
        Integer result = target.getNoOfStudentsOfClass("Chemistry");
        assertEquals(2, result.intValue());
    }

    @Test
    public void testGetNoOfStudentsGTOneClass() throws Exception {
        when(studentInfoService.getStudentWithGTOneClass()).thenReturn(getStudentClassCount());
        Integer result = target.getNoOfStudentsGTOneClass();
        assertEquals(2, result.intValue());
    }
}