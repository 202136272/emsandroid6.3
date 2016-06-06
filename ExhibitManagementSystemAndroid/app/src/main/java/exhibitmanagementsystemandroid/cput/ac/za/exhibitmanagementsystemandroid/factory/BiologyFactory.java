package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Biology;



/**
 * Created by Bonga on 4/3/2016.
 */
public class BiologyFactory {

    public static Biology getBiology(String name, String reference, String type)
    {
        Biology myBiology = new Biology.Builder()
                .name(name)
                .reference(reference)
                .type(type)
                .build();
        return myBiology;

    }
}
