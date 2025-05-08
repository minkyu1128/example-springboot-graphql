package com.example.examplespringbootgraphql.repository

import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
    fun findByPublicId(publicId: String): Book?
}