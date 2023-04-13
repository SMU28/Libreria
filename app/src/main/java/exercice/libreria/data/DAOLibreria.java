package exercice.libreria.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static exercice.libreria.data.PersonaContrac.PersonaEntry;

import androidx.annotation.Nullable;

public class DAOLibreria extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Libreria.db";

    public DAOLibreria(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PersonaEntry.TABLE_NAME + " ("
                +PersonaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PersonaEntry.ID + " INTEGER NOT NULL,"
                + PersonaEntry.NAME + " TEXT NOT NULL,"
                + PersonaEntry.PASSWORD + " TEXT NOT NULL,"
                + "UNIQUE (" + PersonaEntry.ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
