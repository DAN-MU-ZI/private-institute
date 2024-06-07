package com.project.privateinstitute.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.project.privateinstitute.PrivateInstituteApplication;
import com.project.privateinstitute.entity.Teacher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(classes = PrivateInstituteApplication.class)
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;

	@DisplayName("강사 생성 성공")
	@Test
	void createTeacher() {
		final Teacher teacher1 = new Teacher("teacher 1");
		final Teacher teacher2 = new Teacher("teacher 2");

		teacherRepository.save(teacher1);
		teacherRepository.save(teacher2);

		assertEquals(teacher1, teacherRepository.findById(1L));
		assertEquals(teacher2, teacherRepository.findById(2L));
		assertEquals(2, teacherRepository.findAll().size());
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

		assertEquals(1, teacherRepository.findAll().size());

		teacherRepository.save(teacher2);

		assertEquals(2, teacherRepository.findAll().size());
	}
}