package com.guru.gurukotlin.domain

import jakarta.persistence.*

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    var firstName: String,
    var lastName: String,

    @ManyToMany(mappedBy = "authors")
    var books: Set<Book>
)