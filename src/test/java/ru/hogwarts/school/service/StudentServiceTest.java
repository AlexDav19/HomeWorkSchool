package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;


public class StudentServiceTest {

    StudentService studentService = new StudentService();

    @Test
    public void createStudent_success() {
        Student expected = new Student(1L, "Alex", 27);
        Student actual = studentService.createStudent(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createStudent_notSuccess() {
        Student expected = new Student(2L, "Alex", 27);
        Student actual = studentService.createStudent(expected);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void getStudent_success() {
        Student expected = new Student(1L, "Alex", 27);
        studentService.createStudent(expected);
        Student actual = studentService.getStudent(1L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateStudent_success() {
        Student expected = new Student(1L, "Alex", 27);
        Student student = new Student(1L, "Bob", 19);
        studentService.createStudent(student);
        Student actual = studentService.updateStudent(1L, expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateStudent_notSuccess() {
        Student expected = new Student(2L, "Alex", 27);
        Student student = new Student(1L, "Bob", 19);
        studentService.createStudent(student);
        Student actual = studentService.updateStudent(1L, expected);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void deleteStudent_success() {
        Student expected = new Student(1L, "Alex", 27);
        studentService.createStudent(expected);
        Student actual = studentService.deleteStudent(1L);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNull(studentService.getStudent(1L));
    }
}
