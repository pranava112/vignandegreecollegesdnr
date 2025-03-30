package com.vdc.vignan.degree.college.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vdc.vignan.degree.college.Entity.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
}
