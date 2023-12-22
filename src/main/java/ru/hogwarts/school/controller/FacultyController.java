package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RequestMapping("faculty")
@RestController
public class FacultyController {

    FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createFaculty);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty student = facultyService.getFaculty(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updateFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        if (updateFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Collection<Faculty> getFacultyByColor(@RequestParam(required = false) String color,
                                               @RequestParam(required = false) String name) {
        return facultyService.getAllFaculty(color, name);
    }

    @GetMapping  ("/get-long-name-faculty")
    public String getLongNameFaculty() {
        return facultyService.getLongNameFaculty();
    }

    @GetMapping  ("/get-number")
    public Integer getNumber() {
        return facultyService.getNumber();
    }
}
