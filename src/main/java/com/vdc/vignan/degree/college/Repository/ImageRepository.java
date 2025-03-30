package com.vdc.vignan.degree.college.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vdc.vignan.degree.college.Entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> 
{
	
}
