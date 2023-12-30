import java.util.Arrays;
import java.util.Random;



public class Main {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Doonal"));
        System.out.println(duplicateChars("orange"));
        System.out.println("...................");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("...................");
        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));
        System.out.println("...................");
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 6}));
        System.out.println("...................");
        System.out.println(Arrays.toString(indexMult(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(indexMult(new int[]{3, 3, -2, 408, 3, 31})));
        System.out.println("...................");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println("...................");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println("...................");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(7));
        System.out.println(pseudoHash(0));
        System.out.println("...................");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("...................");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));}
    //1.	Создайте функцию, которая определяет, есть
    // ли в строке повторяющиеся символы.
    public static boolean duplicateChars(String str) {
        str = str.toLowerCase(); //преобразует все символы в строке str в нижний регистр
        for (int i = 0; i < str.length(); i++) { //перебирает символы в строке по одному
            if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))) { //chatat возвр. из строки символ который передаешь
                return true;
            }
        }
        return false;
    }

    //2.	Создайте метод, который принимает строку (фамилию и имя
    // человека) и возвращает строку с инициалами без пробелов.
    public static String getInitials(String name) {
        String initials = ""; //пустая строка, куда будут добавляться инициалы
        for (String word : name.split(" ")) {//разбивает на отдельные слова
            initials += word.charAt(0); //первый символ текущего слова, добавляет его к переменной
        }
        return initials;
    }
    //3.	Создайте функцию, которая принимает массив и
    // возвращает разницу между суммой четных и нечетных.
    public static int differenceEvenOdd(int[] arr) {
        int evenSum = 0; //чет
        int oddSum = 0; //нечет
        for (int num : arr) { //перебирает все элементы массива,
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        return Math.abs(evenSum - oddSum);
    }
    //4.	Создайте функцию, которая принимает массив и возвращает
    // true, если в массиве есть хотя бы один элемент,
    // который равен среднему арифметическому всех элементов массива,
    // и false в противном случае.
    public static boolean equalToAvg(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double avg = (double) sum / arr.length;
        for (int num1 : arr) {
            if (num1 == avg) {  //num это элемент
                return true;
            }
        }
        return false;
    }
    //5.	Создайте метод, который берет массив целых чисел и
    // возвращает массив, в котором каждое целое число умножено на
    // индекс этого числа в массиве.
    public static int[] indexMult(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * i;//то, что лежит в ячейке * на индекс этой ячейки
        }
        return result;
    }
    //6.	Создайте метод, который принимает строку в качестве
    // аргумента и возвращает ее в обратном порядке.
    public static String reverse(String str) {
        char[] chars = str.toCharArray(); //превращает в массив символов строку. char один символ
        String finih = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            finih = finih + chars[i];
        }
        return finih;
    }

    //7.	Создайте функцию, которая при заданном числе возвращает
    // соответствующее число Трибоначчи. Последовательность
    // Трибоначчи начинается с элементов «0, 0, 1».
    public static int Tribonacci(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int[] sequence = new int[n];
            sequence[0] = 0;
            sequence[1] = 0;
            sequence[2] = 1;
            for (int i = 3; i < n; i++) {
                sequence[i] = sequence[i - 1] + sequence[i - 2] + sequence[i - 3];
            }
            return sequence[n-1];
        }
    }

    //8.	Хэш-суммы в системе контроля версий (например, Git) выглядят как
    // уникальная строка из символов (от a до f) и цифр (от 0 до 9)
    // длиной в 40 элементов. В Git используется SHA-1 хэш-функция для создания
    // хэшей коммитов.
    //
    //Создайте функцию, генерирующую квази-хэш заданной пользователем длины.
    public static String pseudoHash(int length) {
        String hash = "";
        String characters = "abcdef0123456789";
        Random random = new Random();//переменная
        for (int i = 0; i < length; i++) {
            hash += characters.charAt(random.nextInt(characters.length()));
        }
        return hash;
    }

    //9.	Напишите функцию, которая находит слово "help" в данной
    // строке-стенограмме автоматизированного телефонного диспетчера
    // службы спасения. Ответьте "Вызов сотрудника", если слово
    // найдено, в противном случае – "Продолжайте ожидание".
    public static String botHelper(String str) {
        boolean isHelp = false;
        for (String s:str.toLowerCase().replaceAll(".","").split(" ")) {
          if(s.equals("help")){
              isHelp=true;
          }
        }
        if (isHelp) {
            return "Calling for a staff member";
        } else {
            return "Keep waiting";
        }
    }

    //10.	Создайте функцию, которая принимает две строки и
    // определяет, являются ли они анаграммами.
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toUpperCase().toCharArray(); //CharArray массив символов
        char[] arr2 = str2.toUpperCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2); //сравнение
    }
}