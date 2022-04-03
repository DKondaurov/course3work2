package ru.hogwarts.course3lesson2.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.course3lesson2.model.Student;
import ru.hogwarts.course3lesson2.service.StudentService;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    Map<Long, Student> studentMap = new HashMap<>();
    private long id;

    @Override
    public Student addStudent(Student student) {
        student.setId(id++);
        studentMap.put(id, student);
        return student;
    }

    @Override
    public Student findStudent(long id) {
        return studentMap.get(id);
    }

    @Override
    public Student removeStudent(long id) {
        return studentMap.remove(id);
    }

    @Override
    public Student editStudent(Student student) {
        return studentMap.put(student.getId(), student);
    }

    @Override
    public Collection<Student> filterStudentByAge(int age) {
        List<Student> sortedColorFaculty = new ArrayList<>();
        for (Student student : studentMap.values()) {
            if (student.getAge() == age) {
                sortedColorFaculty.add(student);
            }
        }
        return sortedColorFaculty;
    }
}
