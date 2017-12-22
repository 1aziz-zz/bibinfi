package nl.infi.bibinfi.domain.repositories
import nl.infi.bibinfi.domain.Book
import org.springframework.data.repository.CrudRepository

/**
 * Created by aziz on 12/15/2017.
 */

interface BookRepository : CrudRepository<Book, Int> {
    fun findById(id: String): Book
}