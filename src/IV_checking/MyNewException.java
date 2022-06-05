package IV_checking;

// Задача 4.1.7

/*
Создайте новое проверяемое исключение MyNewException, и создайте метод testExp(),
который выбрасывает MyNewException при вызове.
 */

class Main {

    public static void main(String[] args) throws MyNewException {
        new Main().testExp();
    }

    public void testExp() throws MyNewException {
        throw new MyNewException();
    }

}

class MyNewException extends Exception {
}
