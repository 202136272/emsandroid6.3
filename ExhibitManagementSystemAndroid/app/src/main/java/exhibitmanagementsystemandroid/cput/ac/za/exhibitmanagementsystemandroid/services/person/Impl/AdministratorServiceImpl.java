package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.AdministratorService;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.AdministratorRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.AdministratorRepositoryImpl;

/**
 * Created by Bonga on 5/7/2016.
 */


public class AdministratorServiceImpl extends Service implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    private final IBinder localBinder = new AdministratorServiceLocalBinder();

    private static AdministratorServiceImpl service = null;

    public static AdministratorServiceImpl getInstance() {
        if (service == null)
            service = new AdministratorServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public AdministratorServiceImpl() {
        administratorRepository = new AdministratorRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class AdministratorServiceLocalBinder extends Binder {
        public AdministratorServiceImpl getService() {
            return AdministratorServiceImpl.this;
        }
    }

    @Override
    public Administrator findById(Long id) {
        return administratorRepository.findById(id);
    }

    @Override
    public Administrator save(Administrator entity) {
        return administratorRepository.save(entity);
    }

    @Override
    public Set<Administrator> findAll() {
        return administratorRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        administratorRepository.deleteAll();

    }

    public Administrator update(Administrator entity)
    {
        return administratorRepository.update(entity);
    }

}






