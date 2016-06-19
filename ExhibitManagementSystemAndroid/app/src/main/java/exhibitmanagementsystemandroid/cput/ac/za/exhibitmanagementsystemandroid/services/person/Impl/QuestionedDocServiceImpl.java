package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.QuestionedDoc;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.QuestionDocRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.QuestionDocRepository;

/**
 * Created by Bonga on 6/19/2016.
 */
public class QuestionedDocServiceImpl extends Service implements QuestionedDocService {


    private final QuestionDocRepository questionDocRepository;

    private final IBinder localBinder = new QuestionedDocServiceLocalBinder();

    private static QuestionedDocServiceImpl service = null;

    public static QuestionedDocServiceImpl getInstance() {
        if (service == null)
            service = new QuestionedDocServiceImpl();
        return service;
    }

    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    // WARNING !!! MAKE THIS CONSTRUCTOR PUBLIC FOR TESTING PURPOSE
    public QuestionedDocServiceImpl() {
        questionDocRepository = new QuestionDocRepositoryImpl(App.getAppContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class QuestionedDocServiceLocalBinder extends Binder {
        public QuestionedDocServiceImpl getService() {
            return QuestionedDocServiceImpl.this;
        }
    }

    @Override
    public QuestionedDoc findById(Long id) {
        return questionDocRepository.findById(id);
    }

    @Override
    public QuestionedDoc save(QuestionedDoc entity) {
        return questionDocRepository.save(entity);
    }

    @Override
    public Set<QuestionedDoc> findAll() {
        return questionDocRepository.findAll();
    }


    @Override
    public void deleteAll()
    {
        questionDocRepository.deleteAll();

    }

    public QuestionedDoc update(QuestionedDoc entity)
    {
        return questionDocRepository.update(entity);
    }

}
