package com.vdc.vignan.degree.college.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vdc.vignan.degree.college.Entity.Timetable;
import com.vdc.vignan.degree.college.Service.TimetableService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vignan/timetable")
public class TimetableController {

    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private TimetableService timetableService;

    // Create a new timetable
    @PostMapping
    public ResponseEntity<Timetable> createTimetable(@RequestBody Timetable timetable) {
        try {
            logger.info("Creating timetable: {}", timetable);
            Timetable createdTimetable = timetableService.createTimetable(timetable);
            return new ResponseEntity<>(createdTimetable, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating timetable: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all timetables
    @GetMapping
    public ResponseEntity<List<Timetable>> getAllTimetables() {
        try {
            List<Timetable> timetables = timetableService.getAllTimetables();
            return new ResponseEntity<>(timetables, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching timetables: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get timetable by ID
    @GetMapping("/{id}")
    public ResponseEntity<Timetable> getTimetableById(@PathVariable Long id) {
        try {
            Optional<Timetable> timetable = timetableService.getTimetableById(id);
            return timetable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            logger.error("Error fetching timetable with id " + id + ": ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update timetable by ID
    @PutMapping("/{id}")
    public ResponseEntity<Timetable> updateTimetable(@PathVariable Long id, @RequestBody Timetable timetable) {
        try {
            Timetable updatedTimetable = timetableService.updateTimetable(id, timetable);
            return new ResponseEntity<>(updatedTimetable, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error updating timetable with id " + id + ": ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete timetable by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimetable(@PathVariable Long id) {
        try {
            timetableService.deleteTimetable(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error deleting timetable with id " + id + ": ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
