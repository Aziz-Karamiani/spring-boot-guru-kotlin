package com.guru.gurukotlin.services

import com.guru.gurukotlin.domain.Book

interface BookService {
    fun findAll(): Iterable<Book>
}