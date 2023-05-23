package com.guru.gurukotlin.domain

import jakarta.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    var title: String,
    var isbn: String,

    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")]
    )
    var author: Set<Author>
)