package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bonga on 4/16/2016.
 */
public class BiologyTest {
    private Biology biology;
    @Before
    public void setUp() throws Exception {

        biology = BiologyFactory.getBiology("Khayelitsha", "21/03/16", "tablets");
    }

    @Test
    public void testExhibit() throws Exception {
        Assert.assertEquals(biology.getReference(), "21/03/16");
        Assert.assertEquals(biology.getName(), "Khayelitsha");
        Assert.assertEquals(biology.getType(), "tablets");

    }
}
