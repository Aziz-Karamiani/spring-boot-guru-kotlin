package com.guru.gurukotlin.domain

import jakarta.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,
    var title: String,
    var isbn: String
)