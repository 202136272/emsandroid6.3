package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bonga on 4/16/2016.
 */
public class QuestionedDocTest {
    private QuestionedDoc questionedDoc;
    @Before
    public void setUp() throws Exception {

        questionedDoc = QuestionedDocFactory.getQuestionedDoc("haha","Khayelitsha", "2016/05/31");
    }

    @Test
    public void testExhibit() throws Exception {
        Assert.assertEquals(questionedDoc.getReference(), "Khayelitsha");
        Assert.assertEquals(questionedDoc.getName(), "haha");
        Assert.assertEquals(questionedDoc.getDate(), "2016/05/31");

    }
}
