package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.PreciousMetalsFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.BallisticFactory;

/**
 * Created by Bonga on 4/16/2016.
 */
public class PreciousMetalsTest {
    private PreciousMetals preciousMetals;

    @Before
    public void setUp() throws Exception {

        preciousMetals = PreciousMetalsFactory.getPreciousMetals("20", "Gold", "50", "90");
    }

    @Test
    public void testExhibit() throws Exception {
        Assert.assertEquals(preciousMetals.getMass(),"20");
        Assert.assertEquals(preciousMetals.getType(), "Gold");
        Assert.assertEquals(preciousMetals.getDensity(), "50");
        Assert.assertEquals(preciousMetals.getMeltingPoint(), "90");

    }
}
