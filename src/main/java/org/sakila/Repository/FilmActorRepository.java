package org.sakila.Repository;

import org.sakila.Enitites.FilmActor;
import org.sakila.Enitites.FilmActorId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 28/04/2018.
 *
 * @author Cesardl
 */
@Transactional
public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorId> {
}
