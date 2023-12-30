import java.util.*;

public class SalesTracker {
    private Map<String, Integer> sales; //товар кол-во

    public SalesTracker() { //конструктор
        sales = new HashMap<>();
    }

    public void addSale(String item, int quantity) {
        sales.put(item, sales.getOrDefault(item, 0) + quantity);
    }

    public void printSales() {
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Quantity sold: " + entry.getValue());
        }
    }

    public double getTotalSales() { //общее сумма продаж
        double totalSales = 0;
        for (int quantity : sales.values()) {
            totalSales += quantity;
        }
        return totalSales;
    }

    public String getMostPopularItem() {
        int maxQuantity = 0;
        String popularItem = "";
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                maxQuantity = entry.getValue();
                popularItem = entry.getKey();
            }
        }
        return popularItem;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSale("Apple", 5);
        tracker.addSale("Banana", 3);
        tracker.addSale("Apple", 2);
        tracker.addSale("Orange", 10);
        tracker.addSale("Banana", 7);

        tracker.printSales();

        double totalSales = tracker.getTotalSales();
        System.out.println("Total Sales: " + totalSales);

        String popularItem = tracker.getMostPopularItem();
        System.out.println("Most Popular Item: " + popularItem);
    }
}

