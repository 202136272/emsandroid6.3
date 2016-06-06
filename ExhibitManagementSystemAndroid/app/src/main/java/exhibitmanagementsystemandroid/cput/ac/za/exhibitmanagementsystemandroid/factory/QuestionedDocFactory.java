package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.QuestionedDoc;



/**
 * Created by Bonga on 4/3/2016.
 */
public class QuestionedDocFactory {

    public static QuestionedDoc getQuestionedDoc(String name, String reference, String date)
    {
        QuestionedDoc myQuestionedDoc = new QuestionedDoc.Builder()
                .name(name)
                .reference(reference)
                .date(date)
                .build();
        return myQuestionedDoc;

    }
}
