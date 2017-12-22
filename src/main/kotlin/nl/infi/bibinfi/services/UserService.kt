package nl.infi.bibinfi.services

import nl.infi.bibinfi.domain.User
import nl.infi.bibinfi.domain.repositories.UserRepository
import nl.infi.bibinfi.services.generics.Repository
import org.springframework.stereotype.Service

/**
 * Created by aziz on 12/22/2017.
 */
@Service
class UserService : Repository<User, UserRepository>() {
}
