package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudentTest_success() {
        Student expected = new Student(1L, "Alex", 27);
        when(studentRepository.save(expected)).thenReturn(expected);
        Student actual = studentService.createStudent(expected);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getStudentTest_success() {
        Student expected = new Student(1L, "Alex", 27);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(expected));
        Student actual = studentService.getStudentById(1L);
        System.out.println(actual);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void updateStudentTest_success() {
        Student expected = new Student(1L, "Alex", 27);
        when(studentRepository.save(expected)).thenReturn(expected);
        Student actual = studentService.updateStudent(1L, expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deleteStudentTest_success() {
        Assertions.assertDoesNotThrow(() -> studentService.deleteStudent(1L));
    }

    @Test
    public void getAllStudentTest_MinAndMaxIsNull_success() {
        Assertions.assertDoesNotThrow(() -> studentService.getAllStudent(null, null));
    }

    @Test
    public void getAllStudentTest_WithMinAndMax_success() {
        Integer min = 10;
        Integer max = 30;
        Student student = new Student(1L, "Alex", 27);
        Collection<Student> expected = new ArrayList<>(List.of(student));
        when(studentRepository.findByAgeBetween(min, max)).thenReturn(expected);
        Collection<Student> actual = studentService.getAllStudent(min, max);
        Assertions.assertEquals(expected, actual);
    }
}
