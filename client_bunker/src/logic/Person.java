package logic;


public class Person {
    
    private int idPerson;
    private String name;
    private String lastName;
    private String gender;
    private String documentType;
    private String documentNumber;
    private String email;
    private String login;
    private String password;

    public Person(int idPerson, String name, String lastName, String gender, String documentType, String documentNumber, String email, String login, String password) {
        this.idPerson = idPerson;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
        this.login = login;
        this.password = password;
    }
    
    public Person(){
        
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
