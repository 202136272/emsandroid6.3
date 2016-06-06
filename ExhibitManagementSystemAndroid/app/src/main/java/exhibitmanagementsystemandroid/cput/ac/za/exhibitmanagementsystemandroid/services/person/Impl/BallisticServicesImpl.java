package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.BallisticRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.BallisticRepositoryImpl;

/**
 * Created by Bonga on 5/12/2016.
 */
public class BallisticServicesImpl extends IntentService implements BallisticServices {

    private final BallisticRepository repo;


    private static final String ACTION_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.ADD";
    private static final String ACTION_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.ADD";
    private static final String EXTRA_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.UPDATE";

    private static BallisticServicesImpl service = null;

    public static BallisticServicesImpl getInstance() {
        if (service == null)
            service = new BallisticServicesImpl();
        return service;
    }

    public BallisticServicesImpl() {
        super("BallisticServicesImpl");
        repo = new BallisticRepositoryImpl(App.getAppContext());
    }

    @Override
    public void updateBallistic(Context context, Ballistic ballistic) {
        Intent intent = new Intent(context, BallisticRepositoryImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, ballistic);
        context.startService(intent);
    }

    @Override
    public void createBallistic(Context context, Ballistic ballistic) {
        Intent intent = new Intent(context, BallisticRepositoryImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, ballistic);
        context.startService(intent);
    }


    private void postBallistic(Ballistic bal) {
        Ballistic createdBallistic = repo.update(bal);
        repo.save(createdBallistic);
    }


    private void updateBallistic(Ballistic bal) {
        Ballistic updatedBallistic = repo.update(bal);
        repo.save(updatedBallistic);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Ballistic ballistic = (Ballistic) intent.getSerializableExtra(EXTRA_ADD);
                postBallistic(ballistic);
            } else if (ACTION_UPDATE.equals(action)) {
                final Ballistic ballistic = (Ballistic) intent.getSerializableExtra(EXTRA_UPDATE);
                updateBallistic(ballistic);
            }


        }

    }

}
