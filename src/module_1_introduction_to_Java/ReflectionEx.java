package module_1_introduction_to_Java;

import java.lang.reflect.Field;

public class ReflectionEx {

    public static void main(String[] args) throws NoSuchFieldException {
        // получение приватного поля при помощи рефлексии
        Field field = ReflectionEx.class.getDeclaredField("prvInt");
        field.setAccessible(true);

//        System.out.println(field.get(new TestReflection()));
    }
}

class Rabbit {
    private final int prvInt = 4;

//    public int getPrvInt() {
//        return prvInt;
//    }
}
