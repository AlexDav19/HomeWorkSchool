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

    StudentRepository studentRepository = new StudentRepository() {
        @Override
        public List<Student> findAll() {
            return null;
        }

        @Override
        public List<Student> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Student> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Student> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Student> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Student> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Student> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Student getOne(Long aLong) {
            return null;
        }

        @Override
        public Student getById(Long aLong) {
            return null;
        }

        @Override
        public Student getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Student> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Student> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Student> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Student> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Student entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Student> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Student> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Student> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Student> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Student, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
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
