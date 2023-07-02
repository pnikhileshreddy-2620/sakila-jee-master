package org.sakila.Repository;

import org.sakila.Enitites.Staff;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on 28/04/2018.
 *
 * @author Cesardl
 */
public interface StaffRepository extends CrudRepository<Staff, Byte> {
}
