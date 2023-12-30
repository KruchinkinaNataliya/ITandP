import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt"; // Путь и имя исходного файла
        String targetFile = "target.txt"; // Путь и имя целевого файла

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успешно скопирован");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}
