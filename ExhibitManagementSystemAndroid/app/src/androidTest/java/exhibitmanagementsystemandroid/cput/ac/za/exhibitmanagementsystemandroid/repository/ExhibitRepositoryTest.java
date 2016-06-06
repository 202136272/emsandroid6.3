package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.ExhibitFactory;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.ExhibitRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.Impl.ExhibitRepositoryImpl;

/**
 * Created by Bonga on 4/24/2016.
 */
public class ExhibitRepositoryTest extends AndroidTestCase{

    private static final String TAG ="EXHIBIT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        ExhibitRepository repo = new ExhibitRepositoryImpl(this.getContext());
        // CREATE
        Exhibit createEntity = ExhibitFactory.getExhibit("Admin", "User", "1", "1");
        Exhibit insertedEntity = repo.save(createEntity);

        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        System.out.println(insertedEntity.getId() + " " + insertedEntity.getId());
        System.out.println("The ID is: " + id);


        //READ ENTITY
        Exhibit entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //READ ALL
        //Set<Exhibit> exhibits = repo.findAll();
        //Assert.assertTrue(TAG + " READ ALL", exhibits.size() > 0);

        //UPDATE ENTITY
        Exhibit updateEntity = new Exhibit.Builder()
                .copy(entity)
                .casNumber("23April")
                .build();

        repo.update(updateEntity);
        Exhibit newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "23April", newEntity.getCasNumber());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Exhibit deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}
