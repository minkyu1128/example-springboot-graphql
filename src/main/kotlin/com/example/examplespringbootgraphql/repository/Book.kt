package com.example.examplespringbootgraphql.repository

import jakarta.persistence.*
import org.hibernate.annotations.Comment
import java.util.*

@Entity
@Table(name = "book")
data class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "public_id")
    @Comment("고유식별ID")
    val publicId: String = UUID.randomUUID().toString(),

    @Column(name = "title")
    @Comment("제목")
    var title: String,

    @Column(name = "author")
    @Comment("저자")
    var author: String
)
