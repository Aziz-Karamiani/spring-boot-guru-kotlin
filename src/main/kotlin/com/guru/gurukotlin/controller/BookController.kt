package com.guru.gurukotlin.controller

import com.guru.gurukotlin.services.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BookController(val bookService: BookService) {
    @RequestMapping("/books")
    fun getBooks(model: Model): String {
        model.addAttribute("books", bookService.findAll())
        return "books"
    }
}