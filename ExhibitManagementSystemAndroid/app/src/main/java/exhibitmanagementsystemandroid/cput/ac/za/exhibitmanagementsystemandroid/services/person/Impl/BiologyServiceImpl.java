package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Biology;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.BiologyRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.BiologyRepositoryImpl;

/**
 * Created by Bonga on 6/18/2016.
 */

public class BiologyServiceImpl extends Service implements BiologyService {

    private final BiologyRepository biologyRepository;

    private final IBinder localBinder = new BiologyServiceImpl.BiologyServiceLocalBinder();

    private static BiologyServiceImpl service = null;

    public static BiologyServiceImpl getInstance() {
        if (service == null)
            service = new BiologyServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public BiologyServiceImpl() {
        biologyRepository = new BiologyRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class BiologyServiceLocalBinder extends Binder {
        public BiologyServiceImpl getService() {
            return BiologyServiceImpl.this;
        }
    }

    @Override
    public Biology findById(Long id) {
        return biologyRepository.findById(id);
    }

    @Override
    public Biology save(Biology entity) {
        return biologyRepository.save(entity);
    }

    @Override
    public Set<Biology> findAll() {
        return biologyRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        biologyRepository.deleteAll();

    }

    public Biology update(Biology entity)
    {
        return biologyRepository.update(entity);
    }

}

