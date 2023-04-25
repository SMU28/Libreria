package exercice.libreria.data;

import android.content.ContentValues;
import android.database.Cursor;
import static exercice.libreria.data.PersonaContrac.PersonaEntry;


public class Persona {
    private int idPersona;
    private String namePersona;
    private String passwordPersona;

    public Persona(int idPersona, String namePersona, String passwordPersona) {
        this.idPersona = idPersona;
        this.namePersona = namePersona;
        this.passwordPersona = passwordPersona;
    }

    public Persona(Cursor cursor) {
        idPersona = cursor.getInt(cursor.getColumnIndex(PersonaEntry.ID));
        namePersona = cursor.getString(cursor.getColumnIndex(PersonaEntry.NAME));
        passwordPersona = cursor.getString(cursor.getColumnIndex(PersonaEntry.PASSWORD));

    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(PersonaContrac.PersonaEntry.ID, idPersona);
        values.put(PersonaEntry.NAME, namePersona);
        values.put(PersonaEntry.PASSWORD, passwordPersona);
        return values;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNamePersona() {
        return namePersona;
    }

    public void setNamePersona(String namePersona) {
        this.namePersona = namePersona;
    }

    public String getPasswordPersona() {
        return passwordPersona;
    }

    public void setPasswordPersona(String passwordPersona) {
        this.passwordPersona = passwordPersona;
    }
}

