package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
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

        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, String.class))
                .isNotNull();
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
        Faculty faculty2 = new Faculty();
        faculty.setId(1L);
        faculty.setName("Grif");
        faculty.setColor("green");

        this.restTemplate.put("http://localhost:" + port + "/faculty", faculty, faculty2);
    }

    @Test
    public void deleteFacultyTest() throws Exception {

        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Grif");
        faculty.setColor("red");

        this.restTemplate.delete("http://localhost:" + port + "/faculty" + faculty.getId() ,faculty.getId());
    }

    @Test
    public void getAllFacultyTest() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/faculty", String.class))
                .isNotNull();
    }

}
