package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.AdministratorService;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Biology;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.BallisticRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.BallisticRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.BiologyRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.AdministratorRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.AdministratorRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Repository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.AdmistratorServices;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl.AdministratorServiceImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl.BallisticServices;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl.BallisticServicesImpl;

/**
 * Created by Bonga on 5/14/2016.
 */
public class BallisticServicesTest extends AndroidTestCase{

   // private BallisticService service;
    private BallisticRepository repo;
    private Ballistic ballistic;


    public void setUp()throws Exception
    {
        super.setUp();
        repo = new BallisticRepositoryImpl(this.getContext());
    }

    public void testAddBallistic()throws Exception
    {
        Long id;
        Intent intent = new Intent(App.getAppContext(),BallisticRepositoryImpl.class);
        BallisticServices myservice = new BallisticServicesImpl();
        Ballistic  ballistic = new Ballistic.Builder()
                .name("Bonga")
                .reference("05436800")
                .type("Mabulu")
                .build();

        myservice.createBallistic(App.getAppContext(), ballistic);
        App.getAppContext().startService(intent);
        id = ballistic.getId();

        Set<Ballistic> ballisticSet = repo.findAll();
        Assert.assertEquals(ballisticSet.size(), 0);

    }

}
