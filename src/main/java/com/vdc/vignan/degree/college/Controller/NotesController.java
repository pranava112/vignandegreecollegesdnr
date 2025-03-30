package com.vdc.vignan.degree.college.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vdc.vignan.degree.college.Entity.Notes;
import com.vdc.vignan.degree.college.Service.NotesService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Allow React frontend
@RequestMapping("/api/vignan/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    // Create Note
    @PostMapping
    public ResponseEntity<Notes> createNote(@RequestBody Notes note) {
        Notes savedNote = notesService.createNote(note);
        return ResponseEntity.ok(savedNote);
    }

    // Get All Notes
    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    // Get Note By ID (Fixed)
    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable String id) {
        Optional<Notes> note = notesService.getNoteById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Note (Fixed)
    @PutMapping("/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable String id, @RequestBody Notes note) {
        Notes updatedNote = notesService.updateNote(id, note);
        return updatedNote != null ? ResponseEntity.ok(updatedNote) : ResponseEntity.notFound().build();
    }

    // Delete Note
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotes(@PathVariable String id) {
        notesService.deleteNoteById(id);
        return ResponseEntity.ok("Notes deleted successfully");
    }
}
