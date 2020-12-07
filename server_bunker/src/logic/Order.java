package logic;

import java.sql.Date;

public class Order {

    private int idOrder;
    private int idClient;
    private int idEmployee;
    private Date dateOrder;
    private double ivaOrder;
    private double totalOrder;
    private String state;

    public Order(int idOrder, int idClient, int idEmployee, Date dateOrder, double ivaOrder, double totalOrder, String state) {
        this.idOrder = idOrder;
        this.idClient = idClient;
        this.idEmployee = idEmployee;
        this.dateOrder = dateOrder;
        this.ivaOrder = ivaOrder;
        this.totalOrder = totalOrder;
        this.state = state;
    }
    
    public Order(){
        
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public double getIvaOrder() {
        return ivaOrder;
    }

    public void setIvaOrder(double ivaOrder) {
        this.ivaOrder = ivaOrder;
    }

    public double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    
    
    
    
}
