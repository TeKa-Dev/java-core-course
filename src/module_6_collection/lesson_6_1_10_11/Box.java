package module_6_collection.lesson_6_1_10_11;
/*
Создайте дженерик класс Box, который может хранить в себе один объект класса,
которым он параметризирован в поле с названием object.
1. Класс должен быть параметризован T.
2. Поле должно быть приватным с именем object.
3. Класс должен иметь модификатор доступа по умолчанию.
 */

/*
В классе Box из прошлой задачи нужно добавить статический метод getBox(),
который возвращает пустой параметризованный объект типа Box,
1. Класс должен быть параметризован T.
2. Поле должно быть приватным с именем object.
3. Класс должен иметь публичный модификатор доступа.
4. Класс должен иметь публичный статический метод getBox().
5. метод getBox() должен работать согласно условию..
6. Класс Box должен быть статическим.
 */
class Box<T> {
    private T object;

    public T getObject() {
        return object;
    }

    Box<T> getBox() {
        return new Box<>();
    }

    static <T> Box<T> getTBox() {
        return new Box<>();
    }
}

