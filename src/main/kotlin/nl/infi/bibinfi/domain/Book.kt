package nl.infi.bibinfi.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

/**
 * Created by aziz on 12/15/2017.
 */
@Entity
class Book(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,
        var title: String,
        var isbn: String,
        @ElementCollection
        var authors: MutableList<String>,
        var year: Int,
        var thumbnail: String
) {
    constructor() : this(0, title = "", authors = arrayListOf(""), isbn = "", year = 0, thumbnail = "") {
    }
}
