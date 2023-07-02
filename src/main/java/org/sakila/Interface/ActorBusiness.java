package org.sakila.Interface;

import org.sakila.vali.ActorDTO;
import org.sakila.vali.FilmDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created on 21/04/2018.
 *
 * @author Cesardl
 */
public interface ActorBusiness {

    Page<ActorDTO> list(Pageable pageable);

    ActorDTO create(ActorDTO payload);

    ActorDTO modify(Short actorId, ActorDTO payload);

    ActorDTO get(Short actorId);

    void delete(Short actorId);

    void createFilmParticipation(Short actorId, Short payload);

    FilmDTO getFilm(Short actorId, Short filmId);

    void deleteFilm(Short actorId, Short filmId);
}
