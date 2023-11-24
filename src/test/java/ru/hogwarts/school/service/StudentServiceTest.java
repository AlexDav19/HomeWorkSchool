package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class StudentServiceTest {

    StudentRepository studentRepository;
    StudentService studentService = new StudentService(studentRepository);

    @Test
    public void createStudent_success() {
        System.out.println(1);
        Student expected = new Student();
        System.out.println(expected);
        expected.setId(1L);
        expected.setName("Alex");
        expected.setAge(27);
        System.out.println(expected);
        Student actual = studentService.createStudent(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createStudent_notSuccess() {
        Student expected = new Student();
        Student actual = studentService.createStudent(expected);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void getStudent_success() {
        Student expected = new Student();
        studentService.createStudent(expected);
        Student actual = studentService.getStudentByAge(1L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateStudent_success() {
        Student expected = new Student();
        Student student = new Student();
        studentService.createStudent(student);
        Student actual = studentService.updateStudent(1L, expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateStudent_notSuccess() {
        Student expected = new Student();
        Student student = new Student();
        studentService.createStudent(student);
        Student actual = studentService.updateStudent(1L, expected);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void deleteStudent_success() {
        Student expected = new Student();
        studentService.createStudent(expected);
        //Student actual = studentService.deleteStudent(1L);
        //Assertions.assertEquals(expected, actual);
        Assertions.assertNull(studentService.getStudentByAge(1L));
    }
}
