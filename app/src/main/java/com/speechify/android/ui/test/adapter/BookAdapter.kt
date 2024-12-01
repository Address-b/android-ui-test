package com.speechify.android.ui.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.speechify.android.ui.test.data.Book
import com.speechify.android.ui.test.databinding.ItemBookBinding

class BookAdapter(
    val  context:Context,
    var booksLists :List<Book>
): RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

    inner class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(book: Book){
            binding.apply {
                textViewBookTitle.text = book.title
                textViewBookAuthor.text = book.author
                imageViewBookCover.setImageResource(book.image)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return booksLists.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = booksLists[position]
        holder.bind(book)

    }
}