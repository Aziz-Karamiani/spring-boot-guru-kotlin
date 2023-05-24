package com.guru.gurukotlin.bootstrap

import com.guru.gurukotlin.domain.Author
import com.guru.gurukotlin.domain.Book
import com.guru.gurukotlin.domain.Publisher
import com.guru.gurukotlin.repositories.AuthorRepository
import com.guru.gurukotlin.repositories.BookRepository
import com.guru.gurukotlin.repositories.PublisherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootstrapData(
    val bookRepository: BookRepository,
    val authorRepository: AuthorRepository,
    val publisherRepository: PublisherRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val eric = Author(id = null, firstName = "Eric", lastName = "Evans")

        val ddd = Book(id = null, title = "Domain Driven Design", isbn = "123456")

        val ericSaved = authorRepository.save(eric)
        val dddSaved = bookRepository.save(ddd)

        val rod = Author(id = null, firstName = "Rod", lastName = "Johnson")

        val noEJB = Book(id = null, title = "J2EE Development without EJB", "54757585")

        val rodSaved = authorRepository.save(rod)
        val noEJBSaved = bookRepository.save(noEJB)

        ericSaved.books.add(dddSaved)
        rodSaved.books.add(noEJBSaved)
        dddSaved.authors.add(ericSaved)
        noEJBSaved.authors.add(rodSaved)


        val publisher = Publisher(id = null, publisherName = "My Publisher", address = "123 Main", city = null, state = null, zipCod = null)
        val savedPublisher = publisherRepository.save(publisher)

        dddSaved.publisher = savedPublisher
        noEJBSaved.publisher = savedPublisher

        authorRepository.save(ericSaved)
        authorRepository.save(rodSaved)
        bookRepository.save(dddSaved)
        bookRepository.save(noEJBSaved)

        println("In Bootstrap")
        println("Author Count: " + authorRepository.count())
        println("Book Count: " + bookRepository.count())

    }
}