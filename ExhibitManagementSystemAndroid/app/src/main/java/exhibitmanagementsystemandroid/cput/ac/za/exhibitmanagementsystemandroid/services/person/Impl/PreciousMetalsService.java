package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import java.util.Set;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.PreciousMetals;

/**
 * Created by Bonga on 6/17/2016.
 */
public interface PreciousMetalsService {

    PreciousMetals findById(Long id);

    PreciousMetals save(PreciousMetals entity);

    Set<PreciousMetals> findAll();


    void deleteAll();

    PreciousMetals update(PreciousMetals entity);
}
