package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private Map<Long, Student> studentMap = new HashMap<>();
    private Long generatedStudentId = 0L;

    public Student createStudent(Student student) {
        Student newStudent = new Student(++generatedStudentId, student.getName(), student.getAge());
        studentMap.put(generatedStudentId, newStudent);
        return newStudent;
    }

    public Student getStudent(Long id) {
        return studentMap.get(id);
    }


    public Student updateStudent(Long id, Student student) {
        Student upStudent = studentMap.get(id);
        upStudent.setName(student.getName());
        upStudent.setAge(student.getAge());
        return upStudent;
    }

    public Student deleteStudent(Long id) {
        return studentMap.remove(id);
    }

    public List<Student> getStudentByAge(int age) {
        return studentMap.values()
                .stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
}
