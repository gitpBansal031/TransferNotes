package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;
    
    @GetMapping("api/check")
    @ResponseBody
    public String checking() {
        return "Hello world";
    }

    @PostMapping("note/{id}")
    @ResponseBody
    public ResponseEntity<String> updateNote(@PathVariable String id, @RequestBody Map<String, String> payload) {
        String noteContent = payload.getOrDefault("note", "");
        NoteEntity note = noteRepository.findById(id).orElse(new NoteEntity(id, ""));
        note.setNote(noteContent);
        noteRepository.save(note);
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("note/{id}")
    public String getNote(@PathVariable String id, Model model) {
        NoteEntity note = noteRepository.findById(id).orElse(new NoteEntity(id, ""));
        model.addAttribute("note", note);
        return "note";
    }
}
