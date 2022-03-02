package com.example.notesapplicationrealm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapplicationrealm.adapters.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_notes;
    FloatingActionButton fab_add, fab_delete;
    CustomDialogClass.SaveListener listener;
    ArrayList<Note> notes;
    NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();
        initViews();
    }

    void loadData() {
        ArrayList<Note> noteList = RealmManager.getInstance().getObjectList();

        if (noteList != null) {
            notes = noteList;
        } else {
            notes = new ArrayList<>();
        }
    }

    private void initViews() {
        fab_add = findViewById(R.id.fab_add);
        fab_delete = findViewById(R.id.fab_delete);

        fab_add.setOnClickListener(it -> {
            add();
        });

        fab_delete.setOnClickListener(it -> {
            deleteAllInfo();
        });

        listener = new CustomDialogClass.SaveListener() {
            @Override
            public void save(String currentDate, String newNote) {
                Note note = new Note(notes.size(), currentDate, newNote);
                notes.add(0, note);
                adapter.notifyItemInserted(0);
                RealmManager.getInstance().saveObjectList(note);

            }
        };

        rv_notes = findViewById(R.id.rv_notes);
        refreshAdapter();
    }


    void refreshAdapter() {
        adapter = new NoteAdapter(this, notes);
        rv_notes.setAdapter(adapter);
    }

    private void deleteAllInfo() {
        RealmManager.getInstance().deleteObjects();
        notes.clear();
        adapter.notifyItemChanged(0, notes.size() - 1);
    }

    void add() {
        CustomDialogClass cdd = new CustomDialogClass(this, listener);
        cdd.show();
    }
}