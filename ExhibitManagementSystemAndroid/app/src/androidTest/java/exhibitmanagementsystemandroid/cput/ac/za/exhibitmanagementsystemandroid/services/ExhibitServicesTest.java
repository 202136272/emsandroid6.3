package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.ExhibitRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.Impl.ExhibitRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl.ExhibitService;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl.ExhibitServicesImpl;

/**
 * Created by Bonga on 5/14/2016.
 */
public class ExhibitServicesTest extends AndroidTestCase {
    private ExhibitService service;
    private ExhibitRepository repo;
    private Exhibit exhibit;


    public void setUp()throws Exception
    {
        super.setUp();
        repo = new ExhibitRepositoryImpl(this.getContext());
    }

    public void testAddExhibit()throws Exception
    {
        Long id;
        Intent intent = new Intent(App.getAppContext(),ExhibitRepositoryImpl.class);
        ExhibitService myservice = new ExhibitServicesImpl();
        Exhibit  exhibit = new Exhibit.Builder()
                .casNumber("1/1/16")
                .station("Delft")
                .description("Mabulu")
                .sceneType("arson")
                .build();

        myservice.createExhibit(App.getAppContext(), exhibit);
        App.getAppContext().startService(intent);
        id = exhibit.getId();

        Set<Exhibit> exhibitSet = repo.findAll();
        Assert.assertEquals(exhibitSet.size(), 0);

    }


}
