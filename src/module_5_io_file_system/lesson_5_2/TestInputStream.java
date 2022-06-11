package module_5_io_file_system.lesson_5_2;

import java.io.*;

public class TestInputStream {
    static InputStream seq, pip, byt, fil, obj, ftr, buf, dat, pus;

    static {
        try {
            pip = new PipedInputStream();
            seq = new SequenceInputStream(System.in, pip);
            byt = new ByteArrayInputStream(new byte[]{-128, -1, 0, 1, 127});
            fil = new FileInputStream("in-file.txt");
//            obj = new ObjectInputStream();
//        ftr = new FilterInputStream();
            buf = new BufferedInputStream(byt);
            dat = new DataInputStream(fil);
            pus = new PushbackInputStream(pip);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

//        byte b = (byte) byt.read();                     // возвращает первый байт в виде int
//        int c = byt.available();                        // возвращает количество доступных байтов
//        byte[] arr = new byte[c];
//        int i = byt.read(arr);                          // записывает байты в массив и вернет их количество
//        byt.reset();                                    // пересобирает поток
//        byte[] out = byt.readAllBytes();                // готовый массив байт из потока
//        byt.readNBytes(arr, 0, 3);

//        byte[] fb = fil.readAllBytes();

    }

    static char[] scanSystemIn() throws IOException {
        char[] buffer = new char[10];
        int i = 0;
        while (true){
            buffer[i] = (char) System.in.read();
            if (buffer[i] == '\n' || i == 9) break;
            i++;
        }
        return buffer;
    }


}
