package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.PersonFactory;

/**
 * Created by Bonga on 2016/03/28.
 */
public class PersonTest {

    private Person person;


    @Before
    public void setUp() throws Exception {

        person = PersonFactory.getPerson("Bonga", "Mabulu", "05436800");
    }

    @Test
    public void testPerson() throws Exception {
        Assert.assertEquals(person.getName(),"Bonga");
        Assert.assertEquals(person.getSurname(), "Mabulu");
        Assert.assertEquals(person.getPersalNumber(), "05436800");

    }

    @Test
    public void testNewUpdate() throws Exception {
        Person personUpdate = new Person.Builder()
                .copy(person)
                .persalNumber("05436800")
                .surname("Mabulu")
                .build();
        Assert.assertEquals(personUpdate.getName(),"Bonga");
        Assert.assertEquals(personUpdate.getSurname(), "Mabulu");
        Assert.assertEquals(personUpdate.getPersalNumber(), "05436800");

    }
}


