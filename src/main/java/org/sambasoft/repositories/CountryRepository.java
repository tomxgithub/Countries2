package org.sambasoft.repositories;

import org.sambasoft.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * taken two parameters: Country class and type of integer
 * 
 * @author xaymo
 *
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
