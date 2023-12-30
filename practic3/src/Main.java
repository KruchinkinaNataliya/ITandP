import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println("...................");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(stringTransform("bookkeeperr"));
        System.out.println("...................");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println("...................");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("...................");
        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));
        System.out.println("...................");
        System.out.println(Arrays.toString(salesData(new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}})));
        System.out.println(Arrays.toString(salesData(new String[][]{{"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}})));
        System.out.println("...................");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("...................");
        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10}));
        System.out.println("...................");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println("...................");
        printArray2(dataScience(new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}}));
        printArray2(dataScience(new int[][]{{6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}}));


    }

    public static String replaceVovels(String s) {
        String vovels = "aeuyioAEUYIO";
        for (char v : vovels.toCharArray()) {
            s = s.replace(v, '*');
        }
        return s;
    }

    public static String stringTransform(String s) {
        StringBuilder fin = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length - 1) {
            if (chars[i] == chars[i + 1]) {
                fin.append("Double");
                fin.append(Character.toUpperCase(chars[i]));
                i = i + 2;
            } else {
                fin.append(chars[i]);
                i++;
            }
        }
        if(chars[chars.length-1] != Character.toLowerCase(fin.charAt(fin.length()-1))){ //последняя буква в слове с буквой, которую уже добавили
            fin.append(chars[chars.length - 1]);}
        return fin.toString();
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= w && c <= h) || (b <= w && c <= h) || (b <= w && a <= h) || (c <= w && a <= h) || (c <= w && b <= h);
    }

    public static boolean numCheck(int a) {
        int sum = 0;
        int b = a;
        while (a != 0) {
            sum += (int) Math.pow(a % 10, 2);
            a = a / 10;
        }
        return b % 2 == sum % 2;
    }

    public static int countRoots(int[] c) {
        int d = c[1] * c[1] - 4 * c[0] * c[2];
        if (d > 0) {
            return 2;
        } else if (d == 0) {
            return 1;
        } else return 0;
    }

    public static String[] salesData(String[][] mas) {
        Set<String> uniqShopName = new HashSet<>(); //хэшсет упорядоченное
        for (String[] productInfo : mas) {
            for (int i = 1; i < productInfo.length; ++i) {
                uniqShopName.add(productInfo[i]);
            }
        }

        List<String> result = new ArrayList<>(); //лист динамисческий массив, длина может меняться
        for (String[] productInfo : mas) {
            if (productInfo.length - 1 == uniqShopName.size()) {
                result.add(productInfo[0]);
            }
        }

        return result.toArray(new String[0]);
    }

    public static boolean validSplit(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) { //последняя с первой следующего
                return false;
            }
        }
        return true;
    }

    public static boolean waveForm(int[] mas) {
        boolean fin = true;

        // 2>1<2>1<2
        for (int i = 1; i < mas.length; i += 2) {
            if (mas[i - 1] < mas[i]) { //предыдущий элемент и нынешний
                fin = false;
                break;
            }

            if (i != mas.length - 1 && mas[i + 1] < mas[i]) { //за границы массива и снова сравниваем
                fin = false;
                break;
            }
        }

        if (fin) {
            return fin;
        }
        fin = true;

        // 1<2>1<2>1
        for (int i = 1; i < mas.length; i += 2) {
            if (mas[i - 1] > mas[i]) {
                fin = false;
                break;
            }

            if (i != mas.length - 1 && mas[i + 1] > mas[i]) {
                fin = false;
                break;
            }
        }

        return fin;
    }

    public static char commonVovel(String s) {
        String vol = "aeuyio";
        int max = 0;
        char fin = 'a';
        for (char ch : vol.toCharArray()) { //ch гласная
            int c = 0; //кол-во самой ггласной
            for (char sim : s.toLowerCase().toCharArray()) {
                if (sim == ch) {
                    c++;
                }
            }
            if (c > max) {
                max = c;
                fin = ch;
            }
        }
        return fin;
    }

    public static int[][] dataScience(int[][] mas){
        for (int i = 0; i < mas.length; i++) { //по столбцам
            int sum = 0; //сумма всего стобца
            for (int j = 0; j < mas.length; j++) {
                sum += mas[j][i];
            }
            mas[i][i] = Math.round((float) (sum - mas[i][i]) / (mas.length-1));
        }
        return mas;
    }

    //функция не относиться к заданию, была сделана только для более легкого вывода двумерного массива
    private static void printArray2(int[][] mas){
        System.out.println("[");
        for (int[] m:mas) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println("]");
    }
}
