package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.Impl;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.List;
import java.util.Set;


import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi.RestAPI;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi.rest.AdministratorRest;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.AdministratorService;

/**
 * Created by Bonga on 5/7/2016.
 */


public class AdministratorServiceImpl implements AdministratorService {

    final RestAPI<Administrator,Long> rest = new AdministratorRest();

    @Override
    public Administrator findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Administrator entity) {
        return null;
    }

    @Override
    public String update(Administrator entity) {
        return null;
    }

    @Override
    public String delete(Administrator entity) {
        return null;
    }

    @Override
    public List<Administrator> findAll() {
        return null;
    }
}






