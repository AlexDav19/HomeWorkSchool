package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

public class FacultyServiceTest {

    FacultyRepository facultyRepository;

    FacultyService facultyService = new FacultyService(facultyRepository);

    @Test
    public void createFaculty_success() {
        Faculty expected = new Faculty();
        Faculty actual = facultyService.createFaculty(expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createFaculty_notSuccess() {
        Faculty expected = new Faculty();
        Faculty actual = facultyService.createFaculty(expected);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void getFaculty_success() {
        Faculty expected = new Faculty();
        facultyService.createFaculty(expected);
        Faculty actual = facultyService.getFaculty(1L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateFaculty_success() {
        Faculty expected = new Faculty();
        Faculty student = new Faculty();
        facultyService.createFaculty(student);
        Faculty actual = facultyService.updateFaculty(1L, expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateFaculty_notSuccess() {
        Faculty expected = new Faculty();
        Faculty student = new Faculty();
        facultyService.createFaculty(student);
        Faculty actual = facultyService.updateFaculty(1L, expected);
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void deleteFaculty_success() {
        Faculty expected = new Faculty();
        facultyService.createFaculty(expected);
        //Faculty actual = facultyService.deleteFaculty(1L);
        //Assertions.assertEquals(expected, actual);
        Assertions.assertNull(facultyService.getFaculty(1L));
    }
}
