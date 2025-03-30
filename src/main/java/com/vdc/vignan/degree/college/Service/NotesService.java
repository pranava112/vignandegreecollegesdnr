package com.vdc.vignan.degree.college.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vdc.vignan.degree.college.Entity.Notes;
import com.vdc.vignan.degree.college.Repository.NotesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    // Create Note
    public Notes createNote(Notes note) {
        return notesRepository.save(note);
    }

    // Get All Notes
    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    // Get Note By ID (Fixed)
    public Optional<Notes> getNoteById(String id) {
        return notesRepository.findById(id);
    }

    // Update Note (Fixed)
    public Notes updateNote(String id, Notes updatedNote) {
        return notesRepository.findById(id)
            .map(existingNote -> {
                existingNote.setTitle(updatedNote.getTitle());
                existingNote.setDescription(updatedNote.getDescription());
                existingNote.setCategory(updatedNote.getCategory());
                return notesRepository.save(existingNote);
            }).orElse(null);
    }

    // Delete Note
    public void deleteNoteById(String id) {
        notesRepository.deleteById(id);
    }
}
