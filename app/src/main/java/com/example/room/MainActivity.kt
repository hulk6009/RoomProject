package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.adapter.NoteAdapter
import com.example.room.db.NotesRepository
import com.example.room.db.entities.NoteEntity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNoteButton : FloatingActionButton
    private lateinit var notesRepository: NotesRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        noteAdapter = NoteAdapter()
        linearLayoutManager = LinearLayoutManager(this)

        recyclerView = findViewById(R.id.recyclerView)
        addNoteButton= findViewById(R.id.floatingActionButton)

        recyclerView.adapter = noteAdapter

        recyclerView.layoutManager = linearLayoutManager

        notesRepository= NotesRepository(this)

        notesRepository.getAllNotes().observe(this, { notes ->
             noteAdapter.submitList(notes)
        })

        insertDataIntoDb()
    }
    private fun insertDataIntoDb(){
        val noteEntity = NoteEntity(title = "Hey", description = "Hi, how are you?")
        notesRepository.insertNote(noteEntity)
    }
}