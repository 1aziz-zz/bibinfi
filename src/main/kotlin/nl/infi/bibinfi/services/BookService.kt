package nl.infi.bibinfi.services

import nl.infi.bibinfi.domain.Book
import nl.infi.bibinfi.domain.repositories.BookRepository
import nl.infi.bibinfi.services.api.OpenLibraryService
import nl.infi.bibinfi.services.generics.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by aziz on 12/22/2017.
 */
@Service
class BookService : Repository<Book, BookRepository>() {
    @Autowired
    private lateinit var openLibraryService: OpenLibraryService
    fun retrieveBookInfo(isbn : String) : Book {
        return openLibraryService.getExternalBook(isbn)
    }
}