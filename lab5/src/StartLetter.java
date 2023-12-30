import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        // Ввод буквы
        System.out.print("Введите букву для поиска слов: ");
        String startingLetter = scanner.nextLine();

        String regex = "\\b" + startingLetter + "\\w*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Вывод найденных слов на экран
        System.out.println("Слова, начинающиеся с буквы '" + startingLetter + "':");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

