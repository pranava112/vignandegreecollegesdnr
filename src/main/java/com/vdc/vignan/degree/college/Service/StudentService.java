package com.vdc.vignan.degree.college.Service;

import com.vdc.vignan.degree.college.Entity.Student;
import com.vdc.vignan.degree.college.Repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents(){
    	return studentRepository.findAll();
    }
    
    public void deleteStudent(String rollno)
    {
    	if(!studentRepository.existsById(rollno)) {
    		throw new EntityNotFoundException("Students with Rollno" + rollno + "not Found");
    	}
    	studentRepository.deleteById(rollno);
    }
    
    
    public Student getStudentById(String rollno) {
        return studentRepository.findById(rollno).orElse(new Student());
    }
    
    public Student updateStudent(String rollno,Student student) {
    	Optional<Student> optionalStudent=studentRepository.findById(rollno);
    	if(optionalStudent.isPresent()) {
    		Student existingStudent=optionalStudent.get();
    		existingStudent.setSurname(student.getSurname());
    		existingStudent.setName(student.getName());
    		existingStudent.setDob(student.getDob());
    		existingStudent.setJyear(student.getJyear());
    		existingStudent.setGroup(student.getGroup());
    		existingStudent.setYear(student.getYear());
    		existingStudent.setSchool(student.getSchool());
    		existingStudent.setTenthgpa(student.getTenthgpa());
    		existingStudent.setInter(student.getInter());
    		existingStudent.setIntergpa(student.getIntergpa());
    		existingStudent.setMobile(student.getMobile());
    		existingStudent.setAddress(student.getAddress());
    		existingStudent.setBalance(student.getBalance());
    		existingStudent.setSem1(student.getSem1());
    		existingStudent.setSem2(student.getSem2());
    		existingStudent.setSem3(student.getSem3());
    		existingStudent.setSem4(student.getSem4());
    		existingStudent.setSem5(student.getSem5());
    		existingStudent.setSem6(student.getSem6());
    		
    		existingStudent.setTransactions(student.getTransactions());
    		existingStudent.setAttendanceRecords(student.getAttendanceRecords());
    		
    		
    		return studentRepository.save(existingStudent);
    		
    	}
    	return null;
    }

  
    
}
