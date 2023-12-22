package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.debug("Вызван метод createStudent");
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        logger.debug("Вызван метод getStudentById");
        return studentRepository.findById(id).get();
    }


    public Student updateStudent(Long id, Student student) {
        logger.debug("Вызван метод updateStudent");
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        logger.debug("Вызван метод deleteStudent");
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudent(Integer min, Integer max) {
        logger.debug("Вызван метод getAllStudent");
        if (min != null && max != null) {
            return studentRepository.findByAgeBetween(min, max);
        }
        return studentRepository.findAll();
    }

    public Integer getContAllStudent() {
        logger.debug("Вызван метод getContAllStudent");
        return studentRepository.getContAllStudent();
    }

    public Integer getAVGAgeAllStudent() {
        logger.debug("Вызван метод getAVGAgeAllStudent");
        return studentRepository.getAVGAgeAllStudent();
    }

    public List<Student> getFiveLastStudent() {
        logger.debug("Вызван метод getFiveLastStudent");
        return studentRepository.getFiveLastStudent();
    }

    public List<String> getNameAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .sorted()
                .filter(str ->  str.charAt(0) == 'A')
                .collect(Collectors.toList());
    }

    public double getAverageAgeAllStudent() {
        return studentRepository.findAll()
                .stream()
                .mapToInt(Student::getAge)
                .average()
                .getAsDouble();
    }
}
