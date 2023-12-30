import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Аннотация для пометки методов обработки данных
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DataProcessor {
}

class DataManager {
    private List<Object> processors; // Список зарегистрированных обработчиков данных
    private List<Object> data; // Загруженные данные

    DataManager() {
        this.processors = new ArrayList<>();
        this.data = new ArrayList<>();
    }

    // Регистрация обработчика данных с аннотацией @DataProcessor
    void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    // Загрузка данных из исходного источника
    void loadData(String source) {
        // Логика загрузки данных
        // Пример: чтение из файла, базы данных или сетевого ресурса
        data.add("Data item 1");
        data.add("Data item 2");
        data.add("Data item 3");
        data.add("Data item 4");
        data.add("Data item 5");
    }

    // Многопоточная обработка данных с использованием методов аннотированных @DataProcessor
    void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(processors.size());

        for (Object processor : processors) { //проходим по каждому обработчику данных и его методам
            Class<?> processorClass = processor.getClass();

            for (java.lang.reflect.Method method : processorClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) { //если метод помечен аннотацией DataProcessor
                    executorService.execute(() -> { //он выполняет его в отдельном потоке с помощью метода execute пула исполнителей
                        try {
                            method.invoke(processor, data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }

        // Завершаем работу пула потоков
        executorService.shutdown(); // метод не позволяет добавлять новые задачи в пул, но уже запущенные задачи будут выполнены.
        while (!executorService.isTerminated()) {
            // Ожидаем завершения обработки данных
        }
    }

    // Сохранение обработанных данных в новый источник
    void saveData(String destination) {
        // Логика сохранения данных
        // Пример: запись в файл, базу данных или сетевой ресурс
        System.out.println("Saving data to " + destination);
        for (Object item : data) {
            System.out.println("Saving item: " + item.toString());
        }
    }
}

class DataFilter {
    @DataProcessor
    public static void filterData(List<Object> data) {
        // Логика фильтрации данных
        // Пример: удаление некоторых элементов из списка
        data.removeIf(item -> item.toString().endsWith("2"));
    }
}

class DataTransformer {
    @DataProcessor
    public static void transformData(List<Object> data) {
        // Логика трансформации данных
        // Пример: преобразование каждого элемента списка
        for (int i = 0; i < data.size(); i++) {
            data.set(i, "Transformed " + data.get(i));
        }
    }
}

class DataAggregator {
    @DataProcessor
    public static void aggregateData(List<Object> data) {
        // Логика агрегации данных
        // Пример: объединение всех элементов в одну строку
        StringBuilder result = new StringBuilder();
        for (Object item : data) {
            result.append(item).append(" ");
        }
        data.clear();
        data.add(result.toString().trim());
    }
}

