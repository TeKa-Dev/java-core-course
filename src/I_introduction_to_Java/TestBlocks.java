package I_introduction_to_Java;
/*
Тестирование вызовов блоков в классах родителя и наследника
 */

public class TestBlocks {
    public static void main(String[] args) {

        Child ch = new Child();
        ch.method(null);
        ch.stcMethod(null);    // тоже, что   Child.stcMethod(null);

        System.out.println();

        Parent pc = new Child();
        pc.method(null);
        pc.stcMethod(null);    // тоже, что   Parent.stcMethod(null);

        System.out.println();

        Parent pp = new Parent();
        pp.method(null);
        pp.stcMethod(null);    // тоже, что   Parent.stcMethod(null);
    }
}



class Parent {

    static {System.out.println("static in Parent");}

    {System.out.println("non static in Parent");}

    Parent() {System.out.println("constructor in Parent");}

    void method(String s) {System.out.println((s == null) ? "method in Parent" : s);}

    static void stcMethod(String s) {System.out.println((s == null) ? "stcMethod in Parent" : s);}
}

class Child extends Parent {

    static {System.out.println("static in Child");}

    {System.out.println("non static in Child");}

    Child() {System.out.println("constructor in Child");}

    @Override
    void method(String s) {super.method("method in Child");}

    // Shadowing   не переопределение, а перекрытие  нельзя использовать super.
    static void stcMethod(String s) {Parent.stcMethod("stcMethod in Child");}
}
