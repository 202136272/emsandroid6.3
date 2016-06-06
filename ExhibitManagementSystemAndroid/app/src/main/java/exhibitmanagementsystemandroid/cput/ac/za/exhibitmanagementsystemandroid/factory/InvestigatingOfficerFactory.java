package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.InvestigatingOfficer;


/**
 * Created by Leonard Dukashe on 2016/03/28.
 */
public class InvestigatingOfficerFactory {

    public static InvestigatingOfficer getInvestigatingOfficer(String name, String rank, String station, String persalNumber)
    {
        InvestigatingOfficer myInvestigatingOfficer = new InvestigatingOfficer.Builder()
                .name(name)
                .rank(rank)
                .station(station)
                .persalNumber(persalNumber)
                .build();
        return myInvestigatingOfficer;

    }
}
