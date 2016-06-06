package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.databases.DBConstants;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Biology;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.BiologyRepository;

/**
 * Created by Bonga on 4/23/2016.
 */
public class BiologyRepositoryImpl extends SQLiteOpenHelper implements BiologyRepository {

    public static final String TABLE_NAME = "ADMINISTRATOR";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_REFERENCE = "reference";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TYPE = "surname";


    public BiologyRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_REFERENCE + " TEXT  NOT NULL , "
            + COLUMN_NAME + " TEXT NOT NULL , "
            + COLUMN_TYPE + " TEXT NOT NULL)";

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
    public Biology findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_REFERENCE,
                        COLUMN_NAME,
                        COLUMN_TYPE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Biology biology = new Biology.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .reference(cursor.getString(cursor.getColumnIndex(COLUMN_REFERENCE)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .type(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)))
                    .build();
            return biology;
        } else {
            return null;
        }
    }

    @Override
    public Biology save(Biology entity) {
        return null;
    }

    @Override
    public Biology update(Biology entity) {
        return null;
    }

    @Override
    public Biology delete(Biology entity) {
        return null;
    }

    @Override
    public Set<Biology> findAll() {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
