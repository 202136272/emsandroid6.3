package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;

/**
 * Created by Bonga on 6/17/2016.
 */
public interface BallisticService {

    Ballistic findById(Long id);

    Ballistic save(Ballistic entity);

    Set<Ballistic> findAll();


    void deleteAll();

    Ballistic update(Ballistic entity);
}
