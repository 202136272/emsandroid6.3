package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Person;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.PersonFactory;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.PersonRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.PersonRepository;

/**
 * Created by Bonga on 5/8/2016.
 */
public class PersonRepositoryTest extends AndroidTestCase {


    private static final String TAG ="ADMINISTRATOR TEST";
    private Long id;


    public void testCreateReadUpdateDelete() throws Exception {

        PersonRepository repo = new PersonRepositoryImpl(this.getContext());
        // CREATE
        Person person = PersonFactory.getPerson("Cipher", "Pol", "x11");
        Person insertedEntity = repo.save(person);

        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ENTITY
        Person entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //READ ALL
        Set<Person> settings = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //UPDATE ENTITY
        Person updateEntity = new Person.Builder()
                .copy(entity)
                .name("Mikel")
                .build();

        repo.update(updateEntity);
        Person newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Mikel", newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Person deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}
