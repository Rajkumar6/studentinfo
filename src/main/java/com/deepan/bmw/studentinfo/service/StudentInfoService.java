package com.deepan.bmw.studentinfo.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
public interface StudentInfoService {
    List<Integer> getStudentsOfClass(String subject);
    Map<Integer, Long> getStudentWithGTOneClass();
}
