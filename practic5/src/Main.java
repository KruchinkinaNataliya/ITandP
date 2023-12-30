import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("...................");
        System.out.println(spiderVsFly("A3", "H3"));
        System.out.println(spiderVsFly("G2", "B4"));
        System.out.println(spiderVsFly("G4", "C4"));
        System.out.println(spiderVsFly("C2", "A4"));
        System.out.println("...................");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println("...................");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println("...................");
        System.out.println(sumUp(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sumUp(new int[]{1, 2, 3, 7, 9}));
        System.out.println(sumUp(new int[]{10, 9, 7, 2, 8}));
        System.out.println(sumUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println("...................");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println("...................");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println("...................");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println("...................");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println("...................");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }

    //1 Создайте функцию, которая возвращает true, если две строки имеют один и тот же буквенный шаблон, и false в противном случае.
    public static boolean sameLetterPattern(String x, String y) {
        if (x.length() != y.length()) return false;
        Map<Character, Character> characterMap = new HashMap<>();
        for (int i = 0; i < x.length(); i++) {
            if (!characterMap.containsKey(x.charAt(i))) {
                characterMap.put(x.charAt(i), y.charAt(i));
            } else {
                if (!characterMap.get(x.charAt(i)).equals(y.charAt(i))) return false;
            }
        }
        return true;
    }

    //    2 Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и радиалами, помеченными по часовой стрелке сверху как A-H.
    //
    //Создайте функцию, которая принимает координаты паука и мухи и возвращает кратчайший путь для паука, чтобы добраться до мухи.
    public static String spiderVsFly(String spider, String fly) {
        if (spider.equals(fly)) return spider;
        String fin = spider;
        char radSpider = spider.charAt(0); //извлекаем данные о радиусе паука
        int cirSpider = Integer.parseInt(String.valueOf(spider.charAt(1))); //об окружности
        char radFly = fly.charAt(0);
        int cirFly = Integer.parseInt(String.valueOf(fly.charAt(1)));
        if (cirFly > cirSpider) {
            String[] points = spiderVsFly(fly, spider).split("-");
            String ret = "";
            for (String p : points) {
                if (ret.equals("")){
                    ret = p;
                }else ret = p + "-" + ret;
            }
            return ret;
        }
        while (cirSpider > cirFly) {
            cirSpider--;
            fin = fin + "-" + radSpider + cirSpider;
        }
        double cent = cirSpider + cirFly; //через центр

        int min = 0;
        if ((radSpider == 'H' && ('A' <= radFly && radFly <= 'D')) || (radSpider == 'A' && ('D' <= radFly && radFly <= 'H'))) //соседние углы
            min = Math.min(Math.abs(radFly - 'A' + 1), Math.abs(radSpider - 'D' + 1)); //минимальное расстояние до символа 'A' или 'D' от radFly
        else min = Math.abs(radSpider - radFly); // абсолютная разница между radSpider и radFly.
        double circus = 0.707 * cirSpider * (min); //расстояние  м/у точкой на окружности паука и и точкой на окруж мухи, которое паук может пройти за 1 оборот по окружности

        if (cent < circus) { //если через центр быстрее
            while (cirSpider > 1) {
                cirSpider--; //идем в центр
                fin = fin + "-" + radSpider + cirSpider;
            }
            fin += "-A0"; //как только дошли до первого. нулевой круг
            cirSpider = 0;
            while (cirSpider < cirFly) { //идем наверх
                cirSpider++;
                fin = fin + "-" + radFly + cirSpider;
            }
        } else { //если по кругу быстрее
            String left = "";
            String right = "";
            char radSpR = radSpider; //сохраняется радиус паука, чтобы не изменять исходное значение radSpider
            //right
            while (radSpR != radFly) {
                if (radSpR == 'H') {
                    radSpR = 'A';
                } else radSpR++; //берем следующую буквы
                right = right + "-" + radSpR + cirSpider;
            }
            //left
            while (radSpider != radFly) {
                if (radSpider == 'A') {
                    radSpider = 'H';
                } else radSpider--;
                left = left + "-" + radSpider + cirSpider;
            }

            if (left.length() < right.length()) {
                fin = fin + left;
            } else fin = fin + right;
        }
        return fin;
    }

    // 3 Создайте функцию, которая будет рекурсивно подсчитывать количество цифр числа.
    // Преобразование числа в строку не допускается, поэтому подход является рекурсивным.
    public static int digitsCount(long a) {
        return a < 10 ? 1 : digitsCount(a / 10) + 1;
    }

    // 4 Игроки пытаются набрать очки, формируя слова, используя буквы из 6-буквенного скремблированного слова.
    //Они выигрывают раунд, если им удается успешно расшифровать слово из 6 букв.

    public static int totalPoints(String[] guessedWords, String word) { // task 4
        int points = 0;
        boolean addPt = false;
        int additionallyPoints = 0;
        HashMap<Integer, Integer> addition = new HashMap<>();
        addition.put(3, 1);
        addition.put(4, 2);
        addition.put(5, 3);
        addition.put(6, 4);
        HashMap<Character, Integer> letters = new HashMap<>();
        for (char i: word.toCharArray()) {
            if (letters.containsKey(i)) {
                letters.put(i, letters.get(i) + 1);
            } else {
                letters.put(i, 1);
            }
        }
        for (String guessedWord: guessedWords) {
            HashMap<Character, Integer> currentLetters = new HashMap<>(Map.copyOf(letters));
            boolean check = true;
            if (guessedWord.length() == 6) {
                additionallyPoints++;
            }
            for (char i: guessedWord.toCharArray()) {
                if (guessedWord.equals(word)) {
                    addPt = true;
                }
                if (currentLetters.containsKey(i)) {
                    currentLetters.put(i, currentLetters.get(i) - 1);
                } else {
                    check = false;
                    break;
                }
            }
            if (currentLetters.containsValue(-1)) {
                check = false;
            }
            if (check) {
                points += addition.get(guessedWord.length());
            }
        }
        if (addPt) {
            points += (additionallyPoints * 50);
        }
        return points;
    }

    // 5
    public static String sumUp(int[] nums) { // task 5
        ArrayList<Integer[]> pairsIndexes = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) { // находятся индексы с элементами дающими 8
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (num1 + num2 == 8 && i != j) {
                    pairsIndexes.add(new Integer[]{i, j});
                }
            }
        }
        for (int i = 0; i < pairsIndexes.size(); i++) { // сортировка индексов по возрастанию разности
            Integer[] min = pairsIndexes.get(i);
            int minId = i;
            for (int j = i; j < pairsIndexes.size(); j++) {
                if (pairsIndexes.get(j)[1] - pairsIndexes.get(j)[0] < min[1] - min[0]) {
                    min = pairsIndexes.get(j);
                    minId = j;
                }
            }
            Integer[] temp = pairsIndexes.get(i);
            pairsIndexes.set(i, min);
            pairsIndexes.set(minId, temp);
        }
        int[][] res = new int[pairsIndexes.size()][2];
        for (int i = 0; i < res.length; i++) { // заполнение массива итоговыми числами по их индексам
            res[i][0] = nums[pairsIndexes.get(i)[0]];
            res[i][1] = nums[pairsIndexes.get(i)[1]];
        }
        return Arrays.deepToString(res);
    }

    // 6 Какой процент вы можете набрать на тесте, который в одиночку снижает средний балл по классу на 5%?
    // Учитывая массив оценок ваших одноклассников, создайте функцию, которая возвращает ответ.
    // Округлите до ближайшего процента.

    public static String takeDownAverage(String[] score) {
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            int t = Integer.parseInt(score[i].replace("%", ""));
            sum += t;
        }
        return (int) (((double) sum / score.length - 5) * (score.length + 1) - sum) + "%"; //- sum это вычитаем, сколько было, чтобы узнать, сколько получил ты
    }

    //7 Создайте функцию, которая будет шифровать и дешифровать сообщения с использованием шифра Цезаря.

    public static String caesarCipher(String mode, String sentence, int a) {
        String fin = "";
        if (mode.equals("decode")) a = -a;
        else if (!mode.equals("encode")) {
            throw new RuntimeException("Invalid mode");
        }
        for (char c : sentence.toUpperCase().toCharArray()) {
            int a1 = a;
            if (Character.isAlphabetic(c)) {
                if (c + a1 > 'Z') {
                    a1 = a1 - 'Z' + c - 1;
                    c = 'A';
                } else if (c + a1 < 'A') {
                    a1 = c - 'A' + a1 + 1;
                    c = 'Z';
                }
                fin = fin + (char) (c + a1);
            } else fin += c;
        }
        return fin;
    }

    // 8 Создайте метод для рекурсивного вычисления количества различных способов
    // как можно разместить k элементов из множества из n элементов без повторений

    public static int setSetup(int n, int k) {
        if (n < k) throw new RuntimeException("Invalid data");
        return k == 0 ? 1 : n * setSetup(n - 1, k - 1); //каждый раз уменьшать n, пока k не станет 0
    }

    // 9 В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух разных городах.
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        // Задаем формат даты
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-M-d HH:mm");

        Map<String, String> timeZ = new HashMap<>();
        timeZ.put("Los Angeles", "GMT-8:00");
        timeZ.put("New York", "GMT-5:00");
        timeZ.put("Caracas", "GMT-4:30");
        timeZ.put("Buenos Aires", "GMT-3:00");
        timeZ.put("London", "GMT+0:00");
        timeZ.put("Rome", "GMT+1:00");
        timeZ.put("Moscow", "GMT+3:00");
        timeZ.put("Tehran", "GMT+3:30");
        timeZ.put("New Delhi", "GMT+5:30");
        timeZ.put("Beijing", "GMT+8:00");
        timeZ.put("Canberra", "GMT+10:00");

        // Устанавливаем часовой пояс для города cityA
        TimeZone timeZoneA = TimeZone.getTimeZone(timeZ.get(cityA));
        inputFormat.setTimeZone(timeZoneA);

        // Устанавливаем часовой пояс для города cityB
        TimeZone timeZoneB = TimeZone.getTimeZone(timeZ.get(cityB));
        outputFormat.setTimeZone(timeZoneB);

        try {
            // Преобразуем входную строку времени в объект Date
            Date date = inputFormat.parse(timestamp);

            // Создаем календарь и устанавливаем дату и время
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Применяем часовой пояс cityA к календарю
            calendar.setTimeZone(timeZoneA);

            // Получаем дату и время в часовом поясе cityB
            return outputFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 10 новое число

    public static boolean isNew(int a) {
        String numberString = String.valueOf(a); //переделываем число в строку
        for (int i = 1; i < a; i++) {
            int c = i;
            String string = String.copyValueOf(numberString.toCharArray());
            List<Integer> sim = new ArrayList<>(); //содержит цифры числа c
            while (c > 0) {
                sim.add(c % 10);
                c = c / 10; //чтобы удалит последнюю цифру числа
            }
            for (Integer d : sim) {
                string = string.replaceFirst(d.toString(), ""); //замена первого вхождения строки на пустую
            }
            if (string.isEmpty()) return false; //если строка пустая
        }
        return true;
    }
}