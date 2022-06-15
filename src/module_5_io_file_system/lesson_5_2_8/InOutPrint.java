package module_5_io_file_system.lesson_5_2_8;

import java.io.*;

/*
Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает InputStream и OutputStream,
считывает все байты из inputStream и записывает в OutputStream только четные.
 */
public class InOutPrint {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("out-file.txt");
        OutputStream out = new FileOutputStream("in-file.txt");
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        while (true) {
            int v = inputStream.read();
            if (v == -1) {
                break;
            }
            if (((v = (byte) v) % 2) == 0) {
                outputStream.write(v);
            }
            outputStream.flush();
        }
    }

    public static void printSymbolCode(char sym) throws IOException {
        InputStream bas = new ByteArrayInputStream(String.valueOf(sym).getBytes());
        int b;
        while ((b = bas.read()) != -1)
            System.out.print(b + " ");
    }

}
