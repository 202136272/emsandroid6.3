package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi;

import java.io.IOException;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Biology;

/**
 * Created by Bonga on 5/14/2016.
 */
public interface BiologyAPI {
    Administrator createBiology( Biology biology) throws IOException;
    Administrator updateBiology( Biology biology) throws IOException;
}
