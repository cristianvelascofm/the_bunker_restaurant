package model;

import java.sql.Date;




public class Session {
    
    private int idSession;
    private int idPerson;
    private Date dateLogin;

    public Session(int idSession, int idPerson, Date dateLogin) {
        this.idSession = idSession;
        this.idPerson = idPerson;
        this.dateLogin = dateLogin;
    }
    
    public Session(){
        
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public Date getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }
    
    
}
