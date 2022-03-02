package com.example.notesapplicationrealm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmManager {

    private static RealmManager realmManager = null;
    private final Realm realm;

    public static RealmManager getInstance() {
        if (realmManager == null) {
            realmManager = new RealmManager();
        }
        return realmManager;
    }

    private RealmManager() {
        realm = Realm.getDefaultInstance();
    }

    void saveObjectList(Note note) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(note);
        realm.commitTransaction();
    }

    public ArrayList<Note> getObjectList() {

        RealmResults<Note> results = realm.where(Note.class).findAll();

        ArrayList<Note> notes = new ArrayList<>();
        for (int i = results.size() - 1; i >= 0; i--) {
            notes.add(results.get(i));
        }
        return notes;
    }

    public void deleteObjects() {
        realm.beginTransaction();
        realm.delete(Note.class);
        realm.commitTransaction();
    }


}
