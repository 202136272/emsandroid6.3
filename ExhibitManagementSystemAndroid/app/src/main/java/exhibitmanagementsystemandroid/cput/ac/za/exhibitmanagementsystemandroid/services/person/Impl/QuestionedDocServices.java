package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.content.Context;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.QuestionedDoc;

/**
 * Created by Bonga on 5/12/2016.
 */
public interface QuestionedDocServices {
    void createQuestionDoc(Context context, QuestionedDoc questionedDoc);
    void updateQuestionDoc(Context context, QuestionedDoc questionedDoc);
}
