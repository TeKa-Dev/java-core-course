package module_5_io_file_system.lesson_5_2;

import java.io.*;

public class TestWriter {
    static Writer pip, cha, str, buf, out, fil;
    static {
        try {
            pip = new PipedWriter();
            cha = new CharArrayWriter();
            str = new StringWriter();
            buf = new BufferedWriter(str);
            out = new OutputStreamWriter(TestOutputStream.fil);
            fil = new FileWriter("out-file.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        char[] arr = new char[19];
        TestReader.fil.read(arr);
        fil.write(arr);

        fil.append(" abc def");
        fil.flush();
        fil.close();
    }
}
