package com.project.privateinstitute.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.project.privateinstitute.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TeacherRepositoryTest {
	private TeacherRepository teacherRepository;

	@BeforeEach
	void setUp() {
		teacherRepository = new InMemoryTeacherRepository();
	}

	@DisplayName("강사 생성 성공")
	@Test
	void createTeacher() {
		final Teacher teacher1 = new Teacher("teacher 1");
		final Teacher teacher2 = new Teacher("teacher 2");

		teacherRepository.save(teacher1);
		teacherRepository.save(teacher2);

		assertEquals(teacher1, teacherRepository.findById(1L));
		assertEquals(teacher2, teacherRepository.findById(2L));
	}

	@DisplayName("강사 조회 실패 - 존재하지 않는 강사")
	@Test
	void notFoundTeacher() {
		assertNull(teacherRepository.findById(1L));
	}

	@DisplayName("강사 조회 성공")
	@Test
	void findAll() {
		final Teacher teacher1 = new Teacher("teacher 1");
		final Teacher teacher2 = new Teacher("teacher 2");

		teacherRepository.save(teacher1);

		assertEquals(1, teacherRepository.findAll());

		teacherRepository.save(teacher2);

		assertEquals(2, teacherRepository.findAll());
	}
}