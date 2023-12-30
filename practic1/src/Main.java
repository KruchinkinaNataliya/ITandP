public class Main {
    public static void main(
            String[] args) {
        System.out.println("Задача 1");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println("...................");
        System.out.println("Задача 2");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println("...................");
        System.out.println("Задача 3");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println("...................");
        System.out.println("Задача 4");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println("...................");
        System.out.println("Задача 5");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("..................");
        System.out.println("Задача 6");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println("...................");
        System.out.println("Задача 7");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("...................");
        System.out.println("Задача 8");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println("...................");
        System.out.println("Задача 9");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println("...................");
        System.out.println("Задача 10");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));

    }

    public static double convert(int x) {
        return x * 3.785d;
    }

    public static int fitCalc(int time, int level) {
        return time * level;
    }

    public static int containers(int box, int beg, int barrel) {
        return box * 20 + beg * 50 + barrel * 100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x + y < z || x + z < y || y + z < x) {
            return "not a triangle";
        }
        else if (x == y && y == z) {
            return "isosceles"; //равносторонний
        }
        else if (x == y || y == z || z == x){
            return "equilateral"; //равнобедренный
        }
        else return "different-sided";
    }

    public static int ternaryEvaluation(int a, int b) { //тернарный оператор
        return a > b ? a : b;
    }

    public static int howManyItems(int n, double h, double w) {
        return (int) (n / h * w / 2);
    }

    public static int factorial(int f) {
        if (f <= 1) {
            return 1;
        }
        else {
            return f * factorial(f - 1);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int ticketSaler(int x, int cost) {
        return (int) (x * cost * 0.72);
    }

    public static int tables(int students, int tables) {
        if (tables * 2 > students) return 0;
        int ost = students - tables * 2;
        return ost % 2 == 0 ? ost / 2 : ost / 2 + 1;
    }
}