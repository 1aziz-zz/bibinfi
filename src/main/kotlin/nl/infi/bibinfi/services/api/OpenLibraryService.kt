package nl.infi.bibinfi.services.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import nl.infi.bibinfi.domain.Book
import nl.infi.bibinfi.services.generics.APIService
import org.springframework.stereotype.Service
import java.net.URL

/**
 * Created by aziz on 12/22/2017.
 */
@Service
class OpenLibraryService : APIService {
    private val mapper = ObjectMapper().registerModule(KotlinModule())!!
        get() = field

    override fun getExternalBook(isbn: String): Book {
        val newBook: Book = Book()
        val mainJson = mapper.readTree(this.getApiRequest(isbn))
        val root = mainJson.path("ISBN:$isbn")

        newBook.title = root.path("title").asText()
        newBook.year = root.path("publish_date").asInt()
        val authors = root.path("authors").iterator()

        while (authors.hasNext()) {
            val authorName = authors.next().path("name").asText()
            newBook.authors.add(authorName)
        }
        newBook.authors.removeAt(0)
        newBook.thumbnail = root.path("cover").path("medium").asText()

        return newBook
    }

    override fun getApiRequest(isbn: String): URL {
        return URL("https://openlibrary.org/api/books?bibkeys=ISBN:$isbn,LCCN:93005405&jscmd=data&format=Json")
    }
}