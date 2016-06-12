package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Scientific;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.ScientificRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.ScientificRepository;

/**
 * Created by Bonga on 5/12/2016.
 */
public class ScientificServicesImpl extends IntentService implements ScientificServices {


    private final ScientificRepository repo;


    private static final String ACTION_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.ADD";
    private static final String ACTION_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.ADD";
    private static final String EXTRA_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.UPDATE";

    private static ScientificServicesImpl service = null;

    public static ScientificServicesImpl getInstance() {
        if (service == null)
            service = new ScientificServicesImpl();
        return service;
    }

    private ScientificServicesImpl() {
        super("AdministratorServicesImpl");
        repo = new ScientificRepositoryImpl(App.getAppContext());
    }
    @Override
    public void updateScientific(Context context, Scientific scientific) {
        Intent intent = new Intent(context, ScientificRepositoryImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, scientific);
        context.startService(intent);
    }

    @Override
    public void createScientific(Context context, Scientific scientific) {
        Intent intent = new Intent(context, ScientificRepositoryImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, scientific);
        context.startService(intent);
    }


    private void postScientific(Scientific scientific) {
        Scientific createdScientific = repo.update(scientific);
        repo.save(createdScientific);
    }


    private void updateScientific(Scientific scientific) {
        Scientific updatedScientific = repo.update(scientific);
        repo.save(updatedScientific);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Scientific scientific = (Scientific) intent.getSerializableExtra(EXTRA_ADD);
                postScientific(scientific);
            } else if (ACTION_UPDATE.equals(action)) {
                final Scientific scientific = (Scientific) intent.getSerializableExtra(EXTRA_UPDATE);
                updateScientific(scientific);
            }


        }

    }
}
