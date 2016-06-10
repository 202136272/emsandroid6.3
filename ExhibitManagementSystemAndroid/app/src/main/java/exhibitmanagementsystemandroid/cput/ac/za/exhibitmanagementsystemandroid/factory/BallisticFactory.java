package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;



/**
 * Created by Bonga on 4/3/2016.
 */

public class BallisticFactory {

    public static Ballistic getBallistic(String name, String reference,String type)
    {
        Ballistic myBallistic = new Ballistic.Builder()
                .reference(reference)
                .name(name)
                .type(type)
                .build();
        return myBallistic;

    }


}
