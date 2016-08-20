package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services;

import java.util.List;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;

/**
 * Created by Bonga on 8/20/2016.
 */
public interface Services <S, ID> {

    public S findById(ID id);

    public String save(S entity);

    public String update(Administrator entity);

    public String delete(Administrator entity);

    public List<S> findAll();

}