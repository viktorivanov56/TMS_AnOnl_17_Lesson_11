package customcollection;

// Объявление класса CustomCollection с использованием generics для обобщения типов
public class CustomCollection<T> {
    // Константа, представляющая размер массива по умолчанию
    private static final int DEFAULT_CAPACITY = 10;

    // Внутренний массив для хранения элементов
    private Object[] array;

    // Переменная для отслеживания текущего размера коллекции
    private int size;

    // Конструктор без параметров - создает массив размером по умолчанию
    public CustomCollection() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Конструктор с задаваемым размером внутреннего массива
    public CustomCollection(int initialCapacity) {
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    // Метод для добавления элемента в коллекцию
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    // Метод для удаления элемента по индексу
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        // Сдвигаем элементы влево, начиная с позиции index+1
        System.arraycopy(array, index + 1, array, index, size - index - 1);

        // Очищаем последний элемент
        array[--size] = null;
    }

    // Метод для получения элемента по индексу
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return (T) array[index];
    }

    // Метод для проверки наличия элемента в коллекции
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    // Метод для очистки коллекции
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // Приватный метод для автоматического расширения коллекции при добавлении элемента
    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = java.util.Arrays.copyOf(array, newCapacity);
        }
    }

    // Метод для получения размера коллекции
    public int size() {
        return size;
    }
}