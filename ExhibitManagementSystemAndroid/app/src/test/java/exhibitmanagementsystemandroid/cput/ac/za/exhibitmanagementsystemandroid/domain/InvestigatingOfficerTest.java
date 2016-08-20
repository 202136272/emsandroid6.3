package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Leonard Dukashe on 2016/03/28.
 */
public class InvestigatingOfficerTest {

    InvestigatingOfficer investigatingOfficer;

    @Before
    public void setUp() throws Exception {

        investigatingOfficer = InvestigatingOfficerFactory.getInvestigatingOfficer("Sizwe", "Constable", "Khayelitsha", "05436800");
    }

    @Test
    public void testInvestigatingOfficer() throws Exception {
        Assert.assertEquals(investigatingOfficer.getName(),"Sizwe");
        Assert.assertEquals(investigatingOfficer.getRank(),"Constable");
        Assert.assertEquals(investigatingOfficer.getStation(),"Khayelitsha");
        Assert.assertEquals(investigatingOfficer.getPersalNumber(),"05436800");

    }
}
