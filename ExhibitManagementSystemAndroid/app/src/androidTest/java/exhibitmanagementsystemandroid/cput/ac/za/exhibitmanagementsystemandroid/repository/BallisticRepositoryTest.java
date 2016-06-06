package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository;


import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.BallisticFactory;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.BallisticRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.BallisticRepositoryImpl;

/**
 * Created by Bonga on 4/23/2016.
 */
public class BallisticRepositoryTest extends AndroidTestCase {

    private static final String TAG ="BALLISTIC TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        BallisticRepository repo = new BallisticRepositoryImpl(this.getContext());

        // CREATE
        Ballistic createEntity = BallisticFactory.CreateBallistic("Bonga", "23", "cad");
        Ballistic insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

       //READ ENTITY
        Ballistic entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //READ ALL
        Set<Ballistic>   ballistics = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", ballistics.size() > 0);

        //UPDATE ENTITY
        Ballistic updateEntity = new Ballistic.Builder()
                .copy(entity)
                .name("Bonga")
                .build();
        repo.update(updateEntity);
        Ballistic newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "Bonga", newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Ballistic deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);

    }
}
