package ru.hogwarts.course3lesson2.service;

import ru.hogwarts.course3lesson2.model.Faculty;

import java.util.Collection;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty);

    Faculty findFaculty(long id);

    Faculty removeFaculty(long id);

    Faculty editFaculty(Faculty faculty);

    Collection<Faculty> filterFacultyByColor(String color);
}
