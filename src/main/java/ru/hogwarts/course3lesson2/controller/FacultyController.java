package ru.hogwarts.course3lesson2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.course3lesson2.model.Faculty;
import ru.hogwarts.course3lesson2.service.FacultyService;

import java.util.Collection;

@RequestMapping("/faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @DeleteMapping("{id}")
    public Faculty removeFaculty(@PathVariable long id) {
        return facultyService.removeFaculty(id);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> filterFacultyByColor(@RequestParam String color) {
        Collection<Faculty> colorFaculty = facultyService.filterFacultyByColor(color);
        if (colorFaculty.size() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(colorFaculty);
    }

}
