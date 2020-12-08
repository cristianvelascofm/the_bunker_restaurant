package model;

import model.Person;

public class Client extends Person {
    
    private String note;

    public Client(String note, int idPerson, String name, String lastName, String gender, String documentType, String documentNumber, String email, String login, String password) {
        super(idPerson, name, lastName, gender, documentType, documentNumber, email, login, password);
        this.note = note;
    }

    public Client() {
        
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    

    

    

    
    
}
