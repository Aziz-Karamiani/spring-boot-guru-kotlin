package com.guru.gurukotlin.repositories

import com.guru.gurukotlin.domain.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {
}