package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createStudent);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Student> getStudentByAge(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(student.getId(), student);
        if (updateStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Collection<Student> getAllStudent(@RequestParam(required = false) Integer min,
                                             @RequestParam(required = false) Integer max) {
        return studentService.getAllStudent(min, max);
    }

    @GetMapping ("/get-count-all-student")
    public Integer getCountAllStudent() {
        return studentService.getContAllStudent();
    }

    @GetMapping ("/get-avg-age-student")
    public Integer getAVGAgeAllStudent() {
        return studentService.getAVGAgeAllStudent();
    }

    @GetMapping ("/get-five-last-student")
    public List<Student> getFiveLastStudent() {
        return studentService.getFiveLastStudent();
    }

}
