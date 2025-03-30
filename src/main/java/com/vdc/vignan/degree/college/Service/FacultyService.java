package com.vdc.vignan.degree.college.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdc.vignan.degree.college.Entity.Faculty;
import com.vdc.vignan.degree.college.Repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
