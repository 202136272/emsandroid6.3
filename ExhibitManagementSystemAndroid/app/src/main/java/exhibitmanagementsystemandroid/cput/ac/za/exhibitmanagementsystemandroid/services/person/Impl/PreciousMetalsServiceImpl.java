package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.PreciousMetals;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.PreciousMetalsRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.PreciousMetalsRepository;

/**
 * Created by Bonga on 6/18/2016.
 */

public class PreciousMetalsServiceImpl extends Service implements PreciousMetalsService {

    private final PreciousMetalsRepository preciousMetalsRepository;

    private final IBinder localBinder = new PreciousMetalsServiceImpl.PreciousMetalsServiceLocalBinder();

    private static PreciousMetalsServiceImpl service = null;
    public static PreciousMetalsServiceImpl getInstance() {
        if (service == null)
            service = new PreciousMetalsServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public PreciousMetalsServiceImpl() {
        preciousMetalsRepository = new PreciousMetalsRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class PreciousMetalsServiceLocalBinder extends Binder {
        public PreciousMetalsServiceImpl getService() {
            return PreciousMetalsServiceImpl.this;
        }
    }

    @Override
    public PreciousMetals findById(Long id) {
        return preciousMetalsRepository.findById(id);
    }

    @Override
    public PreciousMetals save(PreciousMetals entity) {
        return preciousMetalsRepository.save(entity);
    }

    @Override
    public Set<PreciousMetals> findAll() {
        return preciousMetalsRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        preciousMetalsRepository.deleteAll();

    }

    public PreciousMetals update(PreciousMetals entity)
    {
        return preciousMetalsRepository.update(entity);
    }

}
