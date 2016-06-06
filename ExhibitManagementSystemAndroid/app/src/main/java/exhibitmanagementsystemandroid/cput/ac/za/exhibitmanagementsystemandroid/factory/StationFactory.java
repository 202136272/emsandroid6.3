package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;


import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Station;


/**
 * Created by Bonga on 4/3/2016.
 */
public class StationFactory {

    public static Station getStation(String name, String address)
    {
        Station myStation = new Station.Builder()
                .name(name)
                .address(address)
                .build();
        return myStation;

    }
}
