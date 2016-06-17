package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;


    public interface AdministratorService {

        Administrator findById(Long id);

        Administrator save(Administrator entity);

        Set<Administrator> findAll();


         void deleteAll();

        Administrator update(Administrator entity);


    }

