package org.sakila.Imp;

import org.modelmapper.ModelMapper;
import org.sakila.Enitites.Actor;
import org.sakila.Enitites.FilmActor;
import org.sakila.Enitites.FilmActorId;
import org.sakila.Interface.ActorBusiness;
import org.sakila.Repository.ActorRepository;
import org.sakila.Repository.FilmActorRepository;
import org.sakila.exceptions.ActorNotFoundException;
import org.sakila.exceptions.OperationNotAllowedException;
import org.sakila.vali.ActorDTO;
import org.sakila.vali.FilmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created on 21/04/2018.
 *
 * @author Cesardl
 */
@Service
public class ActorBusinessImpl implements ActorBusiness {

    private final ActorRepository actorRepository;
    private final FilmActorRepository filmActorRepository;

    private final ModelMapper modelMapper;

    @Autowired
    private ActorBusinessImpl(ActorRepository actorRepository,
                              FilmActorRepository filmActorRepository,
                              ModelMapper modelMapper) {
        this.actorRepository = actorRepository;
        this.filmActorRepository = filmActorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<ActorDTO> list(final Pageable pageable) {
        Page<Actor> actors = actorRepository.findAll(pageable);

        return new PageImpl<>(
                actors.stream()
                        .map(actor -> modelMapper.map(actor, ActorDTO.class))
                        .collect(Collectors.toList()),
                actors.getPageable(), actors.getTotalElements());
    }

    @Override
    public ActorDTO create(final ActorDTO payload) {
        if (payload.getActorId() != null) {
            throw new OperationNotAllowedException();
        }

        return modelMapper.map(
                actorRepository.save(
                        modelMapper.map(payload, Actor.class)), ActorDTO.class);
    }

    @Override
    public ActorDTO modify(final Short actorId, final ActorDTO payload) {
        Actor actor = modelMapper.map(payload, Actor.class);
        actor.setActorId(actorId);

        actorRepository.save(actor);

        return modelMapper.map(actor, ActorDTO.class);
    }

    @Override
    public ActorDTO get(final Short actorId) {
        return actorRepository.findById(actorId)
                .map(actor -> modelMapper.map(actor, ActorDTO.class))
                .orElseThrow(() -> new ActorNotFoundException(actorId));
    }

    @Override
    public void delete(final Short actorId) {
        actorRepository.deleteById(actorId);
    }

    @Override
    public void createFilmParticipation(final Short actorId, final Short filmId) {
        FilmActor filmActor = new FilmActor();
        filmActor.setId(new FilmActorId(actorId, filmId));
        filmActorRepository.save(filmActor);
    }

    @Override
    public FilmDTO getFilm(final Short actorId, final Short filmId) {
        return filmActorRepository.findById(new FilmActorId(actorId, filmId))
                .map(filmActor -> modelMapper.map(filmActor.getFilm(), FilmDTO.class))
                .orElseThrow(() -> new OperationNotAllowedException("The actor doesn't participate in film"));
    }

    @Override
    public void deleteFilm(final Short actorId, final Short filmId) {
        filmActorRepository.deleteById(new FilmActorId(actorId, filmId));
    }
}
