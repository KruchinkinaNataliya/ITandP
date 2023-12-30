public class Main {
    public static void main(String[] args) {

        //Создание объектов типа Contact
        Product product = new Product("Bananas","78 руб", "150 шт");

        Product product1 = new Product();

        Product product2 = new Product("Cucumbers", "35 руб","205 шт");

        Product product3 = new Product("Tomatoes","50 руб","260 шт");

        //Создание экземпляра класса
        HashTable<String,Product> hashTable = new HashTable<>();

        //Вывод информации об экземпляое класса
        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.size());

        //Запись данных в hashtable
        hashTable.put("4 606453 849072", product);
        hashTable.put("9 0123456789", product1);
        hashTable.put("A1234567890A", product2);
        hashTable.put("5 012345 678900", product3);
        hashTable.put("5 012345 678905", new Product());
        hashTable.put("5 012345 678901", new Product());
        hashTable.put("5 012345 678234", new Product());

        hashTable.getAll();

        //Вывод данных о hashtable
        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.size());

        //Получение данных по ключу
        System.out.println(hashTable.get("5 012345 678900"));

        //Удаление значения по ключу
        System.out.println(hashTable.size());
        hashTable.remove("5 012345 678900");
        System.out.println(hashTable.get("5 012345 678900"));
        System.out.println(hashTable.size());
    }
}
