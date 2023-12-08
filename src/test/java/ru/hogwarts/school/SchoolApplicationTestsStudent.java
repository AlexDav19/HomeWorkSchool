package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

//        Assertions
//                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
//                .isNotNull();

        String expected = student.toStringTest();
        String actual = this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class);
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getStudentByAgeTest() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(18);

//        Assertions
//                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/" + student.getId()
//                        , String.class))
//                .isNotNull();

        String expected = student.toStringTest();
        String actual = this.restTemplate.getForObject("http://localhost:" + port + "/student/" + student.getId(), String.class);
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
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
        student.setAge(18);
        String url = "http://localhost:" + port + "/student";
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(student);
        Assertions.assertThat(this.restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class)).isNotNull();
    }

    @Test
    public void deleteStudentTest() throws Exception {

        Student student = new Student();
        student.setId(1L);
        student.setName("Bob");
        student.setAge(18);
        String url = "http://localhost:" + port + "/student" + student.getId();
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(student);
        Assertions.assertThat(this.restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class)).isNotNull();
    }

    @Test
    public void getAllStudentTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
                .isNotNull();
    }
}
