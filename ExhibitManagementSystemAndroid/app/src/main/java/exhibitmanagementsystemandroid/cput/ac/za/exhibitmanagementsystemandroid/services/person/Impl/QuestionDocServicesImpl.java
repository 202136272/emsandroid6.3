package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.util.App;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.QuestionedDoc;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl.QuestionDocRepositoryImpl;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.QuestionDocRepository;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Personel.Impl.AdministratorRepositoryImpl;

/**
 * Created by Bonga on 5/12/2016.
 */
public class QuestionDocServicesImpl extends IntentService implements QuestionedDocServices {


    private final QuestionDocRepository repo;


    private static final String ACTION_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.ADD";
    private static final String ACTION_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.action.UPDATE";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.ADD";
    private static final String EXTRA_UPDATE = "exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.services.person.extra.UPDATE";

    private static QuestionDocServicesImpl service = null;

    public static QuestionDocServicesImpl getInstance() {
        if (service == null)
            service = new QuestionDocServicesImpl();
        return service;
    }

    private QuestionDocServicesImpl() {
        super("QuestionDocServicesImpl");
        repo = new QuestionDocRepositoryImpl(App.getAppContext());
    }

    @Override
    public void updateQuestionDoc(Context context, QuestionedDoc questionDoc) {
        Intent intent = new Intent(context, QuestionDocRepositoryImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, questionDoc);
        context.startService(intent);
    }

    @Override
    public void createQuestionDoc(Context context, QuestionedDoc questionDoc) {
        Intent intent = new Intent(context, QuestionDocRepositoryImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, questionDoc);
        context.startService(intent);
    }


    private void postQuestionDoc(QuestionedDoc questionedDoc) {
        QuestionedDoc createdQuestionDoc = repo.update(questionedDoc);
        repo.save(createdQuestionDoc);
    }


    private void updateQuestionDoc(QuestionedDoc questionedDoc) {
        QuestionedDoc updateQuestionDoc = repo.update(questionedDoc);
        repo.save(updateQuestionDoc);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final QuestionedDoc questionDoc = (QuestionedDoc) intent.getSerializableExtra(EXTRA_ADD);
                postQuestionDoc(questionDoc);
            } else if (ACTION_UPDATE.equals(action)) {
                final QuestionedDoc questionDoc = (QuestionedDoc) intent.getSerializableExtra(EXTRA_UPDATE);
                updateQuestionDoc(questionDoc);
            }


        }

    }

}
