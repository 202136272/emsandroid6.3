package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi;

import java.io.IOException;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;

/**
 * Created by Bonga on 5/7/2016.
 */
public interface AdministratorAPI {

    Administrator createAdministrator( Administrator administrator) throws IOException;
    Administrator updateAdministrator( Administrator administrator) throws IOException;
}
