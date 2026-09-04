package org.example.pharmacy_medication_management_crud.models;

public class Medication {
    private long id;
    private String name;
    private int quantity;
    private int batch;
    private double unityPrice;

    public Medication(String name, int quantity, int batch, double unityPrice){
        this.name = name;
        this.quantity = quantity;
        this.batch = batch;
        this.unityPrice = unityPrice;
    } // end of constructor

    public long getId () {
        return id;
    } // end of id getter

    public String getName(){
        return name;
    } // end of name getter

    public void setName(String name){
        this.name = name;
    } // end of name setter

    public int getQuantity() {
        return quantity;
    } // end of quantity getter

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } // end of quantity setter

    public int getBatch() {
        return batch;
    } // end of batch getter

    public void setBatch(int batch) {
        this.batch = batch;
    } // end of batch setter

    public double getUnityPrice() {
        return unityPrice;
    } // end of unity price getter

    public void setUnityPrice(double unityPrice) {
        this.unityPrice = unityPrice;
    } // end of unity price setter

} // end of class structure
