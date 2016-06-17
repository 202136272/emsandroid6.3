package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Biology;

/**
 * Created by Bonga on 6/17/2016.
 */
public interface BiologyService {

    Biology findById(Long id);

    Biology save(Biology entity);

    Set<Biology> findAll();


    void deleteAll();

    Biology update(Biology entity);
}
