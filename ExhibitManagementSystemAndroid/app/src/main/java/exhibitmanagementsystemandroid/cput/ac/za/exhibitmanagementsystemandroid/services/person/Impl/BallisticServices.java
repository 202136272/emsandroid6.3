package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.content.Context;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;

/**
 * Created by Bonga on 5/12/2016.
 */
public interface BallisticServices {
    void createBallistic(Context context, Ballistic ballistic);
    void updateBallistic(Context context, Ballistic ballistic);
}
