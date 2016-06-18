package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Scientific;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.ScientificRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.ScientificRepository;

/**
 * Created by Bonga on 6/18/2016.
 */
public class ScientificServiceImpl extends Service implements ScientificService {


    private final ScientificRepository scientificRepository;

    private final IBinder localBinder = new ScientificServiceLocalBinder();

    private static ScientificServiceImpl service = null;

    public static ScientificServiceImpl getInstance() {
        if (service == null)
            service = new ScientificServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public ScientificServiceImpl() {
        scientificRepository = new ScientificRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ScientificServiceLocalBinder extends Binder {
        public ScientificServiceImpl getService() {
            return ScientificServiceImpl.this;
        }
    }

    @Override
    public Scientific findById(Long id) {
        return scientificRepository.findById(id);
    }

    @Override
    public Scientific save(Scientific entity) {
        return scientificRepository.save(entity);
    }

    @Override
    public Set<Scientific> findAll() {
        return scientificRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        scientificRepository.deleteAll();

    }

    public Scientific update(Scientific entity)
    {
        return scientificRepository.update(entity);
    }

}
