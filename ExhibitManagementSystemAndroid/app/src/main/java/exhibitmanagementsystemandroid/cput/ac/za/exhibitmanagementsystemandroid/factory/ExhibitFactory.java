package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;


/**
 * Created by Leonard Dukashe on 2016/03/28.
 */
public class ExhibitFactory {

    public static Exhibit getExhibit(String casNumber, String station, String description, String sceneType )
    {
        Exhibit myExhibit = new Exhibit.Builder()
                .casNumber(casNumber)
                .station(station)
                .description(description)
                .sceneType(sceneType)
                .build();
        return myExhibit;

    }
}
