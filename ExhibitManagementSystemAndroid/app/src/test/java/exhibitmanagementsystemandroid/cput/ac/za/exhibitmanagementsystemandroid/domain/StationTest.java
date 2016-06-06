package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.PersonFactory;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.StationFactory;

/**
 * Created by Bonga on 4/16/2016.
 */
public class StationTest {

    private Station station;


    @Before
    public void setUp() throws Exception {

        station = StationFactory.getStation("Bonga","05436800");
    }

    @Test
    public void testPerson() throws Exception {
        Assert.assertEquals(station.getName(),"Bonga");
        Assert.assertEquals(station.getAddress(), "05436800");

    }

    @Test
    public void testNewUpdate() throws Exception {
        Station stationUpdate = new Station.Builder()
                .copy(station)
                .address("05436800")
                .build();
        Assert.assertEquals(stationUpdate.getName(),"Bonga");
        Assert.assertEquals(stationUpdate.getAddress(), "05436800");


    }
}
