package exercice.libreria.data;

public class Persona {
    private int idPersona;
    private String namePersona;
    private String passwordPersona;

    public Persona(int idPersona, String namePersona, String passwordPersona) {
        this.idPersona = idPersona;
        this.namePersona = namePersona;
        this.passwordPersona = passwordPersona;
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

