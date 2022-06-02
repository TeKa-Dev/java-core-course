package III_base_of_OOP;

// Задача 3.3.12

/*
Создайте класс Human с полями возраст (age), имя (name), фамилия (secondName) и любимый вид спорта (favoriteSport).
Создайте 3 конструктора в классе Human, 1-ый - пустой, 2-ой, который конструирует Human’a от всех полей и третий,
который конструирует Human’a, от всех полей, кроме любимого вида спорта.

Для успешного тестирования решения важно объявлять аргументы в конструкторах именно в том порядке,
в котором они написаны в данном описании (возраст (age), имя (name), фамилия (secondName) и любимый вид спорта (favoriteSport))

В методе main создайте 3 экземпляра человека используя 3 этих разных конструктора. поля класса должны иметь размерность,
не превышающую необходимую. Класс должен быть объявлен статическим, метод main не должен находиться в классе,
поля класса должны иметь доступ только внутри класса

Требования:
1. Должен быть метод public static void main(String[] args)
2. Должен быть public static class Human
3. У класс Human должны быть поля
4. Класс Human должен иметь 3 конструктора
5. В методе main нужно создать три объекта класса Human тремя способами
*/

public class Humans {

    public static void main(String[] args) {
        Human newborn = new Human();
        Human boy = new Human((byte) 30, "Karaydar", "Temirov", "football");
        Human girl = new Human((byte) 28, "Rumilya", "Alieva");
    }

    public static class Human {
        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        Human() {
        }

        Human(byte age, String name, String secondName, String favoriteSport) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
            this.favoriteSport = favoriteSport;
        }

        Human(byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }
    }

}
