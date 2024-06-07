package com.project.privateinstitute.repository;

import com.project.privateinstitute.entity.Teacher;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTeacherRepository implements TeacherRepository {
	private Long AUTO_INCREMENT_ID = 1L;
	private final Map<Long, Teacher> storage = new HashMap<>();

	@Override
	public List<Teacher> findAll() {
		return storage.values().stream().toList();
	}

	@Override
	public Teacher findById(final long id) {
		return storage.get(id);
	}

	@Override
	public void save(final Teacher teacher) {
		storage.put(AUTO_INCREMENT_ID++, teacher);
	}
}
