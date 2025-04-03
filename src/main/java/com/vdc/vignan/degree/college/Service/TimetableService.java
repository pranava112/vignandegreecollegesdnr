package com.vdc.vignan.degree.college.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdc.vignan.degree.college.Entity.Timetable;
import com.vdc.vignan.degree.college.Repository.TimetableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    // Create a new timetable
    public Timetable createTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    // Get all timetables
    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }

    // Get timetable by ID
    public Optional<Timetable> getTimetableById(Long id) {
        return timetableRepository.findById(id);
    }

    // Update timetable
    public Timetable updateTimetable(Long id, Timetable timetable) {
        timetable.setId(id);
        return timetableRepository.save(timetable);
    }

    // Delete timetable
    public void deleteTimetable(Long id) {
        timetableRepository.deleteById(id);
    }
}
