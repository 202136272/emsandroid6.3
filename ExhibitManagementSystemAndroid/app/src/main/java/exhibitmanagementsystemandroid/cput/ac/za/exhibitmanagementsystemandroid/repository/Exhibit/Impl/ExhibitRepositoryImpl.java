package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.conf.databases.DBConstants;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Exhibit;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Exhibit.ExhibitRepository;

/**
 * Created by Bonga on 4/23/2016.
 */
public class ExhibitRepositoryImpl extends SQLiteOpenHelper implements ExhibitRepository {

    public static final String TABLE_NAME = "EXHIBIT";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CASNUMBER = "casNumber";
    public static final String COLUMN_STATION = " station";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_SCENETYPE = "sceneType";


    public ExhibitRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CASNUMBER + " TEXT  NOT NULL , "
            + COLUMN_STATION + " TEXT NOT NULL , "
            + COLUMN_DESCRIPTION + " TEXT NOT NULL , "
            + COLUMN_SCENETYPE + " TEXT NOT NULL )";


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
    public Exhibit findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CASNUMBER,
                        COLUMN_STATION,
                        COLUMN_DESCRIPTION,
                        COLUMN_SCENETYPE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Exhibit exhibit = new Exhibit.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .casNumber(cursor.getString(cursor.getColumnIndex(COLUMN_CASNUMBER)))
                    .station(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .sceneType(cursor.getString(cursor.getColumnIndex(COLUMN_SCENETYPE)))
                    .build();
            return exhibit;
        } else {
            return null;
        }
    }

    @Override
    public Exhibit save(Exhibit entity) {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CASNUMBER, entity.getCasNumber());
        values.put(COLUMN_STATION, entity.getStation());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());
        values.put(COLUMN_SCENETYPE, entity.getSceneType());

        long id = db.insertOrThrow(TABLE_NAME, null, values);

        Exhibit insertedEntity = new Exhibit.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();

        return insertedEntity;
    }

    @Override
    public Exhibit update(Exhibit entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CASNUMBER, entity.getCasNumber());
        values.put(COLUMN_STATION, entity.getStation());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());
        values.put(COLUMN_SCENETYPE, entity.getSceneType());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Exhibit delete(Exhibit entity) {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Exhibit> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Exhibit> exhib = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null,null,null,null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final Exhibit exhibit = new Exhibit.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .casNumber(cursor.getString(cursor.getColumnIndex(COLUMN_CASNUMBER)))
                        .station(cursor.getString(cursor.getColumnIndex(COLUMN_STATION)))
                        .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                        .sceneType(cursor.getString(cursor.getColumnIndex(COLUMN_SCENETYPE)))
                        .build();

                exhib.add(exhibit);
            } while (cursor.moveToNext());
        }
        return exhib;





        /*SQLiteDatabase db = this.getReadableDatabase();
        Set<Administrator> admin = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Administrator administrator = new Administrator.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .persalNumber(cursor.getString(cursor.getColumnIndex(COLUMN_PERSALNUMBER)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAMR)))
                        .build();

                admin.add(administrator);
            } while (cursor.moveToNext());
        }
        return admin;*/
    }



    @Override
    public int deleteAll() {
            open();
            int rowsDeleted = db.delete(TABLE_NAME,null,null);
            close();
            return rowsDeleted;
    }


}
