package com.example.notesapplicationrealm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Note extends RealmObject {

    @PrimaryKey
    int id = 0;
    private String date;
    private String note;

    public Note() {
    }

    public Note(int id, String date, String note) {
        this.id = id;
        this.date = date;
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }
}
