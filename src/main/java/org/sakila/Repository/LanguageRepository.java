package org.sakila.Repository;

import org.sakila.Enitites.Language;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on 28/04/2018.
 *
 * @author Cesardl
 */
public interface LanguageRepository extends CrudRepository<Language, Byte> {
}
