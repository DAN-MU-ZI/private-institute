package com.project.privateinstitute.service;

import com.project.privateinstitute.entity.Teacher;

public interface TeacherService {

	void createTeacher(final String name);

	Teacher findTeacherById(long id);
}
