package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bonga on 4/16/2016.
 */
public class ScientificTest {

    private Scientific scientific;
    @Before
    public void setUp() throws Exception {

        scientific= ScientificFactory.getScientific("popo","20");
    }

    @Test
    public void testExhibit() throws Exception {
        Assert.assertEquals(scientific.getName(), "popo");
        Assert.assertEquals(scientific.getMass(), "20");


    }
}
