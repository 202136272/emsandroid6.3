package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.content.Context;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Scientific;

/**
 * Created by Bonga on 5/12/2016.
 */
public interface ScientificServices {

    void createScientific(Context context, Scientific scientific);
    void updateScientific(Context context, Scientific scientific);
}
