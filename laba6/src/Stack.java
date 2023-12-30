public class Stack<T> {

    private final static int DEFAULT_CAPACITY=10; //начальная емкость стека
    private T[] data; //приватное поле data которое представляет массив элементов типа Т
    private int size;  //текущий размер стека

    public Stack(){ //конструктор, вызывается при создании нового объекта стека
        this.data=(T[]) new Object[DEFAULT_CAPACITY]; //приводится к типу Т
        this.size=0; //начальное значение, тк еще нет элементов
    }

    public void push(T element) {
        if(size==data.length){
            T[] newData =(T[]) new Object[size*10];

            for (int i = 0; i < size; i++) {
                newData[i]=data[i];
            }
            this.data=newData; //замена на новый массив
        }
        this.data[size]=element; //помещаем элемент в стек
        size++;
    }
    public T pop() {
        if(size==0){
            return null;
        }
        T el = data[size-1]; //получаем верхний элемент стека
        size--;
        return el;
    }
    public T peek() {
        if(size==0){
            return null;
        }
        return data[size-1]; //возвращ верх элемент, но не удаляем
    }
}
