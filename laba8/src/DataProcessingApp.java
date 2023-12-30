public class DataProcessingApp {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        // Регистрация обработчиков данных
        dataManager.registerDataProcessor(new DataFilter());
        dataManager.registerDataProcessor(new DataTransformer());
        dataManager.registerDataProcessor(new DataAggregator());

        // Загрузка данных из исходного источника
        dataManager.loadData("Source");

        // Многопоточная обработка данных
        dataManager.processData();

        // Сохранение обработанных данных в новый источник
        dataManager.saveData("Destination");
    }
}

