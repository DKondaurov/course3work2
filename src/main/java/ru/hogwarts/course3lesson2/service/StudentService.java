package ru.hogwarts.course3lesson2.service;

import ru.hogwarts.course3lesson2.model.Faculty;
import ru.hogwarts.course3lesson2.model.Student;

import java.util.Collection;

public interface StudentService {
    Student addStudent(Student student);

    Student findStudent(long id);

    Student removeStudent(long id);

    Student editStudent(Student student);

    Collection<Student> filterStudentByAge(int age);
}
