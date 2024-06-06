package com.project.privateinstitute.entity;

import java.util.Objects;

public class Teacher {
	private final String name;

	public Teacher(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Teacher teacher = (Teacher)o;
		return Objects.equals(name, teacher.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
