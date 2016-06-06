package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.databases.DBConstants;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.QuestionedDoc;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.QuestionDocRepository;

/**
 * Created by Bonga on 4/23/2016.
 */
public class QuestionDocRepositoryImpl extends SQLiteOpenHelper implements QuestionDocRepository {

    public static final String TABLE_NAME = "QUESTIONDOC";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_REFERENCE = "reference";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DATE = "date";


    public QuestionDocRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_REFERENCE + " TEXT  NOT NULL , "
            + COLUMN_NAME + " TEXT  NOT NULL , "
            + COLUMN_DATE + " TEXT NOT NULL)";

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public QuestionedDoc findById(Long id) {
        return null;
    }

    @Override
    public QuestionedDoc save(QuestionedDoc entity) {
        return null;
    }

    @Override
    public QuestionedDoc update(QuestionedDoc entity) {
        return null;
    }

    @Override
    public QuestionedDoc delete(QuestionedDoc entity) {
        return null;
    }

    @Override
    public Set<QuestionedDoc> findAll() {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
