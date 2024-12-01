package com.speechify.android.ui.test.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.speechify.android.ui.test.R
import com.speechify.android.ui.test.adapter.BookAdapter
import com.speechify.android.ui.test.data.Book
import com.speechify.android.ui.test.databinding.FragmentBookListBinding
import com.speechify.android.ui.test.repository.BookRepository
import com.speechify.android.ui.test.viewmodel.BookViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class BookListFragment : Fragment() {

    private var _binding: FragmentBookListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<BookViewModel>()
    private lateinit var  adapter : BookAdapter

    private lateinit var booksLists:List<Book>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookListBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.viewModelScope.launch {
            booksLists = viewModel.getAllBooks()
        }
        adapter = BookAdapter(view.context, booksLists)


        binding.apply {
            rvBookList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            rvBookList.adapter = adapter
        }
    }
}