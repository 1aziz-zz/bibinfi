package nl.infi.bibinfi.controllers

import com.mysql.jdbc.IterateBlock
import nl.infi.bibinfi.domain.Book
import nl.infi.bibinfi.services.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created by aziz on 12/15/2017.
 *
 */

@RestController
@RequestMapping("/books")

class BookController(var bookService: BookService) {
    @GetMapping
    fun findAll(): ResponseEntity<Iterable<Book>> {
        return ResponseEntity<Iterable<Book>>(bookService.getAll(), HttpStatus.OK)
    }

    @GetMapping(value = "/id/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<Book> {
        val book = bookService.get(id)
        if (book !== null) {
            return ResponseEntity<Book>(book ,HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    // Browse an existing book by isbn
    @GetMapping("/isbn/{isbn}")
    @ResponseBody
    fun findByISBN(@PathVariable isbn: String): ResponseEntity<Book> {
        val book = bookService.findBookByIsbn(isbn)
        if (book !== null) {
            return ResponseEntity<Book>(book, HttpStatus.OK)

        }
        return ResponseEntity(HttpStatus.NOT_FOUND);
    }

    // Add one of multiple books
    @PostMapping("/add")
    fun addMultipleBooks(@RequestBody isbnList: List<String>): ResponseEntity<HttpStatus> {

        for (isbn in isbnList) {
            val book = bookService.findBookByIsbn(isbn)
            if (book === null) {
                bookService.add(bookService.retrieveBookInfo(isbn)!!)
                return ResponseEntity(HttpStatus.OK)
            }
        }
        return ResponseEntity(HttpStatus.NOT_ACCEPTABLE)
    }

    // Remove a book
    @GetMapping(value = "/delete/{id}")
    fun deleteById(@PathVariable id: Int): ResponseEntity<HttpStatus> {
        bookService.remove(id)
        return ResponseEntity(HttpStatus.OK)
    }


}