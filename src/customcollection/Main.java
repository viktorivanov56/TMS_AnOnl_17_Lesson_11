package customcollection;


// Основной класс для примера использования CustomCollection
public class Main {


    public static void main(String[] args) {
        // Создание экземпляра CustomCollection с элементами типа Integer
        CustomCollection<Integer> customCollection = new CustomCollection<>();

        // Добавление элементов в коллекцию
        customCollection.add(1);
        customCollection.add(2);
        customCollection.add(3);

        // Вывод размера коллекции и элемента по индексу
        System.out.println("Collection size: " + customCollection.size());
        System.out.println("Element at index 1: " + customCollection.get(1));

        // Удаление элемента по индексу
        customCollection.remove(1);

        // Вывод размера коллекции после удаления
        System.out.println("Collection size after removal: " + customCollection.size());

        // Проверка наличия элементов в коллекции
        System.out.println("Contains 2: " + customCollection.contains(2));
        System.out.println("Contains 4: " + customCollection.contains(4));

        // Очистка коллекции и вывод размера после очистки
        customCollection.clear();
        System.out.println("Collection size after clearing: " + customCollection.size());
    }
}