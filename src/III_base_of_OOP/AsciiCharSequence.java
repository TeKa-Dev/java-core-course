package III_base_of_OOP;

// Задача 3.5.6

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

        byte[] res = new byte[end - start];     // создаем новый массив байтов в него будем собирать рузультат
                                                // его длина равняется разнице между индексами начала и конца
        for (int i = 0; i < res.length; i++) {  // проходим по этому массиву

            res[i] = bytes[start];              // ложим в нее байты из объекта, начиная с индекса start
            start++;
        }
        return new AsciiCharSequence(res);
    }

    public String toString() {
        return new String(bytes);
    }
}
