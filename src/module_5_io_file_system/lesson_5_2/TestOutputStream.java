package module_5_io_file_system.lesson_5_2;

import java.io.*;

public class TestOutputStream {
    static OutputStream pip, byt, fil, obj, ftr, buf, dat, prt;

    static {
        try {
            pip = new PipedOutputStream();
            byt = new ByteArrayOutputStream();
            fil = new FileOutputStream("out-file.txt");
//            obj = new ObjectOutputStream();
            ftr = new FilterOutputStream(fil);
//        FilterOutputStream
            buf = new BufferedOutputStream(System.out);
            dat = new DataOutputStream(System.out);
            prt = new PrintStream(System.out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {

         fil.write(TestInputStream.byt.readAllBytes());
         fil.flush();
         fil.close();
    }
}
