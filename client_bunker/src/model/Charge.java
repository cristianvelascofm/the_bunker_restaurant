package model;



public class Charge {
    
    private int idCharge;
    private int idOrder;
    private int idDish;
    private int quantityDish;
    private double salePriceDish;

    public Charge(int idCharge, int idOrder, int idDish, int quantityDish, double salePriceDish) {
        this.idCharge = idCharge;
        this.idOrder = idOrder;
        this.idDish = idDish;
        this.quantityDish = quantityDish;
        this.salePriceDish = salePriceDish;
    }
    
    public Charge(){
        
    }

    public int getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(int idCharge) {
        this.idCharge = idCharge;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public int getQuantityDish() {
        return quantityDish;
    }

    public void setQuantityDish(int quantityDish) {
        this.quantityDish = quantityDish;
    }

    public double getSalePriceDish() {
        return salePriceDish;
    }

    public void setSalePriceDish(double salePriceDish) {
        this.salePriceDish = salePriceDish;
    }
    
    
    
    
}
