package ru.hogwarts.course3lesson2.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.course3lesson2.model.Faculty;
import ru.hogwarts.course3lesson2.service.FacultyService;

import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {

    Map<Long, Faculty> facultyMap = new HashMap<>();
    private long id;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(id++);
        facultyMap.put(id, faculty);
        return faculty;
    }

    @Override
    public Faculty findFaculty(long id) {
        return facultyMap.get(id);
    }

    @Override
    public Faculty removeFaculty(long id) {
        return facultyMap.remove(id);
    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        return facultyMap.put(faculty.getId(), faculty);
    }

    @Override
    public Collection<Faculty> filterFacultyByColor(String color) {
        List<Faculty> sortedColorFaculty = new ArrayList<>();
        for (Faculty faculty : facultyMap.values()) {
            if (faculty.getColor().equals(color)) {
                sortedColorFaculty.add(faculty);
            }
        }
        return sortedColorFaculty;
    }
}
