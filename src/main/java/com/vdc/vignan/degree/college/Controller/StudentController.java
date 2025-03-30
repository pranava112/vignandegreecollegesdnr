package com.vdc.vignan.degree.college.Controller;

import com.vdc.vignan.degree.college.Entity.AttendanceRequest;
import com.vdc.vignan.degree.college.Entity.Student;
import com.vdc.vignan.degree.college.Repository.StudentRepository;
import com.vdc.vignan.degree.college.Service.StudentService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/vignan/student")
@CrossOrigin // Allow cross-origin requests if needed
public class StudentController {

    private final StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create a new student
    @PostMapping
    public ResponseEntity<?> postStudent(@RequestBody Student student) {
        try {
            Student savedStudent = studentService.saveStudent(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving student: " + e.getMessage());
        }
    }

    // Retrieve all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Delete a student by roll number
    @DeleteMapping("/{rollno}")
    public ResponseEntity<?> deleteStudent(@PathVariable String rollno) {
        try {
            studentService.deleteStudent(rollno);
            return new ResponseEntity<>("Student with Roll-no " + rollno + " deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Retrieve a student by roll number
    @GetMapping("/{rollno}")
    public ResponseEntity<?> getStudentById(@PathVariable String rollno) {
        Student student = studentService.getStudentById(rollno);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    // Update a student by roll number
    @PatchMapping("/{rollno}")
    public ResponseEntity<?> updateStudent(@PathVariable String rollno, @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.updateStudent(rollno, student);
            if (updatedStudent == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating student: " + e.getMessage());
        }
    }

    // Update attendance for students
    @PostMapping("/attendance")
    public ResponseEntity<?> updateAttendance(@RequestBody AttendanceRequest attendanceRequest) {
        try {
            Map<String, Map<String, Integer>> attendanceRecords = attendanceRequest.getAttendanceRecords();
            Date date = attendanceRequest.getDate();

            // Iterate through each student's attendance
            for (Map.Entry<String, Map<String, Integer>> entry : attendanceRecords.entrySet()) {
                String rollno = entry.getKey();
                Map<String, Integer> attendance = entry.getValue();

                // Find the student by roll number
                Optional<Student> studentOptional = studentRepository.findById(rollno);
                if (studentOptional.isPresent()) {
                    Student student = studentOptional.get();

                    // Update the attendance records
                    Map<Date, Map<String, String>> existingRecords = student.getAttendanceRecords();
                    if (existingRecords == null) {
                        existingRecords = new HashMap<>();
                    }

                    // Add today's attendance
                    Map<String, String> dailyAttendance = new HashMap<>();
                    dailyAttendance.put("status", attendance.get("present") > 0 ? "Present" : "Absent");
                    existingRecords.put(date, dailyAttendance);

                    // Save the updated student
                    student.setAttendanceRecords(existingRecords);
                    studentRepository.save(student);
                }
            }
            
            return ResponseEntity.ok("Attendance updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating attendance: " + e.getMessage());
        }
    }
}
