package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "notes")
@Data
@AllArgsConstructor
public class NoteEntity {
    private String id;
    private String note;
}
