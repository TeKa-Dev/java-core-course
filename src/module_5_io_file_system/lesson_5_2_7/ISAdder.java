package module_5_io_file_system.lesson_5_2_7;

import java.io.*;

public class ISAdder {

    public static void main(String[] args) throws IOException {
//        InputStream in = new FileInputStream("out-file.txt");
//        System.out.println(sumOfStream(in));

        InputStream stream = new ByteArrayInputStream(new byte[]{5, 6, -4, 68});

        System.out.print(sumOfStream(stream));
    }


//static public int sumOfStream(InputStream in) throws IOException {
//    int res = 0;
//        for (int r = in.read(); r != -1; r = in.read()) {
//            res += (byte) r;
//        }
//    return res;
//}

static public int sumOfStream(InputStream inputStream) throws IOException {
    int result = 0;
    for (int b; ; result += (byte) b) {
        b = inputStream.read();
        if (b == -1) {
            break;
        }
    }
    return result;
}

}
