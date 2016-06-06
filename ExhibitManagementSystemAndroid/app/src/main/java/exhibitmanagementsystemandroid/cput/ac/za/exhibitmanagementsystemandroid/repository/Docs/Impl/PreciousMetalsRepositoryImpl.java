package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.databases.DBConstants;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.PreciousMetals;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.PreciousMetalsRepository;

/**
 * Created by Bonga on 4/23/2016.
 */
public class PreciousMetalsRepositoryImpl extends SQLiteOpenHelper implements PreciousMetalsRepository {

    public static final String TABLE_NAME = "PERSON";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MASS = "persalNumber";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_DENSITY = "density";
    public static final String COLUMN_MELTINGPOINT = " meltingPoint";

    public PreciousMetalsRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_MASS + " TEXT  NOT NULL , "
            + COLUMN_DENSITY + " TEXT NOT NULL , "
            + COLUMN_MELTINGPOINT + " TEXT NOT NULL)";

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
    public PreciousMetals findById(Long id) {
        return null;
    }

    @Override
    public PreciousMetals save(PreciousMetals entity) {
        return null;
    }

    @Override
    public PreciousMetals update(PreciousMetals entity) {
        return null;
    }

    @Override
    public PreciousMetals delete(PreciousMetals entity) {
        return null;
    }

    @Override
    public Set<PreciousMetals> findAll() {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
