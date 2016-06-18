package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.BallisticRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.BallisticRepositoryImpl;

/**
 * Created by Bonga on 6/18/2016.
 */
public class BallisticServiceImpl extends Service implements BallisticService {


    private final BallisticRepository ballisticRepository;

    private final IBinder localBinder = new BallisticServiceLocalBinder();

    private static BallisticServiceImpl service = null;

    public static BallisticServiceImpl getInstance() {
        if (service == null)
            service = new BallisticServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public BallisticServiceImpl() {
        ballisticRepository = new BallisticRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class BallisticServiceLocalBinder extends Binder {
        public BallisticServiceImpl getService() {
            return BallisticServiceImpl.this;
        }
    }

    @Override
    public Ballistic findById(Long id) {
        return ballisticRepository.findById(id);
    }

    @Override
    public Ballistic save(Ballistic entity) {
        return ballisticRepository.save(entity);
    }

    @Override
    public Set<Ballistic> findAll() {
        return ballisticRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        ballisticRepository.deleteAll();

    }

    public Ballistic update(Ballistic entity)
    {
        return ballisticRepository.update(entity);
    }

}
