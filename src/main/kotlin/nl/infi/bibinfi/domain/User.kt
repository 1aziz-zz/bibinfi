package nl.infi.bibinfi.domain

import javax.persistence.*

/**
 * Created by aziz on 12/15/2017.
 */

@Entity
class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,
        var name: String,
        var url: String,
        @OneToOne
        var book: Book
) {
    constructor() : this(0, name = "", url = "", book = Book()) {
    }
}
