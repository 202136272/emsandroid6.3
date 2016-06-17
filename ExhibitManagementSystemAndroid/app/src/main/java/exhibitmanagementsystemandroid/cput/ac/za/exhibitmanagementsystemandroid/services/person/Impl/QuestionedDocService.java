package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.content.Context;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.QuestionedDoc;

/**
 * Created by Bonga on 5/12/2016.
 */
public interface QuestionedDocService {

    QuestionedDoc findById(Long id);

    QuestionedDoc save(QuestionedDoc entity);

    Set<QuestionedDoc> findAll();


    void deleteAll();

    QuestionedDoc update(QuestionedDoc entity);

}