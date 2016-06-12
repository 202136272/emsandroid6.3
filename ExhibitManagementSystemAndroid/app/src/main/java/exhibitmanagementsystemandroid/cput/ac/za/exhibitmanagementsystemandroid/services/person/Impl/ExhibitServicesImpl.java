package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.ExhibitRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.Impl.ExhibitRepositoryImpl;

/**
 * Created by Bonga on 5/12/2016.
 */
public class ExhibitServicesImpl extends IntentService implements ExhibitServices {


    private final ExhibitRepository repo;


    private static final String ACTION_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.ADD";
    private static final String ACTION_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.ADD";
    private static final String EXTRA_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.UPDATE";

    private static ExhibitServicesImpl service = null;

    public static ExhibitServicesImpl getInstance() {
        if (service == null)
            service = new ExhibitServicesImpl();
        return service;
    }

    public ExhibitServicesImpl() {
        super("ExhibitServiceImpl");
        repo = new ExhibitRepositoryImpl(App.getAppContext());
    }

    @Override
    public void updateExhibit(Context context, Exhibit exhibit) {
        Intent intent = new Intent(context, ExhibitRepositoryImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, exhibit);
        context.startService(intent);
    }

    @Override
    public void createExhibit(Context context, Exhibit exhibit) {
        Intent intent = new Intent(context, ExhibitRepositoryImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, exhibit);
        context.startService(intent);
    }


    private void postExhibit(Exhibit exhibit) {
        Exhibit createdExhibit = repo.update(exhibit);
        repo.save(createdExhibit);
    }


    private void updateExhibit(Exhibit exhibit) {
        Exhibit updatedExhibit = repo.update(exhibit);
        repo.save(updatedExhibit);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Exhibit exhibit = (Exhibit) intent.getSerializableExtra(EXTRA_ADD);
                postExhibit(exhibit);
            } else if (ACTION_UPDATE.equals(action)) {
                final Exhibit exhibit = (Exhibit) intent.getSerializableExtra(EXTRA_UPDATE);
                updateExhibit(exhibit);
            }


        }

    }

}