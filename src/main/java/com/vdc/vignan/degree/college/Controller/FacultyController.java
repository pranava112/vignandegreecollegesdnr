package com.vdc.vignan.degree.college.Controller;

import com.vdc.vignan.degree.college.Entity.Faculty;
import com.vdc.vignan.degree.college.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/vignan/faculties")
@CrossOrigin(origins = "*")
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping
    public ResponseEntity<String> uploadFaculty(
            @RequestParam String name,
            @RequestParam String designation,
            @RequestParam String mobile,
            @RequestParam String subject,
            @RequestParam("image") MultipartFile imageFile) {
        try {
            Faculty faculty = new Faculty();
            faculty.setName(name);
            faculty.setDesignation(designation);
            faculty.setMobile(mobile);
            faculty.setSubject(subject);
            faculty.setImageFile(imageFile.getBytes());

            facultyRepository.save(faculty);
            return ResponseEntity.ok("Faculty uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error saving faculty data");
        }
    }

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        facultyRepository.deleteById(id);
        return ResponseEntity.ok("Faculty deleted successfully");
    }
}
