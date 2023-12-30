import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Создаем пул потоков с фиксированным размером
        int numThreads = Runtime.getRuntime().availableProcessors(); // Количество доступных процессорных ядер
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // Разделяем массив на равные части
        int chunkSize = array.length / numThreads; // длина массива на количество потоков
        int startIndex = 0; // индекс начала обрабатываемого куска

        for (int i = 0; i < numThreads; i++) {
            int endIndex = startIndex + chunkSize;
            if (i == numThreads - 1) { // является ли текущий кусок последним
                endIndex = array.length; // Для последнего куска учитываем возможную неравную длину
            }

            int[] chunk = Arrays.copyOfRange(array, startIndex, endIndex);

            // Запускаем обработку части массива в отдельном потоке
            executorService.submit(() -> processChunk(chunk));

            startIndex = endIndex; //Обновляем индекс начала следующего куска для следующей итерации цикла
        }

        // Завершаем работу пула потоков
        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); //блокирует выполнение текущего потока до тех пор, пока все потоки не завершат свою работу
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Результаты обработки будут складываться в главном потоке
        // TODO: обработать результаты, суммировать их или выполнить другие операции

        System.out.println("Обработка массива завершена");
    }

    private static void processChunk(int[] chunk) {
        // Обработка части массива
        // TODO: выполнять нужные операции над элементами массива

        // Пример: вывод элементов в отдельном потоке
        for (int num : chunk) {
            System.out.println("Элемент: " + num + " (поток: " + Thread.currentThread().getName() + ")");
        }
    }
}
