package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.ExhibitFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Leonard Dukashe on 2016/03/28.
 */
public class ExhibitTest {
    private Exhibit exhibit;
    @Before
    public void setUp() throws Exception {

        exhibit = ExhibitFactory.getExhibit("21/03/16","Khayelitsha", "tablets", "ballistic");
    }

    @Test
    public void testExhibit() throws Exception {
        Assert.assertEquals(exhibit.getCasNumber(),"21/03/16");
        Assert.assertEquals(exhibit.getStation(), "Khayelitsha");
        Assert.assertEquals(exhibit.getDescription(), "tablets");
        Assert.assertEquals(exhibit.getSceneType(), "ballistic");
    }
}
