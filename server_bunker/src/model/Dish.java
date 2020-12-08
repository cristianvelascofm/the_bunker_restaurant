package model;



public class Dish {
    
    private int idDish;//código único
    private int idCategory; 
    private String dishName;
    private double dishPrice;
    private String photo;

    public Dish(int idDish, int idCategory, String dishName, double dishPrice, String photo) {
        this.idDish = idDish;
        this.idCategory = idCategory;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.photo = photo;
    }

    public Dish(){
        
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
    
    
    
}


