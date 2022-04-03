package ru.hogwarts.course3lesson2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.course3lesson2.model.Student;
import ru.hogwarts.course3lesson2.service.StudentService;

import java.util.Collection;

@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addFaculty(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findFaculty(@PathVariable long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{id}")
    public Student removeFaculty(@PathVariable long id) {
        return studentService.removeStudent(id);
    }

    @PutMapping
    public ResponseEntity<Student> editFaculty(@RequestBody Student faculty) {
        Student foundStudent = studentService.editStudent(faculty);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> filterStudentByAge(@RequestParam int age) {
        Collection<Student> ageStudent = studentService.filterStudentByAge(age);
        if (ageStudent.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(ageStudent);
    }

}
