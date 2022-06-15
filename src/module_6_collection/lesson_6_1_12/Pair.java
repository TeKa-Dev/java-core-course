package module_6_collection.lesson_6_1_12;

/*
Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов
и не запрещающий элементам принимать значение null.
Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
Конструктор должен быть закрытым (private).
 */
public class Pair<F, S> {

    public static void main(String[] args) {
//      С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
        Pair<Integer, String> pair = Pair.of(1, "hello");
        System.out.println(pair.getFirst()); // 1
        System.out.println(pair.getSecond()); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        System.out.println(pair.equals(pair2)); // true!
        System.out.println(pair.hashCode() == pair2.hashCode()); // true!
    }

    private final F first;
    private final S second;

    private Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public static <F, S> Pair<F, S> of(F first, S second) {
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        if (first != null ? !first.equals(p.first) : p.first != null) {
            return false;
        }
        return second != null ? second.equals(p.second) : p.second == null;
    }
    @Override
    public int hashCode() {
        return  31 * (first != null ? first.hashCode() : 0) + (second != null ? second.hashCode() : 0);
    }

}

