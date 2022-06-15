package module_5_io_file_system.lesson_5_3_11;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример:
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".
 */
public class InStreamToString {

    public static void main(String[] args) throws IOException {
        InputStream in = new ByteArrayInputStream(new byte[]{48, 49, 10, 50, 51});
        InputStream is = new FileInputStream("in-file.txt");
        Charset ascii = StandardCharsets.US_ASCII;
        Charset utf = StandardCharsets.UTF_8;

        System.out.println(readAsString(is, utf));
    }


public static String readAsString(InputStream in, Charset charset) throws IOException {

    Reader r = new InputStreamReader(in, charset);
    Appendable res = new StringBuilder();

    for (int b; (b = r.read()) != -1; res.append((char) b)) {}

    return res.toString();

//    короткое решение
//   return new String(is.readAllBytes(), utf);
}



}
