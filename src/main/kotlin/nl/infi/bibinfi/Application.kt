package nl.infi.bibinfi

import nl.infi.bibinfi.domain.Book
import nl.infi.bibinfi.domain.User
import nl.infi.bibinfi.domain.repositories.BookRepository
import nl.infi.bibinfi.domain.repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

/**
 * Created by aziz on 12/22/2017.
 */
@SpringBootApplication(exclude = arrayOf(SecurityAutoConfiguration::class))
@ComponentScan("nl.infi.bibinfi")
class Application {

    @Bean
    fun init(bookRepo: BookRepository, userRepo: UserRepository) = CommandLineRunner {
        bookRepo.save(Book(1, "Best book ever!", "123456789", arrayListOf("Aziz", "Peter"), 1957, ""))
        val myBook = Book()
        myBook.title = "WOW"
        bookRepo.save(myBook)
        bookRepo.save(Book(1, "Best book ever!", "123456789", arrayListOf("Aziz", "Peter"), 1957, ""))

        val personA = User()
        personA.book = myBook
        personA.name = "Aziz"
        userRepo.save(personA)

        val personB = User(id = 1, name = "Peter", book = bookRepo.findById(1).get(), url = "azizo.me")

        userRepo.save(personB)

    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}