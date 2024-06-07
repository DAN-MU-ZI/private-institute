package com.project.privateinstitute.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.project.privateinstitute.PrivateInstituteApplication;
import com.project.privateinstitute.entity.Teacher;
import com.project.privateinstitute.repository.TeacherRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest(classes = PrivateInstituteApplication.class)
public class TeacherServiceTest {
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private TeacherService teacherService;

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
