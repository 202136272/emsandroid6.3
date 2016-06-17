package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Station;

/**
 * Created by Bonga on 6/17/2016.
 */
public interface StationService {

    Station findById(Long id);

    Station save(Station entity);

    Set<Station> findAll();


    void deleteAll();

    Station update(Station entity);
}
