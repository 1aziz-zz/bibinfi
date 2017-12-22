package nl.infi.bibinfi.domain.repositories
import nl.infi.bibinfi.domain.User
import org.springframework.data.repository.CrudRepository

/**
 * Created by aziz on 12/15/2017.
 */

interface UserRepository : CrudRepository<User, Int> {
    fun findById(id: String): User
}