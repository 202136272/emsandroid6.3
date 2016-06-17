package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import java.util.Set;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.InvestigatingOfficer;

/**
 * Created by Bonga on 6/17/2016.
 */
public interface InvestigatingOfficerService {

    InvestigatingOfficer findById(Long id);

    InvestigatingOfficer save(InvestigatingOfficer entity);

    Set<InvestigatingOfficer> findAll();


    void deleteAll();

    InvestigatingOfficer update(InvestigatingOfficer entity);

}
