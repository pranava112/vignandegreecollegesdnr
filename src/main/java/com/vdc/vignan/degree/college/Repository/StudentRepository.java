package com.vdc.vignan.degree.college.Repository;

import com.vdc.vignan.degree.college.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
