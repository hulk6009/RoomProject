package com.example.room.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.room.db.entities.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class NotesRepository(context: Context) {
    private val db = NoteDatabase.invoke(context)

    fun getAllNotes(): LiveData<List<NoteEntity>> = db.noteDao().selectAllNotes()

    fun insertNote(noteEntity: NoteEntity){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.noteDao().insertNotes(noteEntity)
            }
        }


        }
    }
