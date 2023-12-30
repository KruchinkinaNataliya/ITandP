import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixProcessingExample {
    private static final int MATRIX_SIZE = 5;
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        // Создаем массив для хранения результатов каждой строки
        int[] results = new int[MATRIX_SIZE];

        // Запускаем потоки для обработки строк матрицы
        for (int row = 0; row < MATRIX_SIZE; row++) {
            final int currentRow = row;

            executorService.submit(() -> {
                int maxElement = Integer.MIN_VALUE; //тут будем хранить наибольший элемент в текущей строке матрицы

                // Обрабатываем текущую строку матрицы
                for (int col = 0; col < MATRIX_SIZE; col++) {
                    int currentElement = matrix[currentRow][col];
                    // Выполняем нужные операции с элементом

                    if (currentElement > maxElement) {
                        maxElement = currentElement;
                    }
                }

                // Сохраняем результат в массиве
                results[currentRow] = maxElement;
            });
        }

        // Завершаем работу пула потоков
        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Находим наибольший элемент среди результатов
        int maxResult = Integer.MIN_VALUE;
        for (int result : results) {
            if (result > maxResult) {
                maxResult = result;
            }
        }

        System.out.println("Наибольший элемент матрицы: " + maxResult);
    }
}
