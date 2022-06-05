package III_base_of_OOP;

// Задача 3.5.6

import java.util.Arrays;

/*
Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности
ASCII-символов (их коды влезают в один байт) в массиве байт.
*/
public class AsciiCharSequence implements CharSequence {

    private final byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    public int length() {
        return bytes.length;
    }

    public char charAt(int index) {
        return (char) bytes[index];
    }

    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(bytes, start, end));
    }

    public String toString() {
        return new String(bytes);
    }
}
