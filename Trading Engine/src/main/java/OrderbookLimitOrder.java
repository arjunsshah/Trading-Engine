package src.main.java;

import java.util.ArrayList;

public class OrderbookLimitOrder {
    public ArrayList<Trade> Process(Order order, Orderbook book) {
        if (order.getSide() == 0) {
            return book.ProcessLimitBuy(order, book);
        } else {
            return book.ProcessLimitSell(order, book);
        }
    }

    public ArrayList<Trade> ProcessLimitBuy(Order order, Orderbook book) {
        ArrayList<Trade> Trades = new ArrayList<>();
        int n = book.getSellOrders().size();
        // Check if price is met in sellOrders

        if (n == 0) {
            book.addBuyOrder(order);
        } else if (book.getSellOrders().get(n - 1).getPrice() <= order.getPrice()) {
            for (int i = n - 1; i >= 0; i--) {
                Order sellOrder = book.getSellOrders().get(i);
                if (sellOrder.getPrice() > order.getPrice()) {
                    break;
                }
                // Fill entire order
                if (sellOrder.getAmount() >= order.getAmount()) {
                    Trade trade = new Trade(order.getID(), sellOrder.getID(), sellOrder.getAmount(),
                            sellOrder.getPrice());
                    Trades.add(trade);
                    sellOrder.setAmount(sellOrder.getAmount() - order.getAmount());
                    if (sellOrder.getAmount() == 0) {
                        book.removeSellOrder(i);
                    }
                    return Trades;
                }
                // Fill partial order
                if (sellOrder.getAmount() < order.getAmount()) {
                    Trade trade = new Trade(order.getID(), sellOrder.getID(), sellOrder.getAmount(),
                            sellOrder.getPrice());
                    Trades.add(trade);
                    order.setAmount(order.getAmount() - sellOrder.getAmount());
                    book.removeSellOrder(i);
                    continue;
                }
            }
        }
        // Add remaining orders to list and return list of trades
        // book.addBuyOrder(order);
        return Trades;
    }

    public ArrayList<Trade> ProcessLimitSell(Order order, Orderbook book) {
        ArrayList<Trade> Trades = new ArrayList<>();
        int n = book.getBuyOrders().size();
        // Check if price is met in sellOrders
        if (n == 0) {
            book.addSellOrder(order);
        } else if (book.getBuyOrders().get(n - 1).getPrice() <= order.getPrice()) {
            for (int i = n - 1; i >= 0; i--) {
                Order buyOrder = book.getBuyOrders().get(i);
                if (buyOrder.getPrice() < order.getPrice()) {
                    break;
                }
                // Fill entire order
                if (buyOrder.getAmount() >= order.getAmount()) {
                    Trade trade = new Trade(order.getID(), buyOrder.getID(), buyOrder.getAmount(),
                            buyOrder.getPrice());
                    Trades.add(trade);
                    buyOrder.setAmount(buyOrder.getAmount() - order.getAmount());
                    if (buyOrder.getAmount() == 0) {
                        book.removeBuyOrder(i);
                    }
                    return Trades;
                }
                // Fill partial order
                if (buyOrder.getAmount() < order.getAmount()) {
                    Trade trade = new Trade(order.getID(), buyOrder.getID(), buyOrder.getAmount(),
                            buyOrder.getPrice());
                    Trades.add(trade);
                    order.setAmount(order.getAmount() - buyOrder.getAmount());
                    book.removeBuyOrder(i);
                    continue;
                }
            }
        }
        // Add remaining orders to list and return list of trades
        book.addSellOrder(order);
        return Trades;
    }
}
