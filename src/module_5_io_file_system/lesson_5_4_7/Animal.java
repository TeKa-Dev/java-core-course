package module_5_io_file_system.lesson_5_4_7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

/*
    Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
    Массив байт устроен следующим образом. Сначала идет число типа int, записанное при помощи
    ObjectOutputStream.writeInt(size). Далее подряд записано указанное количество объектов типа Animal,
    сериализованных при помощи ObjectOutputStream.writeObject(animal).
 */

public class Animal implements Serializable {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}


class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Animal an = new Animal("Dog");

        Path pathSeriaAnimal = Paths.get("in-file.txt");
        // запись обьекта в файл
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(pathSeriaAnimal));
        oos.writeInt(1);
        oos.writeObject(an);
        // чтение объекта из файла
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(pathSeriaAnimal));
        Animal anFromFile = (Animal) ois.readObject();

        test();
    }

    public static void test() throws IOException {
        Animal[] animalsIn = {
                new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalsIn.length);
        for (Animal animal : animalsIn) {
            oos.writeObject(animal);
        }
        oos.flush();
        oos.close();
        Animal[] animalsOut = deserializeAnimalArray(bai.toByteArray());

        System.out.println(Arrays.toString(animalsOut));
    }

public static Animal[] deserializeAnimalArray(byte[] data) {
    Animal[] animals;
    try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
        animals = new Animal[ois.readInt()];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = (Animal) ois.readObject();
        }
    } catch (RuntimeException | IOException | ClassNotFoundException e) {
        throw new IllegalArgumentException(e);
    }
    return animals;
}
}

