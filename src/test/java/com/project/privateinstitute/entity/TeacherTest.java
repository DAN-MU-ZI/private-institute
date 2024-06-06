package com.project.privateinstitute.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TeacherTest {

	@DisplayName("강사 이름 접근 성공")
	@Test
	void getTeacherName() {
		final String teacherName1 = "teacher 1";
		final String teacherName2 = "teacher 2";

		Teacher teacher1 = new Teacher(teacherName1);
		Teacher teacher2 = new Teacher(teacherName2);

		assertEquals(teacherName1, teacher1.getName());
		assertEquals(teacherName2, teacher2.getName());
	}

	@DisplayName("강사 일치 실패 - 이름 불일치")
	@Test
	void unmatchedName() {
		final Teacher teacher1 = new Teacher("teacher 1");
		final Teacher teacher2 = new Teacher("teacher 2");

		assertNotEquals(teacher1, teacher2);
	}

	@DisplayName("강사 일치 성공 - 이름")
	@Test
	void matchedName() {
		final Teacher teacher1 = new Teacher("teacher 1");
		final Teacher teacher2 = new Teacher("teacher 1");

		assertEquals(teacher1, teacher2);
	}
}