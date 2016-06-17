package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.content.Context;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.QuestionedDoc;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Scientific;

/**
 * Created by Bonga on 5/12/2016.
 */
public interface ScientificService {


    Scientific findById(Long id);

    Scientific save(Scientific entity);

    Set<Scientific> findAll();


    void deleteAll();

    Scientific update(Scientific entity);
}
