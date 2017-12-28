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
/*
    @Bean
    fun init() = CommandLineRunner {
       ???
    }
*/

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}