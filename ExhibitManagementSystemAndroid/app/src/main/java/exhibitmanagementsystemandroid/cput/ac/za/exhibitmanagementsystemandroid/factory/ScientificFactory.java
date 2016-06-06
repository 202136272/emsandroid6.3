package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Scientific;


/**
 * Created by Bonga on 4/3/2016.
 */
public class ScientificFactory {

    public static Scientific getScientific(String name, String mass) {
        Scientific myScientific = new Scientific.Builder()
                .name(name)
                .mass(mass)
                .build();
        return myScientific;


    }


}