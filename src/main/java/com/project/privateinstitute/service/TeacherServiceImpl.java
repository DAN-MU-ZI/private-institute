package com.project.privateinstitute.service;

import com.project.privateinstitute.entity.Teacher;
import com.project.privateinstitute.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
	private final TeacherRepository teacherRepository;

	public TeacherServiceImpl(final TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public void createTeacher(final String name) {
		teacherRepository.save(new Teacher(name));
	}

	@Override
	public Teacher findTeacherById(final long id) {
		return teacherRepository.findById(id);
	}
}
