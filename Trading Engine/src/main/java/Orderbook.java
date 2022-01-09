package src.main.java;

import java.util.ArrayList;

public class Orderbook extends OrderbookLimitOrder {
    private ArrayList<Order> BuyOrders;
    private ArrayList<Order> SellOrders;

    public Orderbook() {
        BuyOrders = new ArrayList<Order>();
        SellOrders = new ArrayList<Order>();

    }

    public void addBuyOrder(Order order) {

        int index = 0;
        if (BuyOrders.size() != 0) {
            for (int i = BuyOrders.size() - 1; i >= 0; i--) {
                if (BuyOrders.get(i).getPrice() < order.getPrice()) {
                    index = i;
                    break;
                }
            }
        }

        if (BuyOrders.size() == 0) {
            BuyOrders.add(order);
        } else {
            BuyOrders.add(index, order);
        }

    }

    public void addSellOrder(Order order) {
        int index = 0;
        if (SellOrders.size() != 0) {
            for (int i = SellOrders.size() - 1; i >= 0; i--) {
                if (SellOrders.get(i).getPrice() > order.getPrice()) {
                    index = i;
                    break;
                }
            }
        }

        if (SellOrders.size() == 0) {
            SellOrders.add(order);
        } else {
            SellOrders.add(index, order);
        }
    }

    public void removeBuyOrder(int index) {
        BuyOrders.remove(index);
    }

    public void removeSellOrder(int index) {
        SellOrders.remove(index);
    }

    public ArrayList<Order> getBuyOrders() {
        return BuyOrders;
    }

    public ArrayList<Order> getSellOrders() {
        return SellOrders;
    }
}