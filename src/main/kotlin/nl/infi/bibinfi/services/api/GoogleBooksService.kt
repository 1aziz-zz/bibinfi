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
class GoogleBooksService : APIService {

    private val mapper = ObjectMapper().registerModule(KotlinModule())!!
        get() = field

    override fun getExternalBook(isbn: String): Book {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun getApiRequest(isbn: String): URL {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}