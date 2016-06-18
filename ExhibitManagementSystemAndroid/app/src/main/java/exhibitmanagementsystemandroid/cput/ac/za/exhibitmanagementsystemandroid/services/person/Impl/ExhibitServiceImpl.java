package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.ExhibitRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.Impl.ExhibitRepositoryImpl;

/**
 * Created by Bonga on 6/18/2016.
 */
public class ExhibitServiceImpl extends Service implements ExhibitService {


    private final ExhibitRepository exhibitRepository;

    private final IBinder localBinder = new ExhibitServiceLocalBinder();

    private static ExhibitServiceImpl service = null;

    public static ExhibitServiceImpl getInstance() {
        if (service == null)
            service = new ExhibitServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public ExhibitServiceImpl() {
        exhibitRepository = new ExhibitRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ExhibitServiceLocalBinder extends Binder {
        public ExhibitServiceImpl getService() {
            return ExhibitServiceImpl.this;
        }
    }

    @Override
    public Exhibit findById(Long id) {
        return exhibitRepository.findById(id);
    }

    @Override
    public Exhibit save(Exhibit entity) {
        return exhibitRepository.save(entity);
    }

    @Override
    public Set<Exhibit> findAll() {
        return exhibitRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        exhibitRepository.deleteAll();

    }

    public Exhibit update(Exhibit entity)
    {
        return exhibitRepository.update(entity);
    }

}

