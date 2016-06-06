package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Person;


/**
 * Created by nard Dukashe on 2016/03/28.
 */
public class PersonFactory {

    public static Person getPerson(String name, String surname, String persalNumber)
    {
        Person myPerson = new Person.Builder()
                .name(name)
                .surname(surname)
                .persalNumber(persalNumber)
                .build();
        return myPerson;

    }

}
