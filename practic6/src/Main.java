import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.",
                "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("...................");

        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));
        System.out.println("...................");

        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("...................");

        System.out.println(Arrays.toString(twoProducts(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProducts(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45))); // мб ошибка в примере тк разрыв по индексам м/у 15 и 3 меньше чем 3 15 или 9 5
        System.out.println(Arrays.toString(twoProducts(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProducts(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProducts(new int[]{100, 12, 4, 1, 2}, 15)));
        System.out.println("...................");

        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println("...................");

        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println("...................");

        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));
        System.out.println(pilishString(""));
        System.out.println(pilishString("CANIMAKEAGUESSNOW"));
        System.out.println("...................");

        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));
        System.out.println(generateNonconsecutive("5 / 2"));
        System.out.println(generateNonconsecutive("-(-2)"));
        System.out.println("...................");

        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(isValid("abcba"));
        System.out.println("...................");

        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));

    }

    public static String hiddenAnagram(String sentence, String anagram) { // task 1
        Pattern specialSymbolsHandler = Pattern.compile("[ .,?!\\-<>~@#$%^&*()1234567890]");
        Matcher senetnceMatcher = specialSymbolsHandler.matcher(sentence);
        Matcher anagramMatcher = specialSymbolsHandler.matcher(anagram);
        sentence = senetnceMatcher.replaceAll("").toLowerCase();
        anagram = anagramMatcher.replaceAll("").toLowerCase();
        char[] anagramSymbols = anagram.toCharArray();
        Arrays.sort(anagramSymbols);
        for (int i = 0; i <= sentence.length() - anagram.length(); i++) {
            String substring = sentence.substring(i, i + anagram.length());
            char[] currentSymbols = substring.toCharArray(); // текущая подстрока предложения в массив символов
            Arrays.sort(currentSymbols);
            if (Arrays.equals(currentSymbols, anagramSymbols)) {
                return substring;
            }
        }
        return "not found";
    }

    public static String[] collect(String str, int n) { // task 2
        if (str.length() < n) {
            return new String[]{};
        }
        String[] results = Arrays.copyOf(collect(str.substring(n), n), collect(str.substring(n), n).length + 1); // массив строк results, который является копией результатов вызова функции collect для подстроки str.substring(n) с параметром n.
        results[results.length - 1] = str.substring(0, n); //первые n символов строки str добавляются в массив results на последней позиции
        Arrays.sort(results);
        return results;
    }

    public static StringBuilder nicoCipher(String message, String key) { // task 3
        char[] keyLetters = key.toCharArray(); // создается массив символов keyLetters, содержащий символы строки key.
        Map<Character, LinkedList<Character>> cipher = new HashMap<>(); //используется в качестве шифра для хранения символов
        StringBuilder res = new StringBuilder(); //для сохранения зашифрованного сообщения
        StringBuilder messageBuilder = new StringBuilder(message);
        while (messageBuilder.length() % keyLetters.length != 0) { //длина сообщения/длина массива (кратность)
            messageBuilder.append(" "); //чтобы выравнить длину до ровной матрицы
        }
        message = messageBuilder.toString();
        for (int i = 0; i < keyLetters.length; i++) {
            char keyLetter = keyLetters[i];
            LinkedList<Character> letters = new LinkedList<>(); // хранит символы сообщения, связанные с текущим символом keyLetter.
            int j = i; //j индекс буквы сообщения, i индекс массива ключа (цифры)
            do {
                letters.add(message.charAt(j));
                j += keyLetters.length;
            } while (j < message.length()); //когда j превысит длину сообщения, все равно нужно добавить последнюю букву
            cipher.put(keyLetter, letters);
        }
        int rowsCount = cipher.get(keyLetters[0]).size(); //длина символов по ключу (по вертикали)
        Arrays.sort(keyLetters); //сортируем массив ключа
        int index = 0;
        while (index < rowsCount) { //индекс символов по ключу (по вертикали) меньше длины символов по ключи
            for (char letter : keyLetters) { //перебор ключей
                res.append(cipher.get(letter).get(index)); //по ключу letter получаем значение по индексу
            }
            index++;
        }
        return res;
    }

    public static int[] twoProducts(int[] arr, int n) { // task 4
        int[] res = new int[2]; //массив целых чисел с размером 2
        int minDiff = arr.length;
        for (int i = 0; i < arr.length - 1; i++) { //без повторений
            for (int j = i; j < arr.length; j++) {
                if (arr[i] * arr[j] == n && j - i < minDiff) { //minDiff минимальная разница
                    minDiff = j - i;
                    res[0] = arr[i];
                    res[1] = arr[j];
                }
            }
        }
        return res;
    }

    public static int[] isExact(int n) { // task 5
        int[] res = isExact(1, 1, n); // массив целых чисел res, получающий результат вызова метода isExact с аргументами 1, 1, n.
        return res[0] == n? new int[]{n, res[1]}: new int[]{};
    }

    public static int[] isExact(int factorial, int addition, int border) {
        if (factorial >= border) {
            return new int[] {factorial, addition};
        }
        return isExact(factorial * (addition + 1), addition + 1, border); // увеличиваем значения факториала и добавляем до тех пор, пока не будет найдено число, для которого факториал равен n.
    }

    public static String fractions(String num) { // task 6
        int startPow = num.indexOf("(") - num.indexOf(".") - 1; // часть от . до ( в которую нужно возвести 10 при случаях, когда после точки сразу период 1.1(2) -> 11.(2)
        int endPow = num.substring(num.indexOf("."), num.length() - 1).length() - 2; // часть от . до конца всех цифр строки, чтобы узнать степень 10 для выражения х
        int partBeforePeriod = Integer.parseInt(num.substring(0, num.indexOf("(")).replace(".", "")); // часть до периода 1.1(2) -> часть после 11.(2)
        int newNum = Integer.parseInt(num.replace(".", "").replace("(", "").replace(")", "")); // число доведенное до целого 1.(123) -> 1123.(123)
        int difference = newNum - partBeforePeriod; // числитель
        int denominator = (int)(Math.pow(10, endPow) - Math.pow(10, startPow)); // (знаменатель) разница между двумя уравнениями для х
        for (int i = Math.min(denominator, difference); i >= 2; i--) { // сокращение дроби по максимуму
            if (denominator % i == 0 && difference % i == 0) {
                denominator /= i;
                difference /= i;
                break;
            }
        }
        return difference + "/" + denominator;
    }

    public static StringBuilder pilishString(String str) { // task 7
        String PI = String.valueOf(Math.PI).replace(".", ""); //значение числа PI в формате строки. Затем из этой строки удаляется символ "."
        StringBuilder res = new StringBuilder();
        int pIndex = 0; // для обращения к символам числа PI
        int strIndex = 0; // для обращения к символам строки str
        while (strIndex < str.length()) {
            int addition = PI.charAt(pIndex) - '0'; // числовое значение текущего символа числа PI
            if (strIndex + addition <= str.length()) {
                //добавление подстроки str с индексами от strIndex до strIndex + addition включительно. Затем добавляется пробел с помощью метода append(" "). Это собирает часть строки str длиной addition и добавляет ее к результату.
                res.append(str, strIndex, strIndex + addition).append(" ");
            } else {
                StringBuilder lastPart = new StringBuilder(str.substring(strIndex)); //представляет последнюю часть строки str начиная с индекса strIndex и до конца строки
                while (lastPart.length() < addition) {
                    //добавить последний символ строки str к lastPart. Это позволяет заполнить недостающие символы в lastPart повторением последнего символа строки str
                    lastPart.append(str.charAt(str.length() - 1));
                }
                res.append(lastPart);
            }
            strIndex += addition; //перемещает индекс для следующей части строки str, которая будет обрабатываться
            pIndex++;
        }
        return res;
    }

    //8 таск
    public static String generateNonconsecutive(String str) {
        Pattern bracketsFinder = Pattern.compile("\\(.*\\)");  //показывает, что ищем выражение в скобках
        Matcher bracketsMatcher = bracketsFinder.matcher(str); //ищем
        while (bracketsMatcher.find()) {
            String chander = bracketsMatcher.group(); //выражение в скобках
            str = bracketsMatcher.replaceFirst(generateNonconsecutive(chander.substring(1, chander.length() - 1)));
            //переопределяем строку, делая замену первого вхождения в рекурсии, считая выражение в скобках
        }
        //Pattern fuckingDoubleMinus = Pattern.compile("- -");
        str = str.replace("- -", "+ ");
        str = str.replace("--", "+ ");
        Pattern multiplication = Pattern.compile("-?\\d* (\\*||/) -?\\d*"); //показывает, что ищем выражение в * и /
        while (str.contains("/") || str.contains("*")) {
            Matcher multiplicationMatcher = multiplication.matcher(str); //ищем
            if (multiplicationMatcher.find()) {
                String[] expression = multiplicationMatcher.group().split(" "); //делаем массив, разделяющий выражение по пробелам
                if (expression[1].equals("*")) {
                    str = multiplicationMatcher.replaceFirst(String.valueOf(Double.parseDouble(expression[0]) * Double.parseDouble(expression[2])));
                    //заменяет найденное выражение на 0 индекс * 2 индекс, переводя в интеджер
                } else {
                    if (expression[2].equals("0")) {
                        return "division by zero";
                    }
                    str = multiplicationMatcher.replaceFirst(String.valueOf(Double.parseDouble(expression[0]) / Double.parseDouble(expression[2])));
                }
            } else {
                break;
            }
        }
        Pattern sumOrSubtraction = Pattern.compile("-?\\d* (\\+||-) -?\\d*");
        //2 * -(-2)
        //-(-2) * 2
        while (str.contains("+") || str.contains("-")) {
            Matcher sumOrSubtrationMatcher = sumOrSubtraction.matcher(str);
            if (sumOrSubtrationMatcher.find()) {
                String[] expression = sumOrSubtrationMatcher.group().split(" ");
                if (expression[1].equals("+")) {
                    str = sumOrSubtrationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])));
                } else {
                    str = sumOrSubtrationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) - Integer.parseInt(expression[2])));
                }
            } else {
                break;
            }

        }
        if (str.startsWith("+")) {
            str = str.replaceFirst("\\+", "");
        }
        return str.trim(); //trim убирает лишние пробелы в начале и конце строки
    }

    public static String isValid(String str) { // task 9
        HashMap<Character, Integer> counts = new HashMap<>(); //для подсчета количества вхождений каждого символа в строке str. Ключами в HashMap являются символы, а значениями - количество вхождений.
        int maxCount = Integer.MIN_VALUE; //максимальное количество вхождений символов
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i); // извлекается текущий символ из строки str по i
            if (counts.containsKey(currentChar)) {
                counts.put(currentChar, counts.get(currentChar) + 1);
                minCount = Math.min(minCount, counts.get(currentChar));
            } else {
                counts.put(currentChar, 1);
            }
            maxCount = Math.max(maxCount, counts.get(currentChar)); // oбновляется значение переменной maxCount на основе текущего значения счетчика вхождений символа currentChar.
        }
        int diff = 0; //для подсчета различных (неравных) значений счетчиков вхождений символов
        for (Map.Entry<Character, Integer> letter: counts.entrySet()) { //запускается цикл for, который перебирает каждую запись (ключ-значение) в HashMap counts
            if (letter.getValue() != minCount) { //если значение счетчика вхождений символа, связанного с текущей записью, не равно значению переменной minCount.
                diff++;
            }
        }
        return ((minCount == maxCount || maxCount - minCount == 1) && diff <= 1)? "YES": "NO";
    }

    public static StringBuilder findLCS(String s1, String s2) { // task 10
        int[][] dp = new int[s1.length() + 1][s2.length() + 1]; // создается таблица
        StringBuilder lcs = new StringBuilder();

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // если символы одинаковые
                    dp[i][j] = dp[i - 1][j - 1] + 1; // прибавляем к значению по диагонали 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // выбираем максимальное из столбца или строки
                }
            }
        }

        int i = s1.length(), j = s2.length(); //когда обратно пойдем

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // добавляем только равные символы остальные не интересуют
                lcs.append(s1.charAt(i - 1)); // если символы равны, символ добавляется в объект lcs
                i--; //столбец
                j--; //строка
            } else if (dp[i - 1][j] > dp[i][j - 1]) { // идем наверх
                i--;
            } else {
                j--; // влево
            }
        }

        return lcs.reverse();
    }

}
