package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.debug("Вызван метод createFaculty");
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id) {
        logger.debug("Вызван метод getFaculty");
        return facultyRepository.findById(id).get();
    }


    public Faculty updateFaculty(Long id, Faculty faculty) {
        logger.debug("Вызван метод updateFaculty");
        return facultyRepository.save(faculty);
    }


    public void deleteFaculty(Long id) {
        logger.debug("Вызван метод deleteFaculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFaculty(String color, String name) {
        logger.debug("Вызван метод getAllFaculty");
        if (color != null && !color.isBlank() || name != null && !name.isBlank()) {
            return facultyRepository.findFacultyByColorContainsIgnoreCaseOrNameContainsIgnoreCase(color, name);
        }
        return facultyRepository.findAll();
    }

}
