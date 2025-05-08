package com.example.examplespringbootgraphql.service

import com.example.examplespringbootgraphql.repository.Book
import com.example.examplespringbootgraphql.repository.BookRepository
import org.springframework.stereotype.Service

/**
 * Book CRUD 서비스
 */
@Service
class BookService(private val bookRepository: BookRepository) {


    /**
     * book 다건 조회
     */
    fun getAllBooks(size: Int?): List<Book> {
        return bookRepository.findAll().take(size ?: Int.MAX_VALUE)
    }

    /**
     * book 조회
     */
    fun getBook(publicId: String): Book? {
        return bookRepository.findByPublicId(publicId)
    }

    /**
     * book 저장
     */
    fun createBook(title: String, author: String): Book {
        val book = Book(title = title, author = author)
        return bookRepository.save(book)
    }

    /**
     * book 정보 수정
     */
    fun updateBook(publicId: String, title: String, author: String): Book? {
        val book = bookRepository.findByPublicId(publicId) ?: return null
        book.title = title
        book.author = author
        return bookRepository.save(book)
    }

    /**
     * book 삭제
     */
    fun deleteBook(publicId: String): String? {
        val book = bookRepository.findByPublicId(publicId) ?: return null
        bookRepository.delete(book)
        return publicId
    }
}
