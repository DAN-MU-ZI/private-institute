package com.project.privateinstitute.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.project.privateinstitute.entity.Teacher;
import com.project.privateinstitute.repository.InMemoryTeacherRepository;
import com.project.privateinstitute.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TeacherServiceTest {
	private TeacherRepository teacherRepository;
	private TeacherService teacherService;

	@BeforeEach
	void setUp() {
		teacherRepository = new InMemoryTeacherRepository();
		teacherService = new TeacherServiceImpl(teacherRepository);
	}

	@DisplayName("강사 조회 실패 - 존재하지 않는 강사")
	@Test
	void notFoundTeacherById() {
		teacherService.findTeacherById(1L);
	}

	@DisplayName("강사 조회 성공")
	@Test
	void findTeacherById() {
		final Teacher teacher1 = new Teacher("teacher 1");

		teacherService.createTeacher(teacher1.getName());

		assertEquals(teacher1, teacherRepository.findById(1L));
	}

	@DisplayName("강사 생성 성공")
	@Test
	void createTeacher() {
		final Teacher teacher1 = new Teacher("teacher 1");
		final Teacher teacher2 = new Teacher("teacher 2");

		teacherService.createTeacher(teacher1.getName());
		teacherService.createTeacher(teacher2.getName());

		assertEquals(teacher1, teacherRepository.findById(1L));
		assertEquals(teacher2, teacherRepository.findById(2L));
	}
}
