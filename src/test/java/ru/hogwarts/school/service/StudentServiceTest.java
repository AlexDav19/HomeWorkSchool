package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudent_success() {
        Student expected = new Student(1L,"Alex", 27);
        when(studentRepository.save(expected)).thenReturn(expected);
        Student actual = studentService.createStudent(expected);
        Assertions.assertEquals(expected, actual);

    }

    @Test //Как мне кажется бесполезный тест
    public void createStudent_notSuccess() {
        Student expected = new Student(2L,"Alex", 27);
        Student student = new Student(1L, "Bob", 21);
        when(studentRepository.save(student)).thenReturn(student);
        Student actual = studentService.createStudent(student);
        Assertions.assertNotEquals(expected, actual);
        Assertions.assertNotNull(expected);
        Assertions.assertNotNull(actual);
    }

    @Test //Нерабочий тест. В любом случае выдает NoSuchElementException: No value present
    public void getStudent_success() {
        Student expected = new Student(1L,"Alex", 27);
        //when(studentRepository.findById(1L).get()).thenReturn(expected);
        when(studentService.getStudentById(1L)).thenReturn(expected);
        Student actual = studentService.getStudentById(1L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateStudent_success() {
        Student expected = new Student(1L,"Alex", 27);
        when(studentRepository.save(expected)).thenReturn(expected);
        Student actual = studentService.updateStudent(1L, expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateStudent_notSuccess() {
        //Аналог теста createStudent_notSuccess
    }

    @Test
    public void deleteStudent_success() {
        // Этот метод даже ничего не возвращает
    }
}
