package module_5_io_file_system.lesson_5_2;

import java.io.*;

public class TestReader {
    static PipedReader pip;
    static CharArrayReader cha;
    static StringReader str;
    static BufferedReader buf;
    static InputStreamReader inp;
    static FileReader fil;

    static {
        try {
                                                                // PushbackReader extends FilterReader
            pip = new PipedReader();
            cha = new CharArrayReader(new char[]{'a', 'b', 'c'});
            str = new StringReader("def ghi");
            buf = new BufferedReader(str);                      // LineNumberReader extends
            inp = new InputStreamReader(TestInputStream.byt);
            fil = new FileReader("in-file.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println((char) cha.read());
//        System.out.println((char) str.read());

        char[] res = new char[20];
//        System.out.println(str.read(res));
//        System.out.println(Arrays.toString(res));

        System.out.println(fil.read(res));
        System.out.println(new String(res));
    }
}
