package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.Impl;

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
        import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Ballistic;
        import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.repository.Docs.BallisticRepository;

/**
 * Created by Bonga on 4/23/2016.
 */
public class BallisticRepositoryImpl extends SQLiteOpenHelper implements BallisticRepository {

    public static final String TABLE_NAME = "BALLISTIC";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_REFERENCE = "reference";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TYPE = "type";

    public BallisticRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }
    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_REFERENCE + " TEXT  NOT NULL , "
            + COLUMN_NAME + " TEXT NOT NULL , "
            + COLUMN_TYPE + " TEXT NOT NULL);";

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
    public Ballistic findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_REFERENCE,
                        COLUMN_TYPE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Ballistic ballistic = new Ballistic.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .reference(cursor.getString(cursor.getColumnIndex(COLUMN_REFERENCE)))
                    .type(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)))
                    .build();
            return ballistic;
        } else {
            return null;
        }

    }

    @Override
    public Ballistic save(Ballistic entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_REFERENCE, entity.getReference());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_TYPE, entity.getType());

        long id = db.insertOrThrow(TABLE_NAME, null, values);

        Ballistic insertedEntity = new Ballistic.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();

        return insertedEntity;
    }

    @Override
    public Ballistic update(Ballistic entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_REFERENCE, entity.getReference());
        values.put(COLUMN_TYPE, entity.getType());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Ballistic delete(Ballistic entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Ballistic> findAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<Ballistic> bal = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Ballistic ballistic = new Ballistic.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .reference(cursor.getString(cursor.getColumnIndex(COLUMN_REFERENCE)))
                        .type(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)))
                        .build();

                bal.add(ballistic);
            } while (cursor.moveToNext());
        }
        return bal;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
