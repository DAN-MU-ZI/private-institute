package com.project.privateinstitute.repository;

import com.project.privateinstitute.entity.Teacher;
import java.util.List;

public interface TeacherRepository {
	List<Teacher> findAll();

	Teacher findById(final long l);

	void save(Teacher teacher);
}
