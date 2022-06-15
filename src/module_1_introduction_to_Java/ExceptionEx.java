package module_1_introduction_to_Java;

import java.io.Closeable;
import java.io.IOException;

public class ExceptionEx {

    ExceptionEx() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Object {
        throw new Object();
    }

    static class Object extends Throwable {}



    {   // можно поймать исключение в блоке инициализации
        try {
            throw new RuntimeException();
        } catch (RuntimeException re) {
            re.printStackTrace();
        }
    }

    // не срабатывание finally{} блока при бесконечном цикле в try{} или catch{} блоке
    static void finallyNoWork() {
        try {
            throw new RuntimeException();

        } catch (Throwable t) {
            while (true) {}     // бесконечный цикл

        } finally {
            System.out.println("message from finally");
        }
    }

    // исключение из ресурса будет подавлено в Throwable.addSuppressed(), получаем через Throwable.getSuppressed()
    static void suppressExc() throws Throwable {

        try (FirstResource fr = new FirstResource(); SecondResource sr = new SecondResource(fr)) {
            fr.method();
            sr.method();
            throw new NoSuchFieldException("первое исключение");

        } catch (NoSuchFieldException nse) {
            nse.getSuppressed()[0].printStackTrace();   // печать исключений, подавленных во время close() в обратном порядке
            nse.getSuppressed()[1].printStackTrace();   // получаем через Throwable.getSuppressed()
        }
    }

    // исключение из final покрывает исключение из try
    static void coverExc() throws Throwable {
        try {
            throw new NoSuchFieldException("первое исключение которое уходит в stackTrace");

        } catch (NoSuchFieldException nse) {
            throw new ArithmeticException("ловим первое и бросаем второе исключение");

        } finally {
                throw new IllegalArgumentException("третье исключение которое покрывает второе и выводится");

        }
    }




    static class MyException extends RuntimeException {
        public MyException(String message) {
            super(message);
        }
    }



    static class FirstResource implements AutoCloseable {
        public void method() {
            System.out.println("из FirstResource.method()");
        }

        @Override
        public void close() {
            throw new MyException("исключение из FirstResource.close()");
        }
    }



    static class SecondResource implements Closeable {

        public SecondResource(FirstResource fr) {
            System.out.println("SecondResource создан на FirstResource");
        }

        public void method() {
            System.out.println("из SecondResource.method()");
        }

        @Override
        public void close() throws IOException {
            throw new MyException("исключение из SecondResource.close()");

        }
    }

}
