package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person;

import android.content.Context;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;

/**
 * Created by Bonga on 5/7/2016.
 */
public interface AdmistratorServices {

    void createAdministrator(Context context, Administrator administrator);
    void updateAdmistrator(Context context, Administrator administrator);

}
