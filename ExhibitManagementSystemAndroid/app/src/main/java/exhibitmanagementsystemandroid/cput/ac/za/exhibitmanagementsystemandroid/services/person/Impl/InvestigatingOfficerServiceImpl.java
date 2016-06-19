package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.InvestigatingOfficer;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.BallisticRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.BallisticRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.InvestigatingOfficerRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.InvestigatingOfficerRepository;

/**
 * Created by Bonga on 6/18/2016.
 */
public class InvestigatingOfficerServiceImpl extends Service implements InvestigatingOfficerService {


    private final InvestigatingOfficerRepository investigatingOfficerRepository;

    private final IBinder localBinder = new InvestigatingOfficerServiceLocalBinder();

    private static InvestigatingOfficerServiceImpl service = null;

    public static InvestigatingOfficerServiceImpl getInstance() {
        if (service == null)
            service = new InvestigatingOfficerServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public InvestigatingOfficerServiceImpl() {
        investigatingOfficerRepository = new InvestigatingOfficerRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class InvestigatingOfficerServiceLocalBinder extends Binder {
        public InvestigatingOfficerServiceImpl getService() {
            return InvestigatingOfficerServiceImpl.this;
        }
    }

    @Override
    public InvestigatingOfficer findById(Long id) {
        return investigatingOfficerRepository.findById(id);
    }

    @Override
    public InvestigatingOfficer save(InvestigatingOfficer entity) {
        return investigatingOfficerRepository.save(entity);
    }

    @Override
    public Set<InvestigatingOfficer> findAll() {
        return investigatingOfficerRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        investigatingOfficerRepository.deleteAll();

    }

    public InvestigatingOfficer update(InvestigatingOfficer entity)
    {
        return investigatingOfficerRepository.update(entity);
    }

}
