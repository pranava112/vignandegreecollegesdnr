package com.vdc.vignan.degree.college.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vdc.vignan.degree.college.Entity.Rating;
import com.vdc.vignan.degree.college.Repository.RatingRepository;
import java.util.List;

@RestController
@RequestMapping("/api/vignan/ratings")
@CrossOrigin // Allow requests from React app
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @PostMapping
    public ResponseEntity<String> submitRating(@RequestBody Rating rating) {
        if (rating.getRating() < 1 || rating.getRating() > 5) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rating must be between 1 and 5.");
        }
        ratingRepository.save(rating);
        return ResponseEntity.ok("Rating submitted successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingRepository.findAll());
    }

    @GetMapping("/average")
    public ResponseEntity<Double> getAverageRating() {
        double average = ratingRepository.getAverageRating();
        return ResponseEntity.ok(average);
    }
}
