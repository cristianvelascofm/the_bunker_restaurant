package model;



public class Employee extends Person {
    
    private String employeeType;
    private String state;

    public Employee(String employeeType, String state, int idPerson, String name, String lastName, String gender, String documentType, String documentNumber, String email, String login, String password) {
        super(idPerson, name, lastName, gender, documentType, documentNumber, email, login, password);
        this.employeeType = employeeType;
        this.state = state;
    }

    public Employee() {
        
    }

    
    
    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    

    
    
    
}
