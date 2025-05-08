package com.example.examplespringbootgraphql.controller

import com.example.examplespringbootgraphql.repository.Book
import com.example.examplespringbootgraphql.service.BookService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class BookController(private val bookService: BookService) {

    @QueryMapping
    fun getBooks(@Argument size: Int?): List<Book> {
        return bookService.getAllBooks(size)
    }

    @QueryMapping
    fun getBook(@Argument publicId: String): Book? {
        return bookService.getBook(publicId)
    }

    @MutationMapping
    fun createBook(@Argument title: String, @Argument author: String): Book {
        return bookService.createBook(title, author)
    }

    @MutationMapping
    fun updateBook(@Argument publicId: String, @Argument title: String, @Argument author: String): Book? {
        return bookService.updateBook(publicId, title, author)
    }

    @MutationMapping
    fun deleteBook(@Argument publicId: String): String? {
        return bookService.deleteBook(publicId)
    }
}
