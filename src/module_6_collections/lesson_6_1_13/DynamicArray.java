package module_6_collections.lesson_6_1_13;

/*
Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray, который хранит
в себе массив, и имеет методы для добавления void add(T el), void remove(int index) удаления и извлечения T get(int index)
из него элементов, при переполнении текущего массива, должен создаваться новый, большего размера.
Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи можно воспользоваться
методами из класса java.util.Arrays. Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно

1. должен быть класс public static class DynamicArray
2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
3. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
4. класс DynamicArray должен  иметь публичный конструктор по умолчанию
5. работа методов должна соответствовать условию
 */
public class DynamicArray<T> {
    public static void main(String[] args) {
        DynamicArray<Integer> da = new DynamicArray<>();
        for (int i = 0; i <= 10; i++) {
            da.add(i);
        }
        da.remove(10);
        System.out.println(da.get(10));

        System.out.println(da);
    }

    private Object[] elements;
    private static final int DEFAULT = 10;
    private int size = -1;

    public DynamicArray() {
        this(DEFAULT);
    }

    public DynamicArray(int capacity) {
        elements = new Object[capacity];
    }

    public void add(T el) {
        int len = elements.length;
        if ((size + 1) == len) {                        // условие для замены массива на больший
            Object[] change = new Object[len + DEFAULT];
            System.arraycopy(elements, 0, change, 0, len);
            elements = change;
        }
        elements[++size] = el;
    }

    public void remove(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        while (index < size) {                    // цикл чтобы здвигать все элементы влево заполняя удаленное место
            elements[index] = elements[++index];
        }
        if (index == size) {                      // если удаляем последний элемент, то просто обнуляем его
            elements[index] = null;
            size--;
        }
    }

    public T get(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    @Override
    public String toString() {
        if (size == -1) { return "[]"; }
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; ; i++) {
            res.append(String.valueOf(elements[i]));
            if (i == size) { return res.append(']').toString(); }
            res.append(',');
        }
    }
}
