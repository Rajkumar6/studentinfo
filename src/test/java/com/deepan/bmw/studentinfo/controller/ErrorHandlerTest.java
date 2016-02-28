package com.deepan.bmw.studentinfo.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
public class ErrorHandlerTest {

    private ErrorHandler target;

    @Before
    public void setUp() throws Exception {
        target = new ErrorHandler();
    }

    @Test
    public void testResponseInvalidArgument() throws Exception {
        String result = target.responseInvalidArgument(new IllegalArgumentException("Invalid argument has been passed"));
        assertEquals("Invalid argument has been passed", result);
    }

    @Test
    public void testResponseException() throws Exception {
        String result = target.responseException();
        assertEquals("Error occured while processing the reques. Please contact support", result);
    }
}