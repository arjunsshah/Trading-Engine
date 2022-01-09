package src.main.java;

public class Trade {
    private String takerOrderID;
    private String makerOrderID;
    private int amount;
    private double price;

    public Trade(String takerOID, String makerOID, int amt, double p) {
        takerOrderID = takerOID;
        makerOrderID = makerOID;
        amount = amt;
        price = p;
    }

    // Make Getters
    public String getTakerOrderID() {
        return takerOrderID;
    }

    public String getMakerOrderID() {
        return makerOrderID;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }
}