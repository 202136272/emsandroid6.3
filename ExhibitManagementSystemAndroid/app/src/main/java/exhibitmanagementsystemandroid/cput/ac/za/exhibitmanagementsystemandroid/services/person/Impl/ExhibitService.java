package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.content.Context;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;

/**
 * Created by Bonga on 5/12/2016.
 */

public interface ExhibitService {
    Exhibit findById(Long id);

    Exhibit save(Exhibit entity);

    Set<Exhibit> findAll();


    void deleteAll();

    Exhibit update(Exhibit entity);
}
