package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi;

import java.util.List;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;

/**
 * Created by Bonga on 8/20/2016.
 */
public interface RestAPI<S, ID> {

    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
