package nl.infi.bibinfi.services.generics

import nl.infi.bibinfi.domain.Book
import java.net.URL

/**
 * Created by aziz on 12/22/2017.
 */
interface APIService {
    fun getExternalBook(isbn: String): Book?
    fun getApiRequest(isbn: String): URL?
}