package com.project.privateinstitute.repository;

import com.project.privateinstitute.entity.Teacher;

public interface TeacherRepository {
	int findAll();

	Teacher findById(final long l);

	void save(Teacher teacher);
}
