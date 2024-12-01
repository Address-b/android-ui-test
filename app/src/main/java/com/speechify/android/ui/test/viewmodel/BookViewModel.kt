package com.speechify.android.ui.test.viewmodel

import androidx.lifecycle.ViewModel
import com.speechify.android.ui.test.data.Book
import com.speechify.android.ui.test.repository.BookRepository

class BookViewModel constructor(
    private val repository: BookRepository
)
    : ViewModel() {

        suspend fun getAllBooks(): List<Book> {
            return repository.getBooks()
        }

    suspend fun getBookImage(bookId: Int){
        repository.getBookImageBitmap(bookId)
    }

}