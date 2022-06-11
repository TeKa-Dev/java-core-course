package module_4_checking;

// Задача 4.1.8

/*
Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
 */

public class CallerClassAndMethodName {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] sts = new Throwable().getStackTrace();
        return (sts.length > 2) ? sts[2].getClassName() + '#' + sts[2].getMethodName() : null;
    }
}