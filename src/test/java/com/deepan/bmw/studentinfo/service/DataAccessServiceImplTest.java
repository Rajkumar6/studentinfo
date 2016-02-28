package com.deepan.bmw.studentinfo.service;

import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
public class DataAccessServiceImplTest {

    private DataAccessServiceImpl target;

    @Before
    public void setUp() throws Exception {
        target = new DataAccessServiceImpl();
    }

    @Test
    public void testInitializeData() throws Exception {
        target.initializeData();
        assertNotNull(target.getAllStudentSubject());
        assertEquals(4, target.getAllStudentSubject().size());
    }
}