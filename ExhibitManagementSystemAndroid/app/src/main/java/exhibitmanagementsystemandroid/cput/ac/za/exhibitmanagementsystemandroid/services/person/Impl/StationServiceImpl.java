package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.util.Set;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Station;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.StationRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.StationRepository;

/**
 * Created by Bonga on 6/18/2016.
 */

public class StationServiceImpl extends Service implements StationService {


    private final StationRepository stationRepository;

    private final IBinder localBinder = new BallisticServiceLocalBinder();

    private static StationServiceImpl service = null;
    public static StationServiceImpl getInstance() {
        if (service == null)
            service = new StationServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public StationServiceImpl() {
        stationRepository = new StationRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class BallisticServiceLocalBinder extends Binder {
        public StationServiceImpl getService() {
            return StationServiceImpl.this;
        }
    }

    @Override
    public Station findById(Long id) {
        return stationRepository.findById(id);
    }

    @Override
    public Station save(Station entity) {
        return stationRepository.save(entity);
    }

    @Override
    public Set<Station> findAll() {
        return stationRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        stationRepository.deleteAll();

    }

    public Station update(Station entity)
    {
        return stationRepository.update(entity);
    }

}
