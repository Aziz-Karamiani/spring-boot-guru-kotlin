package com.guru.gurukotlin.bootstrap

import com.guru.gurukotlin.domain.Author
import com.guru.gurukotlin.domain.Book
import com.guru.gurukotlin.repositories.AuthorRepository
import com.guru.gurukotlin.repositories.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootstrapData(val bookRepository: BookRepository, val authorRepository: AuthorRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val eric = Author(id = null, firstName = "Eric", lastName = "Evans")

        val ddd = Book(id = null, title = "Domain Driven Design", isbn = "123456")

        val ericSaved = authorRepository.save(eric)
        val dddSaved = bookRepository.save(ddd)

        val rod = Author(id = null, firstName = "Rod", lastName = "Johnson")

        val noEJB = Book(id = null, title = "J2EE Development without EJB", "54757585")

        val rodSaved = authorRepository.save(rod)
        val noEJBSaved = bookRepository.save(noEJB)

        ericSaved.books.plusElement(dddSaved)
        rodSaved.books.plusElement(noEJBSaved)

        authorRepository.save(ericSaved)
        authorRepository.save(rodSaved)

        println("In Bootstrap")
        println("Author Count: " + authorRepository.count())
        println("Book Count: " + bookRepository.count())
    }
}