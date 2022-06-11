package module_5_io_file_system.lesson_5_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOStream {

    DataInputStream dis;
    DataOutputStream dos;

    // массив байтов в поток и получение из потока
    InputStream is = new ByteArrayInputStream(new byte[]{1, 2, 5, 3});
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    byte[] bytes = os.toByteArray();

    public static void main(String[] args) throws IOException {
        printFromFile("out-file.txt");
    }


    // печать в консоль строку из файла
    static void printFromFile(String fileName) throws FileNotFoundException {
        InputStream is = new FileInputStream(fileName);
        try (DataInputStream dis = new DataInputStream(is)) {
            System.out.print(dis.readInt());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("xuy znaet");
        }
    }

    // чтение и печать своего файла байткода
    static void printSelfByteCode() {
        try (InputStream is = IOStream.class.getResourceAsStream("Main.class")) {
            int r = is.read();
            while (r >= 0) {
                System.out.printf("%02x", r);
                r = is.read();
            }
        } catch (IOException e) {
            System.err.print("файл не найден");
        }
    }

    static void testIO() throws IOException {
        // создание потока на основе пути
        InputStream is = new FileInputStream("in-file.txt");
        // создание потока на основе объекта Path
        OutputStream os = Files.newOutputStream(Paths.get("out-file.txt"));

        System.out.println(copyInputToOutput(is, os));
    }


    // копирование входного потока в выходной и возврат итогового количества записанного
    static int copyInputToOutput(InputStream is, OutputStream os) throws IOException {
        int totalBytesWritten = 0;
        byte[] buffer = new byte[1024];
        int blockSize;

        while ((blockSize = is.read(buffer)) > 0) {
            System.out.println(blockSize);
            os.write(buffer, 0, blockSize);
            totalBytesWritten += blockSize;
        }
        return totalBytesWritten;
    }
}
