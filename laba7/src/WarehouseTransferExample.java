import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class WarehouseTransferExample {
    private static final int MAX_WEIGHT = 150;
    private static final int NUM_WORKERS = 3;

    public static void main(String[] args) {
        // Создаем список товаров для переноса с их весами
        List<Item> items = new ArrayList<>();
        items.add(new Item("Товар1", 50));
        items.add(new Item("Товар2", 70));
        items.add(new Item("Товар3", 30));
        items.add(new Item("Товар4", 60));
        items.add(new Item("Товар5", 40));

        // Создаем список задач CompletableFuture для каждого товара
        List<CompletableFuture<Void>> transferTasks = new ArrayList<>();

        // Создаем исполнителя для работы с потоками
        for (Item item : items) {
            CompletableFuture<Void> task = CompletableFuture.runAsync(() -> transferItem(item));
            transferTasks.add(task);
        }

        // Ожидаем завершения всех задач
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                transferTasks.toArray(new CompletableFuture[0]));

        // По окончании всех задач выводим сообщение
        allTasks.thenRun(() -> System.out.println("Перенос товаров завершен"));
    }

    private static void transferItem(Item item) {
        System.out.println("Начало переноса товара: " + item.getName());
        System.out.println("Вес товара: " + item.getWeight() + " кг");

        try {
            Thread.sleep(1000); // Эмуляция времени переноса товара
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершен перенос товара: " + item.getName());
    }

    private static class Item {
        private String name;
        private int weight;

        public Item(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }
    }
}
