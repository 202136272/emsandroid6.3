package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.content.Context;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;

/**
 * Created by Bonga on 5/12/2016.
 */

public interface ExhibitServices {

    void createExhibit(Context context, Exhibit exhibit);
    void updateExhibit(Context context, Exhibit exhibit);

}
