package module_6_collections.lesson_6_1_13;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
        System.out.println(da);
        da.remove(10);
        da.remove(0);
//        System.out.println(da.get(10));

        System.out.println(da);
    }

    private T[] elements = (T[])new Object[10];
    private int size = -1;

    public void add(T el) {
        int len = elements.length;
        if ((size + 1) == len) {
            Object[] change = new Object[len * 10];
            System.arraycopy(elements, 0, change, 0, len);
            elements = (T[]) change;
        }
        elements[++size] = el;
    }

    public void remove(int index) {
        System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
    }

    public T get(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public String toString() {
        if (size == -1) {
            return "[]";
        }
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; ; i++) {
            res.append(String.valueOf(elements[i]));
            if (i == size) {
                return res.append(']').toString();
            }
            res.append(',');
        }
    }
}
