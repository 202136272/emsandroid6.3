package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.PreciousMetals;


/**
 * Created by Bonga on 4/3/2016.
 */
public class PreciousMetalsFactory {

    public static PreciousMetals getPreciousMetals(String mass, String type, String density, String meltingPoint)
    {
        PreciousMetals myPreciousMetals = new PreciousMetals.Builder()
                .mass(mass)
                .type(type)
                .density(density)
                .meltingPoint(meltingPoint)
                .build();
        return myPreciousMetals;

    }
}
