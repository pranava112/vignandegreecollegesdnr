package com.vdc.vignan.degree.college.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vdc.vignan.degree.college.Entity.Announcement;
import com.vdc.vignan.degree.college.Service.AnnouncementService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // ✅ Allow frontend requests
@RequestMapping("/api/vignan/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    // ✅ Create Announcement
    @PostMapping
    public ResponseEntity<Announcement> createAnnouncement(@RequestBody Announcement announcement) {
        Announcement savedAnnouncement = announcementService.createAnnouncement(announcement);
        return ResponseEntity.ok(savedAnnouncement);
    }

    // ✅ Get All Announcements
    @GetMapping
    public ResponseEntity<List<Announcement>> getAllAnnouncements() {
        return ResponseEntity.ok(announcementService.getAllAnnouncements());
    }

    // ✅ Get Announcement By ID (Fixed)
    @GetMapping("/{id}")
    public ResponseEntity<Announcement> getAnnouncementById(@PathVariable int id) {
        Optional<Announcement> announcement = announcementService.getAnnouncementById(id);
        return announcement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Update Announcement (Fixed)
    @PutMapping("/{id}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable int id, @RequestBody Announcement updatedAnnouncement) {
        Announcement updated = announcementService.updateAnnouncement(id, updatedAnnouncement);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // ✅ Delete Announcement
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable int id) {
        boolean deleted = announcementService.deleteAnnouncement(id);
        return deleted ? ResponseEntity.ok("Announcement deleted successfully") : ResponseEntity.notFound().build();
    }
}
