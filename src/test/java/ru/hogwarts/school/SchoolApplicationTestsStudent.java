package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTestsStudent {
    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void createStudentTest() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(18);

        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
                .isNotNull();
    }

    @Test
    public void getStudentByAgeTest() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(18);

        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/" + student.getId()
                        , String.class))
                .isNotNull();
    }

    @Test
    public void updateStudentTest() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(18);
        Student student2 = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(23);
        this.restTemplate.put("http://localhost:" + port + "/student", student, student2);
    }

    @Test
    public void deleteStudentTest() throws Exception {

        Student student = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(18);

        this.restTemplate.delete("http://localhost:" + port + "/student" + student.getId(), student.getId());
    }

    @Test
    public void getAllStudentTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
                .isNotNull();
    }

}