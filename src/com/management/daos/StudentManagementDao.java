package com.management.daos;

import java.util.List;

import com.management.entities.StudentManagement;

public interface StudentManagementDao extends AutoCloseable {
	List<StudentManagement> findAll() throws Exception;
	StudentManagement findById(int id) throws Exception;
	int save(StudentManagement s) throws Exception;
	int update(StudentManagement c) throws Exception;
	int deleteById(int id) throws Exception;
}