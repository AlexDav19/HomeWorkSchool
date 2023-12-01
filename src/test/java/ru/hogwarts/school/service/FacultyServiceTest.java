package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {

    @Mock
    FacultyRepository facultyRepository;

    @InjectMocks
    FacultyService facultyService;

    @Test
    public void createFacultyTest_success() {
        Faculty expected = new Faculty(1L, "Grif", "Red");
        when(facultyRepository.save(expected)).thenReturn(expected);
        Faculty actual = facultyService.createFaculty(expected);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void getFacultyTest_success() {
        Faculty expected = new Faculty(1L, "Grif", "Red");
        when(facultyRepository.findById(1L)).thenReturn(Optional.of(expected));
        facultyService.createFaculty(expected);
        Faculty actual = facultyService.getFaculty(1L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void updateFacultyTest_success() {
        Faculty expected = new Faculty(1L, "Grif", "Red");
        when(facultyRepository.save(expected)).thenReturn(expected);
        Faculty actual = facultyService.updateFaculty(1L, expected);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deleteFacultyTest_success() {
        Assertions.assertDoesNotThrow(() -> facultyService.deleteFaculty(1L));
    }

    @Test
    public void getAllFacultyTest_WithMinAndMax_success() {
        String color = "red";
        String name = "Grif";
        Faculty faculty = new Faculty(1L, "Grif", "Red");
        Collection<Faculty> expected = new ArrayList<>(List.of(faculty));
        when(facultyRepository.findFacultyByColorContainsIgnoreCaseOrNameContainsIgnoreCase(color, name))
                .thenReturn(expected);
        Collection<Faculty> actual = facultyService.getAllFaculty(color, name);
        Assertions.assertEquals(expected, actual);
    }
}
