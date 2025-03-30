package com.vdc.vignan.degree.college.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vdc.vignan.degree.college.Entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
