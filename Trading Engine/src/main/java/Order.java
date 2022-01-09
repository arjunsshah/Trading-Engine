package src.main.java;

public class Order {
    private int amount;
    private double price;
    private String ID;
    private int side;

    public Order(int amt, double p, String id, int orderSide) {
        amount = amt;
        price = p;
        ID = id;
        side = orderSide;
    }

    // Getters
    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public String getID() {
        return ID;
    }

    public int getSide() {
        return side;
    }

    // Setters
    public void setAmount(int n) {
        amount = n;
    }
}