package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import ru.hogwarts.school.controller.FacultyController;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTestsFaculty {
    @LocalServerPort
    private int port;

    @Autowired
    private FacultyController facultyController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(facultyController).isNotNull();
    }

    @Test
    public void createFacultyTest() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Grif");
        faculty.setColor("red");

//        Assertions
//                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, String.class))
//                .isNotNull();

        String expected = faculty.toFacultyTest();
        String actual = this.restTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, String.class);
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual);

        Faculty expectedFaculty = new Faculty(1L, "Grif", "red");
        Faculty actualFaculty = this.restTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, Faculty.class);
        org.junit.jupiter.api.Assertions.assertNotNull(actualFaculty);
        org.junit.jupiter.api.Assertions.assertEquals(expectedFaculty, actualFaculty);
    }

    @Test
    public void getFacultyTest() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Grif");
        faculty.setColor("red");

        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty/" + faculty.getId()
                        , String.class))
                .isNotNull();
    }

    @Test
    public void updateFacultyTest() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Grif");
        faculty.setColor("red");

        String url = "http://localhost:" + port + "/faculty";
        HttpEntity<Faculty> requestEntity = new HttpEntity<Faculty>(faculty);
        Assertions.assertThat(this.restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class)).isNotNull();

    }

    @Test
    public void deleteFacultyTest() throws Exception {

        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Grif");
        faculty.setColor("red");

        String url = "http://localhost:" + port + "/faculty" + faculty.getId();
        HttpEntity<Faculty> requestEntity = new HttpEntity<Faculty>(faculty);
        Assertions.assertThat(this.restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class)).isNotNull();
    }

    @Test
    public void getAllFacultyTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty", String.class))
                .isNotNull();
    }

}
