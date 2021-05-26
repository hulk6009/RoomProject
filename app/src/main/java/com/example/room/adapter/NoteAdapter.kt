package com.example.room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.db.entities.NoteEntity

class NoteAdapter : ListAdapter<NoteEntity, NoteAdapter.NoteViewHolder>(NoteDiffUtil()) {
    inner class NoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(
            item : NoteEntity
        ){
            val noteTitle = itemView.findViewById<TextView>(R.id.note_title)
            val noteDescription  = itemView.findViewById<TextView>(R.id.note_description)

            noteTitle.text = item.title
            noteDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_note_rv,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class NoteDiffUtil : DiffUtil.ItemCallback<NoteEntity>(){
    override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
        return oldItem.id == newItem.id
    }

}