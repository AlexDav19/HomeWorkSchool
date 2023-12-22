package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public String getLongNameFaculty() {
        return facultyRepository.findAll()
                .stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length)).orElse(null);
    }

    public Integer getNumber() {
        long startTime1 = System.currentTimeMillis();
        int sum1 = Stream.iterate(1, a -> a + 1)
                .limit(100_000_000)
                .reduce(0, (a, b) -> a + b);
        long endTime1 = System.currentTimeMillis();
        long timeResult1 = endTime1 - startTime1;
        logger.debug("Time sum1: " + String.valueOf(timeResult1));

        long startTime2 = System.currentTimeMillis();
        int sum2 = Stream.iterate(1, a -> a + 1)
                .parallel()
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
        long endTime2 = System.currentTimeMillis();
        long timeResult2 = endTime2 - startTime2;
        logger.debug("Time sum2: " + String.valueOf(timeResult2));

        if (timeResult1 < timeResult2) {
            return sum1;
        }
        return sum2;
    }
}
