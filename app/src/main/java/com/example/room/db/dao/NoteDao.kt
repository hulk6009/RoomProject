package com.example.room.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.db.entities.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun selectAllNotes(): LiveData<List<NoteEntity>>

    @Insert
    fun insertNotes(noteEntity: NoteEntity)

    @Delete
    fun deleteNotes(noteEntity: NoteEntity)

    @Update
    fun updateNotes(noteEntity: NoteEntity)

}