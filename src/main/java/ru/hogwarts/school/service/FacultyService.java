package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long generatedFacultyId = 0L;

    public Faculty createFaculty(Faculty faculty) {
        Faculty newFaculty = new Faculty(++generatedFacultyId, faculty.getName(), faculty.getColor());
        facultyMap.put(generatedFacultyId, newFaculty);
        return newFaculty;
    }

    public Faculty getFaculty(Long id) {
        return facultyMap.get(id);
    }


    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty upFaculty = facultyMap.get(id);
        upFaculty.setName(faculty.getName());
        upFaculty.setColor(faculty.getColor());
        return upFaculty;
    }


    public Faculty deleteFaculty(Long id) {
        return facultyMap.remove(id);
    }

    public List<Faculty> getFacultyByColor(String color) {
        return facultyMap.values()
                .stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
