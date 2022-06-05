package I_introduction_to_Java;

import java.lang.reflect.Field;

public class TestExample {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Integer integer = null;
//      int intFromInteger = integer;           // NullPointerException

        char e = (args.length != 0 ? 5 : 'd');   // оба операнда тернарного оператора должны быть совместимого типа
//        System.out.println((int) e);


        TestInterface ti = () -> TestInterface.B;
//        System.out.println(I_introduction_to_Java.TestInterface.someInt(ti));

        System.out.println(TestInterface.stcInt(ti));


        TestAbstract ta = new TestAbstract((byte) 5) {
            @Override
            byte absByte() {
                return 0;
            }

            @Override
            byte abtByte() {
                return 0;
            }
        };
//        System.out.println(ta.finByte());

        // получение приватного поля при помощи рефлексии
        Field field = TestReflection.class.getDeclaredField("prvInt");
        field.setAccessible(true);

//        System.out.println(field.get(new TestReflection()));

    }


    int returnFromTernary(int x) {
//      x < 1 ? return 1 : return 0;
        return x < 1 ? 1 : 0;
    }

}
