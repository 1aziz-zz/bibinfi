package nl.infi.bibinfi.services.generics

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import javax.transaction.Transactional

/**
 * Created by aziz on 12/22/2017.
 */
@Component
abstract class Repository<T, E : CrudRepository<T, Int>> {
    @Autowired
    lateinit var repo : E
    @Transactional
    fun add(entity: T): T {
        repo.save(entity)
        return entity
    }

    fun remove(id: Int) {
        repo.delete(repo.findById(id).get())
    }

    fun get(id: Int): T {
        return repo.findById(id).get()
    }

    fun getAll(): Iterable<T> {
        return repo.findAll()
    }

    fun removeAll() {
        repo.deleteAll()
    }
}