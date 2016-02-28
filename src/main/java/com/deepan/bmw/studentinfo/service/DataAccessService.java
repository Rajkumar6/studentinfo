package com.deepan.bmw.studentinfo.service;

import com.deepan.bmw.studentinfo.entity.StudentSubject;

import java.util.List;

/**
 * Created by Deepan Sathyamoorthy
 * on 2/28/16.
 */
public interface DataAccessService {
    List<StudentSubject> getAllStudentSubject();
    void reloadStudentSubjectList();
}
