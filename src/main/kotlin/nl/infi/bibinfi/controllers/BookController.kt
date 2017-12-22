package nl.infi.bibinfi.controllers

import nl.infi.bibinfi.services.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by aziz on 12/15/2017.
 */
@RestController
@RequestMapping("/books")

class BookController (val bookService: BookService) {
    @GetMapping
    fun findAll() = bookService.getAll()

    @GetMapping("{id}")
    fun findById(@PathVariable id:Int) =
            bookService.get(id)

    @GetMapping("/find/{isbn}")
    fun findByISBN(@PathVariable isbn:String) =
            bookService.retrieveBookInfo(isbn)

}