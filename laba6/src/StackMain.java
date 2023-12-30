public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(); //создаем экземпляр стека
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek()); //возвращ верх без удаление
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(5);
        System.out.println(stack.peek());
    }
}
