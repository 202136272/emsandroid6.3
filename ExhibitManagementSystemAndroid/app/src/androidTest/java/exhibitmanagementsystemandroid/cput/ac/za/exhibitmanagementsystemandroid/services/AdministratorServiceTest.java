package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services;

import android.content.Intent;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl.AdministratorService;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.AdministratorRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.AdministratorRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl.AdministratorServiceImpl;

/**
 * Created by Bonga on 5/7/2016.
 */

    public class AdministratorServiceTest extends AndroidTestCase{
       private AdministratorService service;
        private AdministratorRepository repo;
        private Administrator administrator;


        public void setUp()throws Exception
        {
            super.setUp();
            repo = new AdministratorRepositoryImpl(this.getContext());
        }

        public void testAddCash()throws Exception
        {
            Long id;
            Intent intent = new Intent(App.getAppContext(),AdministratorRepositoryImpl.class);
            AdmistratorServices myservice = new AdministratorServiceImpl();
            Administrator  administrator1 = new Administrator.Builder()
                    .name("Bonga")
                    .persalNumber("05436800")
                    .surname("Mabulu")
                    .build();

            myservice.createAdministrator(App.getAppContext(), administrator1);
            App.getAppContext().startService(intent);
            id = administrator.getId();

            Set<Administrator> administrator1Set = repo.findAll();
            Assert.assertEquals(administrator1Set.size(), 0);

        }



    }
