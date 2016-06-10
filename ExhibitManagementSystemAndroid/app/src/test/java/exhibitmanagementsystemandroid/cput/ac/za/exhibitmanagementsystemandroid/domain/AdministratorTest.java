package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.AdministratorFactory;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.BallisticFactory;

/**
 * Created by Bonga on 6/10/2016.
 */
public class AdministratorTest {


    private Administrator administrator;

    @Before
    public void setUp() throws Exception {

        administrator = AdministratorFactory.getAdministrator("Bonga", "Mabulu", "123");
    }

    @Test
    public void testExhibit() throws Exception {
        Assert.assertEquals(administrator.getName(), "Bonga");
        Assert.assertEquals(administrator.getSurname(), "Mabulu");
        Assert.assertEquals(administrator.getPersalNumber(), "123");

    }

}
