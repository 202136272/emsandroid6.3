package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bonga on 4/16/2016.
 */
public class BallisticTest {


    private Ballistic ballistic;

    @Before
    public void setUp() throws Exception {

        ballistic = BallisticFactory.getBallistic("Khayelitsha", "21/03/16","tablets");
    }

    @Test
    public void testExhibit() throws Exception {
        Assert.assertEquals(ballistic.getReference(), "21/03/16");
        Assert.assertEquals(ballistic.getName(), "Khayelitsha");
        Assert.assertEquals(ballistic.getType(), "tablets");

    }


}


