package com.guru.gurukotlin.services

import com.guru.gurukotlin.domain.Book
import com.guru.gurukotlin.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(val bookRepository: BookRepository) : BookService {
    override fun findAll(): Iterable<Book> {
        return bookRepository.findAll()
    }
}