package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository;

import android.test.AndroidTestCase;
import junit.framework.Assert;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory.AdministratorFactory;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.AdministratorRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.AdministratorRepositoryImpl;

/**
 * Created by Bonga on 4/22/2016.
 */
public class AdministratorRepositoryTest extends AndroidTestCase{

    private static final String TAG ="ADMINISTRATOR TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        AdministratorRepository repo = new AdministratorRepositoryImpl(this.getContext());
        // CREATE
        Administrator createEntity = AdministratorFactory.getAdministrator("Admin", "User", "1");
        Administrator insertedEntity = repo.save(createEntity);

        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        System.out.println(insertedEntity.getId() + " " + insertedEntity.getName());
        System.out.println("The ID is: " + id);


        //READ ENTITY
        Administrator entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);

        //READ ALL
        Set<Administrator> settings = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", settings.size() > 0);

        //UPDATE ENTITY
        Administrator updateEntity = new Administrator.Builder()
                .copy(entity)
                .name("GADULDT")
                .build();

        repo.update(updateEntity);
        Administrator newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "GADULDT", newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Administrator deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);
    }
}
