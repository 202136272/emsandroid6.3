package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.AdministratorRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.AdministratorRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi.AdministratorAPI;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi.Impl.AdministratorAPIImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.AdmistratorServices;

/**
 * Created by Bonga on 5/7/2016.
 */
public class AdministratorServiceImpl extends IntentService implements AdmistratorServices {


    private final AdministratorRepository repo;


    private static final String ACTION_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.ADD";
    private static final String ACTION_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.ADD";
    private static final String EXTRA_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.UPDATE";

    private static AdministratorServiceImpl service = null;

    public static AdministratorServiceImpl getInstance() {
        if (service == null)
            service = new AdministratorServiceImpl();
        return service;
    }

    public AdministratorServiceImpl() {
        super("AdministratorServiceImpl");
        repo = new AdministratorRepositoryImpl(App.getAppContext());
    }

    @Override
    public void updateAdmistrator(Context context, Administrator administrator) {
        Intent intent = new Intent(context, AdministratorRepositoryImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, administrator);
        context.startService(intent);
    }

    @Override
    public void createAdministrator(Context context, Administrator administrator) {
        Intent intent = new Intent(context, AdministratorRepositoryImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, administrator);
        context.startService(intent);
    }


    private void postCustomer(Administrator admin) {
        Administrator createdAdministrator = repo.update(admin);
        repo.save(createdAdministrator);
    }


    private void updateCustomer(Administrator admin) {
        Administrator updatedCustomer = repo.update(admin);
        repo.save(updatedCustomer);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Administrator administrator = (Administrator) intent.getSerializableExtra(EXTRA_ADD);
                postCustomer(administrator);
            } else if (ACTION_UPDATE.equals(action)) {
                final Administrator customers = (Administrator) intent.getSerializableExtra(EXTRA_UPDATE);
                updateCustomer(customers);
            }


        }

    }

}




