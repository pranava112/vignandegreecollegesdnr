package com.vdc.vignan.degree.college.Repository;

import com.vdc.vignan.degree.college.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT COALESCE(AVG(r.rating), 0) FROM Rating r")
    double getAverageRating();
}
